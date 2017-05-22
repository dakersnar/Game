package entities;

import java.awt.Graphics;
import java.util.ArrayList;

import main.Character;
import main.Phase2;
import main.RectHitbox;
import gfx.Assets;
import gfx.Sound;

public class Enemy {
	int delay = 0;
	String direction = "R";
	String direction2 = "R";
	int xi;
	int yi;
	double x;
	double y;
	int height;
	int width;
	int type;
	int health;
	int hi;
	int range;
	boolean dead=false;
	int counter=0;
	public static ArrayList<BadProjectile> p=new ArrayList<BadProjectile>();
	String tempdirect="R";
	
	RectHitbox hitbox;
	
	public Enemy(int xi, int yi, int width, int height, int type, int health, int range)
	{
		this.xi=xi;
		this.yi=yi;
		x=xi;
		y=yi;
		this.width=width;
		this.height=height;
		this.type=type;
		this.health=health;
		hi=health;
		this.range=range;
		
		
		if(type==1)
		{
			
			hitbox = new RectHitbox(x+20,y,width-40,height);
		}
		if(type==2)
		{
			hitbox = new RectHitbox(x,y,width,height);
		}
	}
	
	
	public void update(){
		
		if(type==1&&health>10)
		{
			
			if(counter==0)
				Sound.playSound("res/sound/Haha1.wav");
			if(counter==200)
				Sound.playSound("res/sound/Haha2.wav");
			if(counter==400)
				Sound.playSound("res/sound/get_back_here.wav");

			if(counter==600)
				counter=-1;
			counter++;
			

			
			if(this.x+width/2 < (Character.x))
			{
				this.x+=1;
			}
			if(this.x+width/2 > (Character.x))
			{
				this.x-=1;
			}
			if(this.y+height/4 < (Character.y))
			{
				this.y+=.5;
			}
			if(this.y+height/4 > (Character.y))
			{
				this.y-=.5;
			}
			hitbox.setX(x+20);
			hitbox.setY(y);
		}
		if(type==1 && health<=10)
		{
			x=xi;
			y=yi;
			hitbox.setX(xi+20);
			hitbox.setY(yi);
			Phase2.update();
			
			
		}
		if(type==2 && !dead)
		{
			if(Character.y>y && Character.y<(y+height))
			{
				shoot();
				
			}
			else
				walk();
		
		hitbox.setX(x);
		hitbox.setY(y);
		
		}
		for (int i=0;i<p.size();i++)
		{
			p.get(i).update();
		}
		
		
	}
	
	
	private void walk() {
		direction=direction2;
		if(direction2.equals("R"))
		{
			x++;
			
		}
		if(direction2.equals("L"))
		{
			x--;
		}
		if(x==xi+range+10)
		{
			direction2="L";
	

		}
		if(x==xi-10)
		{
			direction2="R";
			

		}
		
		delay=0;
		
	}


	private void shoot() {
		
		
		if(delay==0)
		{
			
			if(Character.x>x)
			{
				Sound.playSound("res/sound/HaHaV.wav");

				p.add(new BadProjectile((int)x,(int)y+height/2,20,6,1,1));
				direction="R";
					
						
			}
			if(Character.x<x)
			{
				Sound.playSound("res/sound/HaHaV2.wav");
				p.add(new BadProjectile((int)x,(int)y+height/2,20,6,-1,1));
				direction="L";

					
			}
			
		}
		
		delay++;
		if(delay==100)
			delay=0;
			
		
	}


	public void render(Graphics g){
		
		if(type==1 && health<=10)
		{
			Phase2.render(g);
		}
		if(type==1&&!dead){
			g.drawImage(Assets.draganski,(int)x,(int)y,width,height,null);
		}
		if(type==2 && !dead && direction.equals("R"))
		{
			g.drawImage(Assets.docVR,(int)x,(int)y,width,height,null);
			
		}
		if(type==2 && !dead && direction.equals("L"))
		{
			g.drawImage(Assets.docVL,(int)x,(int)y,width,height,null);
			
		}
		
			for (int i=0;i<p.size();i++)
			{
				p.get(i).render(g);
				
			}
		
		
	}


	public void hit() {
		health--;
		if(health==0)
		{
			dead=true;
			if(type==1)
				Sound.playSound("res/sound/Game_Sucks.wav");
			if(type==2)
				Sound.playSound("res/sound/Ow.wav");
			
		}
		
	}


	public void reset() {
		
		health=hi;
		x=xi;
		y=yi;
		dead=false;
		direction="R";
		Phase2.reset();
		counter=0;
		p.clear();
	}
	
}

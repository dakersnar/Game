package entities;

import java.awt.Graphics;
import main.Character;
import main.Phase2;
import main.RectHitbox;
import gfx.Assets;

public class Enemy {
	int xi;
	int yi;
	double x;
	double y;
	int height;
	int width;
	int type;
	int health;
	int hi;
	boolean dead=false;
	RectHitbox hitbox;
	
	public Enemy(int xi, int yi, int width, int height, int type, int health)
	{
		this.xi=xi;
		this.yi=yi;
		x=yi;
		y=yi;
		this.width=width;
		this.height=height;
		this.type=type;
		this.health=health;
		hi=health;
		
		if(type==1)
		{
			hitbox = new RectHitbox(x+20,y,width-40,height);
		}
	}
	
	
	public void update(){
		
		if(type==1&&health>10)
		{
			
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
		
	}
	
	
	public void render(Graphics g){
		
		if(type==1 && health<=10)
		{
			Phase2.render(g);
		}
		if(type==1&&!dead){
			g.drawImage(Assets.draganski,(int)x,(int)y,width,height,null);
		}
		
	}


	public void hit() {
		health--;
		if(health==0)
		{
			dead=true;
		}
		
	}


	public void reset() {
		health=hi;
		x=xi;
		y=yi;
		dead=false;
		Phase2.reset();
	}
	
}

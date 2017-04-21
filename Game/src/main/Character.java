package main;


import java.awt.Graphics;
import java.awt.event.KeyEvent;

import entities.Things;
import gfx.Assets;





public class Character{
	
	static int x=100;
	
	static int yspeed=0;
	static int z=Launcher.y;
	
	static int height=46;
	static int width=33;
	static int y=z-height;
	static String direction="R";

	static RectHitbox hb=new RectHitbox(x,y,width,height);
	public static void update() {
		
		if(y>z-height)
		{
			
		}
		else
		{
		
		
		y=49;
		
		hb.setX(x);
		hb.setY(y);
		if (hb.collide(Things.z.hitbox))
		{
			y--;
		}
		}
		
		
		
		
		
	
		
		if(Handler.km.isKeyPressed(KeyEvent.VK_A))
		{
			x-=2;
			hb.setX(x);
			hb.setY(y);
			if (hb.collide(Things.z.hitbox))
			{
				x+=2;
			}
			direction="L";
			
				
			
	
		}
		if(Handler.km.isKeyPressed(KeyEvent.VK_D))
		{
			x+=2;
			hb.setX(x);
			hb.setY(y);
			if (hb.collide(Things.z.hitbox))
			{
				x-=2;
			}
			
			direction="R";
			
		
		}
		
	
		}
	public static void render(Graphics g)
		{
		hb.setX(x);
		hb.setY(y);
		if (direction.equals("R"))
			g.drawImage(Assets.l,x,y,width,height,null);
		if (direction.equals("L"))
			g.drawImage(Assets.i,x,y,width,height,null);
		
		}
	
	
}

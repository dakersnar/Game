package entities;

import java.awt.Graphics;


import gfx.Assets;
import main.RectHitbox;

public class Spike {
	int x;
	int y;
	int width;
	int height;
	int type;
	public RectHitbox hitbox;
		public Spike(int x, int y, int width, int height, int type)
	   {
	     	this.x=x;
	     	this.y=y;
	     	this.width=width;
	     	this.height=height;
	     	this.type=type;
	     	
	    hitbox = new RectHitbox(x,y,width,height);
	   }




		public void render(Graphics g)
		{
			if(type==1)
			{
				g.drawImage(Assets.spike,x,y,width,height,null);
			}
			if(type==2)
			{
				g.drawImage(Assets.spike2,x,y,width,height,null);
			}
	    }
}

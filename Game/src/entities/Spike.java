package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import gfx.Assets;
import main.RectHitbox;

public class Spike {
	int x;
	int y;
	int width;
	int height;
	public RectHitbox hitbox;
	//Color shapeColor = Color.red;
	public Spike(int x, int y, int width, int height)
	   {
	     	this.x=x;
	     	this.y=y;
	     	this.width=width;
	     	this.height=height;
	     	
	    hitbox = new RectHitbox(x,y,width,height);
	   }



		// This method draws the circle
		public void render(Graphics g)
		{
			g.drawImage(Assets.spike,x,y,width,height,null);
	    }
}

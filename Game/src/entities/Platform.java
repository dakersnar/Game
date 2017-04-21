package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


import main.RectHitbox;
public class Platform {
	int x;
	int y;
	int width;
	int height;
	public RectHitbox hitbox;
	Color shapeColor = Color.blue;
	public Platform(int x, int y, int width, int height)
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
		   	Graphics2D g2 = (Graphics2D) g;

		    // Creates an instance of the object ellipse
			// and then displays it to the frame.
		   
	        Rectangle rect= new Rectangle(x,y,width,height);
	        g2.setColor(shapeColor);
	        g2.fill(rect);
	        g2.draw(rect);
	    }
}

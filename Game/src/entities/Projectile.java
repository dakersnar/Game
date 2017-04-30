package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


import main.RectHitbox;
public class Projectile {
	int x;
	int y;
	int width=10;
	int height=3;

	int speed;
	public RectHitbox hitbox;
	Color shapeColor = Color.red;
	public Projectile(int x, int y, int speed)
	   {
	     	this.x=x;
	     	this.y=y;
	     	this.speed=speed;
	     	
	     	
	     	hitbox = new RectHitbox(x,y,width,height);
	   }


		public void update()
		{
			
			x+=speed;
			hitbox.setX(x);
			hitbox.setY(y);
			
			
		}
		
		public void render(Graphics g)
		{
		   	Graphics2D g2 = (Graphics2D) g;

		   
		   
	        Rectangle rect= new Rectangle(x,y,width,height);
	        g2.setColor(shapeColor);
	        g2.fill(rect);
	        g2.draw(rect);
	        
	        if (Things.checkCollisions(hitbox))
			{
				Things.removeProjectile(this);
			}
	    }
		
}

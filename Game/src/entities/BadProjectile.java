package entities;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


import main.RectHitbox;
public class BadProjectile {
	int x;
	int y;
	int width;
	int height;

	public int speed;
	public RectHitbox hitbox;
	Color shapeColor = Color.orange;
	private int direction;
	public BadProjectile(int x, int y, int width, int height, int speed, int direction)
	   {
	     	this.x=x;
	     	this.y=y;
	     	this.width=width;
	     	this.height=height;
	     	this.speed=speed;
	     	this.direction=direction;
	     	
	     	
	     	
	     	hitbox = new RectHitbox(x,y,width,height);
	   }


		public void update()
		{
			if(direction==1)
			{
				x+=speed;
				hitbox.setX(x);
				hitbox.setY(y);
			}
			if(direction==2)
			{
				y+=speed;
				hitbox.setX(x);
				hitbox.setY(y);
			}
			
		}
		
		public void render(Graphics g)
		{
		   	Graphics2D g2 = (Graphics2D) g;

		   
		   
	        Rectangle rect= new Rectangle(x,y,width,height);
	        g2.setColor(shapeColor);
	        g2.fill(rect);
	        g2.draw(rect);
	        
	       
	        
	    }
		
		
}

package main;


public class RectHitbox {
	double x;
	double y;
	double width;
	double height;
	

	
	 public RectHitbox(double x2,double y2,double width2,double height2)
	   {
	     	setY(y2);
	     	setX(x2);
	     	setWidth(width2);
	     	setHeight(height2);
	   }

	public double getY() {
		return y;
	}

	public void setY(double y2) {
		this.y = y2;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width2) {
		this.width = width2;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height2) {
		this.height = height2;
	}

	public double getX() {
		return x;
	}
	public void setX(double x2) {
		this.x = x2;
	}
	public boolean collide(RectHitbox d)
	{
		if (this.isIn(d.x,d.y)==true || this.isIn(d.x+d.width,d.y)==true || this.isIn(d.x+d.width,d.y+d.height)==true || this.isIn(d.x,d.y+d.height)==true)
		{
			
			return true;
		}
		if (d.isIn(this.x,this.y)==true || d.isIn(this.x+this.width,this.y)==true || d.isIn(this.x+this.width,this.y+this.height)==true || d.isIn(this.x,this.y+this.height)==true)
		{
	
			return true;
		}
		
		
		return false;
		
		
	}
	public boolean isIn(double x2, double y2)
	{
		if(x2<=(width+this.x) && x2>=this.x && y2<=(height+this.y) && y2>=this.y)
			return true;
		return false;
	}

}

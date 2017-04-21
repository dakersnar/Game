package main;


public class RectHitbox {
	int x;
	int y;
	int width;
	int height;
	

	
	 public RectHitbox(int x,int y,int width,int height)
	   {
	     	setY(y);
	     	setX(x);
	     	setWidth(width);
	     	setHeight(height);
	   }

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public boolean collide(RectHitbox d)
	{
		if (this.isIn(d.x,d.y)==true || this.isIn(d.x+d.width,d.y)==true || this.isIn(d.x+d.width,d.y+d.height)==true || this.isIn(d.x,d.y+d.height)==true)
		{
			System.out.println("1");
			return true;
		}
		if (d.isIn(this.x,this.y)==true || d.isIn(this.x+this.width,this.y)==true || d.isIn(this.x+this.width,this.y+this.height)==true || d.isIn(this.x,this.y+this.height)==true)
		{
			System.out.println("2");
			return true;
		}
		
		
		return false;
		
		
	}
	public boolean isIn(int x, int y)
	{
		if(x<=(width+this.x) && x>=this.x && y<=(height+this.y) && y>=this.y)
			return true;
		return false;
	}

}

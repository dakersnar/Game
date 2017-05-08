package main;



import java.awt.Graphics;
import java.awt.event.KeyEvent;


import entities.Things;
import gfx.Assets;
import gfx.Sound;





public class Character{
	
		static double dy = 0;
		static double dyinit = dy;
		static double dx = 4;
		
		static  double ddy = .2;
		
		static double z=Launcher.y;
		
		static double height=46;
		static double width=33;
		public static double x = 10;
		static double xinit=x;
		public static double y = z-height-11;
		static double yinit=y;

		static String direction="R";
		static boolean ground=false;
		static boolean fall=true;
		static double jump=7;
		public static int l=0;
		static int projspeed=8;
		public static RectHitbox hb=new RectHitbox(x,y,width,height);
		
		
		private static void reset() {
			
	
			x=xinit;
			y=yinit;
			dy=dyinit;
		}

			
		
		public static void update(){
			if (Things.checkNext(hb))
			{
				l++;
				Sound.playSound("res/sound/Woohoo.wav");
				Things.reset();
				reset();
				
			}
			if (Things.checkDeath(hb))
			{	
				Sound.playSound("res/sound/oww.wav");
				reset();
				Things.reset();
				
			}
			else
			{
				ground=false;
				fall=false;
				
				if(Handler.km.isKeyPressed(KeyEvent.VK_A))
				{
					x-=dx;
					hb.setX(x);
					hb.setY(y);
					if (Things.checkCollisions(hb))
					{
						x+=dx;
					}
					direction="L";
				}
				if(Handler.km.isKeyPressed(KeyEvent.VK_D))
				{
					x+=dx;
					hb.setX(x);
					hb.setY(y);
					if (Things.checkCollisions(hb))
					{
						x-=dx;
					}
					
					direction="R";
				}
				
				y+=dy;
				if(dy>0)
					fall=true;
				hb.setX(x);
				hb.setY(y);
				if (Things.checkCollisions(hb))
				{
					y-=dy;
					dy=0;
					ground=true;
					
				}
				else
				{
					if(Handler.km.isKeyPressed(KeyEvent.VK_S))
						dy+=ddy*3;
					else
						dy+=ddy;
				}
				
				if(Handler.km.isKeyPressed(KeyEvent.VK_W) && ground && fall)
				{
					Sound.playSound("res/sound/Boinggg.wav");
					dy=-jump;
					
				}
				
				if(Handler.km.isKeyHit(KeyEvent.VK_SPACE))
				{
					if(Things.p.size()<6)
					{
						Sound.playSound("res/sound/pew.wav");
						int speed=projspeed;
						if(direction.equals("L"))
							speed=-speed;
						Things.shoot((int)x,(int)(y+height/2),speed);
					
					}
					
				}
				
			}
		}

	public static void render(Graphics g)
		{
		hb.setX(x);
		hb.setY(y);
		
		if (direction.equals("R"))
			g.drawImage(Assets.l,(int)x,(int)y,(int)width,(int)height,null);
		if (direction.equals("L"))
			g.drawImage(Assets.i,(int)x,(int)y,(int)width,(int)height,null);
		
		}





	
	
	
}


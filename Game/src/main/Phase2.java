package main;

import java.awt.Graphics;
import java.util.ArrayList;

import entities.BadProjectile;
import gfx.Sound;

public class Phase2 {
	public static ArrayList<BadProjectile> p=new ArrayList<BadProjectile>();
	public static boolean start=false;
	public static int counter=-50;

	public static void reset() {

		p.clear();
		counter=-50;
		
	}

	public static void update() {
		
		for (int i=0;i<p.size();i++)
		{
			p.get(i).update();
		}
		counter++;
		//BadProjectile(int x, int y, int width, int height, int speed, int direction)
		
		if(counter==-49)
		{
			Sound.playSound("res/sound/Unlimited_Power_.wav");
			p.add(new BadProjectile(350,0,200,10,0,1));
			p.add(new BadProjectile(350,228,200,10,0,1));
			p.add(new BadProjectile(350,0,10,228,0,1));
			p.add(new BadProjectile(540,0,10,228,0,1));
		}
		if(counter==1)
		{
			
			
			
		
			p.add(new BadProjectile(900,545,200,27,-4,1));
			
			p.add(new BadProjectile(-200,445,200,27,4,1));
			p.add(new BadProjectile(900,345,200,27,-4,1));
			
		}
		if(counter==250)
		{
			Sound.playSound("res/sound/HaHa1.wav");

			p.add(new BadProjectile(50,-200,250,20,10,2));
			p.add(new BadProjectile(600,-200,250,20,10,2));
			
		}
		if(counter==320)
		{
			p.add(new BadProjectile(-200,545,200,27,5,1));
			p.add(new BadProjectile(900,445,200,27,-5,1));
			p.add(new BadProjectile(-200,345,200,27,5,1));
			
		}
		if(counter==510)
		{
			Sound.playSound("res/sound/HaHa2.wav");

			p.add(new BadProjectile(100,-200,70,200,5,2));
			p.add(new BadProjectile(300,-200,70,200,5,2));
			p.add(new BadProjectile(500,-200,70,200,5,2));
			p.add(new BadProjectile(700,-200,70,200,5,2));
			p.add(new BadProjectile(900,-200,70,200,5,2));
		
			p.add(new BadProjectile(0,-500,70,200,5,2));
			p.add(new BadProjectile(200,-500,70,200,5,2));
			p.add(new BadProjectile(400,-500,70,200,5,2));
			p.add(new BadProjectile(600,-500,70,200,5,2));
			p.add(new BadProjectile(800,-500,70,200,5,2));
			
			p.add(new BadProjectile(100,-800,70,200,5,2));
			p.add(new BadProjectile(300,-800,70,200,5,2));
			p.add(new BadProjectile(500,-800,70,200,5,2));
			p.add(new BadProjectile(700,-800,70,200,5,2));
			p.add(new BadProjectile(900,-800,70,200,5,2));
			
			

			p.add(new BadProjectile(0,-1100,70,200,5,2));
			p.add(new BadProjectile(200,-1100,70,200,5,2));
			p.add(new BadProjectile(400,-1100,70,200,5,2));
			p.add(new BadProjectile(600,-1100,70,200,5,2));
			p.add(new BadProjectile(800,-1100,70,200,5,2));
			
			p.add(new BadProjectile(100,-1400,70,200,5,2));
			p.add(new BadProjectile(300,-1400,70,200,5,2));
			p.add(new BadProjectile(500,-1400,70,200,5,2));
			p.add(new BadProjectile(700,-1400,70,200,5,2));
			p.add(new BadProjectile(900,-1400,70,200,5,2));
			
		}
		if(counter==700)
			Sound.playSound("res/sound/HaHa1.wav");
		if(counter==1000)
		{
			p.add(new BadProjectile(0,600,900,600,-1,2));
			Sound.playSound("res/sound/HaHa2.wav");

		}
		if(counter==1200)
			Sound.playSound("res/sound/HaHa1.wav");
		if(counter==1490)
		{
			p.get(p.size()-1).speed=0; 
			

		}
		if(counter==1550)
		{
			p.get(p.size()-1).speed=2; 
		}
		if(counter==1900)
		{
		
			p.add(new BadProjectile(425,600,50,200,-4,2));
			
		
		}
		if(counter==1950)
			Sound.playSound("res/sound/Oops.wav");
			
		if(counter==1993)
		{
			int i=p.size()-1;
			
			while(i>=0)
			{
				p.remove(i);
				i--;
			}
			p.add(new BadProjectile(350,0,200,10,-5,2));
			p.add(new BadProjectile(350,228,200,10,5,2));
			p.add(new BadProjectile(350,0,10,228,-5,1));
			p.add(new BadProjectile(540,0,10,228,5,1));
			Sound.playSound("res/sound/uh_oh.wav");
			
		}
		
		
	}

	public static void render(Graphics g) {
		for (int i=0;i<p.size();i++)
		{
			p.get(i).render(g);
			
		}
		
	}
	
	
}

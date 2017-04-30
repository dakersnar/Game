package entities;

import java.awt.Graphics;

import java.util.ArrayList;

import levels.Level;

import main.Character;
import main.Launcher;
import main.RectHitbox;

public class Things {
	static int x=Launcher.x;
	static int y=Launcher.y;
	static ArrayList<Platform> L1=new ArrayList<Platform>();
	static ArrayList<Spike> S1=new ArrayList<Spike>();
	static ArrayList<Platform> L2=new ArrayList<Platform>();
	static ArrayList<Platform> L3=new ArrayList<Platform>();
	static ArrayList<Level> levels=new ArrayList<Level>();
	
	public static ArrayList<Projectile> p=new ArrayList<Projectile>();

	
	
	public static void init()
	{
	
		
		L1.add(new Platform(0,y-10,x,50));
		L1.add(new Platform(-4,0,4,y));
		L1.add(new Platform(x,0,4,y));
		
		L1.add(new Platform(0,y-100,x-100,20)); 
		S1.add(new Spike(x-300,y-131,100,30));
		S1.add(new Spike(x-500,y-131,100,30));
		S1.add(new Spike(x-600,y-131,100,30));
		S1.add(new Spike(1,y-131,100,30));
		S1.add(new Spike(101,y-131,100,30));
		
		L1.add(new Platform(0,y-200,100,20));
		
		L1.add(new Platform(x-700,y-300,700,20));
		S1.add(new Spike(x-650,y-331,100,30));
		

		Level lvl1= new Level(L1,S1);
		
		levels.add(lvl1);		
		
		
	}
	public static void shoot(int x, int y, int speed)
	{
		if(p.size()<6)
		{
			
			p.add(new Projectile(x,y,speed));
		}
	}
	public static void removeProjectile(Projectile proj)
	{
		int i=0;
		boolean done=false;
		while(i<p.size() && !done)
		{
			if (p.get(i).equals(proj))
			{
				p.remove(i);
				done=true;
			}
			i++;
		}
	}
	
	public static boolean checkCollisions(RectHitbox hb)
	{
		
		return levels.get(Character.l).checkCollisions(hb);
		
	}
	public static boolean checkDeath(RectHitbox hb)
	{
		
		return levels.get(Character.l).checkDeath(hb);
		
	}
	public static void update() {
		
		levels.get(Character.l).update();
		
		for (int i=0;i<p.size();i++)
		{
			p.get(i).update();
		}
		
	}

	public static void render(Graphics g) {
		
		
		levels.get(Character.l).render(g);
	
		for (int i=0;i<p.size();i++)
		{
			p.get(i).render(g);
		}
		
	}

	
}

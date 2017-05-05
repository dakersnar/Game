package entities;

import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;

import main.Character;
import main.Launcher;
import main.RectHitbox;

public class Things {
	static int x=Launcher.x;
	static int y=Launcher.y;
	static ArrayList<Platform> L1=new ArrayList<Platform>();
	static ArrayList<Spike> S1=new ArrayList<Spike>();
	static ArrayList<Enemy> E1=new ArrayList<Enemy>();
	static ArrayList<Platform> L2=new ArrayList<Platform>();
	static ArrayList<Spike> S2=new ArrayList<Spike>();
	static ArrayList<Enemy> E2=new ArrayList<Enemy>();
	static ArrayList<Platform> L3=new ArrayList<Platform>();
	static ArrayList<Spike> S3=new ArrayList<Spike>();
	static ArrayList<Enemy> E3=new ArrayList<Enemy>();
	static ArrayList<Platform> L4=new ArrayList<Platform>();
	static ArrayList<Spike> S4=new ArrayList<Spike>();
	static ArrayList<Enemy> E4=new ArrayList<Enemy>();
	static ArrayList<Level> levels=new ArrayList<Level>();
	
	public static ArrayList<Projectile> p=new ArrayList<Projectile>();

	
	
	public static void init()
	{
	
		
		L1.add(new Platform(0,y-10,x,50,Color.blue));
		L1.add(new Platform(-4,0,4,y,Color.blue));
		L1.add(new Platform(x,0,4,y,Color.blue));
		L1.add(new Platform(0,-10,x,11,Color.blue));
		
		L1.add(new Platform(0,y-100,x-100,20,Color.blue)); 
		S1.add(new Spike(x-300,y-131,100,30,1));
		S1.add(new Spike(x-500,y-131,100,30,1));
		S1.add(new Spike(x-600,y-131,100,30,1));
		S1.add(new Spike(1,y-131,100,30,1));
		S1.add(new Spike(101,y-131,100,30,1));
		
		L1.add(new Platform(0,y-200,100,20,Color.blue));
		
		L1.add(new Platform(x-700,y-300,300,20,Color.blue));
		S1.add(new Spike(x-650,y-331,100,30,1));
		
		L1.add(new Platform(x-200,y-400,200,20,Color.blue));
		
		L1.add(new Platform(0,y-500,x-200,20,Color.blue));
		S1.add(new Spike(x-500,y-480,100,30,2));
		
		Platform end1=new Platform(45,y-555,10,10,Color.green);
		Level lvl1= new Level(L1,S1,E1,end1);
		lvl1.shown=true;
		L2.add(new Platform(0,y-10,x,50,Color.blue));
		L2.add(new Platform(-4,0,4,y,Color.blue));
		L2.add(new Platform(x,0,4,y,Color.blue));
		L2.add(new Platform(0,-10,x,11,Color.blue));
		
		S2.add(new Spike(700,y-40,100,30,1));
		
		Platform end2=new Platform(500,y-100,10,10,Color.green);
		
		Level lvl2= new Level(L2,S2,E2,end2);
		lvl2.shown=true;
		
		
		
		
		L3.add(new Platform(0,y-10,x,50,Color.blue));
		L3.add(new Platform(-4,-100,4,y+100,Color.blue));
		L3.add(new Platform(x,-100,4,y+100,Color.blue));
		//L3.add(new Platform(0,-10,x,11,Color.blue));
		
		L3.add(new Platform(50,y-100,200,20,Color.blue));
		L3.add(new Platform(70,y-200,130,20,Color.blue));
		L3.add(new Platform(90,y-300,60,20,Color.blue));
		L3.add(new Platform(0,y-400,100,20,Color.blue));
		L3.add(new Platform(150,y-500,200,20,Color.blue));
		
		L3.add(new Platform(x-250,y-100,200,20,Color.blue));
		L3.add(new Platform(x-200,y-200,130,20,Color.blue));
		L3.add(new Platform(x-150,y-300,60,20,Color.blue));
		L3.add(new Platform(x-100,y-400,100,20,Color.blue));
		L3.add(new Platform(x-350,y-500,200,20,Color.blue));
		
		L3.add(new Platform(x-600,y-300,300,20,Color.blue));
		L3.add(new Platform(x-600,y-300,300,20,Color.blue));
		
		
		E3.add(new Enemy(382,0,136,228,1,11));
		
		
		
		Platform end3=new Platform(45,y-555,10,10,Color.green);
		Level lvl3= new Level(L3,S3,E3,end3);
		
		
		Platform end4=new Platform(45,y-555,10,10,Color.green);
		Level lvl4= new Level(L4,S4,E4,end4);
		
		levels.add(lvl1);		
		levels.add(lvl2);
		levels.add(lvl3);
		levels.add(lvl4);
		
		
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
	public static boolean checkNext(RectHitbox hb)
	{
		
		return levels.get(Character.l).checkNext(hb);
		
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
	public static void reset() {
		levels.get(Character.l).reset();
		int i=0;
		while (p.size()>0)
		{
			i++;
			p.get(0).reset();
		}
		System.out.println(i);
	}
	

	
}

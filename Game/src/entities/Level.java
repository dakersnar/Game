package entities;

import java.awt.Graphics;
import java.util.ArrayList;

import main.Phase2;
import main.RectHitbox;


public class Level {
	ArrayList<Platform> platlist=new ArrayList<Platform>();
	ArrayList<Spike> spikelist=new ArrayList<Spike>();
	ArrayList<Enemy> enemylist=new ArrayList<Enemy>();
	Platform end;
	public boolean shown=false;
	
	
	public Level(ArrayList<Platform> plats, ArrayList<Spike> spikes,ArrayList<Enemy> enemies, Platform end) {
		platlist=plats;
		spikelist=spikes;
		enemylist=enemies;
		this.end=end;
	}
	public boolean checkCollisions(RectHitbox hb)
	{
		for(Platform p:platlist)
		{
			if(hb.collide(p.hitbox))
			{
				return true;
			}
			
		}
	
		
		return false;
		
		
	}
	public boolean checkDeath(RectHitbox hb)
	{
		for(Spike s:spikelist)
		{
			if(hb.collide(s.hitbox))
			{
				return true;
			}
			
		}
		for(Enemy e:enemylist)
		{
			if(e.dead==false)
			{
				
				if(hb.collide(e.hitbox))
				{
					e.hit();
					return true;
				}
			}
		}
		for(BadProjectile p:Enemy.p)
		{
			if(hb.collide(p.hitbox))
			{
				return true;
			}
			
		}
		for(BadProjectile p:Phase2.p)
		{
			if(hb.collide(p.hitbox))
			{
				return true;
			}
			
		}
		return false;
		
		
	}
	public boolean checkNext(RectHitbox hb)
	{
		if(shown)
		{
			if(hb.collide(end.hitbox))
			{
				return true;
			}
		}
		
		return false;
	}
	public void render(Graphics g)
	{
		for(int i=0;i<platlist.size();i++)
		{
			platlist.get(i).render(g);
		}
		for(int j=0;j<spikelist.size();j++)
		{
			spikelist.get(j).render(g);
		}
		if(shown)
			end.render(g);
		
		for(int k=0;k<enemylist.size();k++)
		{
			enemylist.get(k).render(g);
		}
	}

	public void update() {
		for(int k=0;k<enemylist.size();k++)
		{
			enemylist.get(k).update();
		}
		for(int k=0;k<enemylist.size();k++)
		{
			if(enemylist.get(k).dead==true)
			{
				shown=true;
			}
			else
				shown=false;
		}
	}
	public void reset() {
		for(int k=0;k<enemylist.size();k++)
		{
			enemylist.get(k).reset();
		}
		
		
	}

}

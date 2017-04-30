package levels;

import java.awt.Graphics;
import java.util.ArrayList;

import entities.Platform;
import entities.Spike;
import main.Character;
import main.RectHitbox;

public class Level {
	static ArrayList<Platform> platlist=new ArrayList<Platform>();
	static ArrayList<Spike> spikelist=new ArrayList<Spike>();
	
	
	public Level(ArrayList<Platform> plats, ArrayList<Spike> spikes) {
		platlist=plats;
		spikelist=spikes;
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
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

}

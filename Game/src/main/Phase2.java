package main;

import java.awt.Graphics;
import java.util.ArrayList;

import entities.BadProjectile;

public class Phase2 {
	public static ArrayList<BadProjectile> p=new ArrayList<BadProjectile>();
	public static boolean start=false;
	public static int counter=0;

	public static void reset() {
		int i=p.size()-1;
		
		while(i>=0)
		{
			p.remove(i);
			i--;
		}
		counter=0;
		
	}

	public static void update() {
		
		for (int i=0;i<p.size();i++)
		{
			p.get(i).update();
		}
		counter++;
		//BadProjectile(int x, int y, int width, int height, int speed, int direction)
		if(counter==1)
		{
			p.add(new BadProjectile(350,0,200,10,0,1));
			p.add(new BadProjectile(350,228,200,10,0,1));
			p.add(new BadProjectile(350,0,10,228,0,1));
			p.add(new BadProjectile(540,0,10,228,0,1));
			
			//p.add(new BadProjectile(-200,525,200,50,4,1));
			p.add(new BadProjectile(900,545,200,27,-4,1));
			
			p.add(new BadProjectile(-200,445,200,27,4,1));
			p.add(new BadProjectile(900,345,200,27,-4,1));
			
		}
	}

	public static void render(Graphics g) {
		for (int i=0;i<p.size();i++)
		{
			p.get(i).render(g);
		}
		
	}
	
	
}

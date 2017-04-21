package entities;

import java.awt.Graphics;

import main.Launcher;

public class Things {
	static int x=Launcher.x;
	static int y=Launcher.y;
	public static Platform z=new Platform(x-400,y-100,300,20);
	public static void update() {
		
		
	}

	public static void render(Graphics g) {
		
		
		
		z.render(g);
	}

	
}

package main;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import entities.Things;

import java.awt.*;
import gfx.Assets;





public class GameState extends State{

	int x=0,y=0;

	
	
	
	public GameState(){

		
	

	}
	
	public void update() {
		Character.update();
		Things.update();
	}

	public void render(Graphics g) {
	
		Character.render(g);
		Things.render(g);
		
	}

	
}
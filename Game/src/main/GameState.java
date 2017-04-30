package main;




import java.awt.Graphics;


import entities.Things;







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
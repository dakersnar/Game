package main;




import java.awt.Graphics;


import entities.Things;



//import level



public class GameState extends State{

	int x=0,y=0;

	ArrayList<Level> levels;
	
	
	public GameState(){
		
		// if/when you make a system to load levels from files or proc gen,
		// just pass the lists of stuff into these constructors.
		
		/*
		if you read from a file you can just make a for loop for each read file (contains info about whats in the level)
		to add the info from the file to a new level and add it to levels.
		That way nothing is hardcoded.
		
		Having a different static class for each level is the EPITOME of hardcoding.
		
		*/
		
		//put plats in here
		
		Platform[] plats1 = [];
		Platform[] plats2 = [];
		Platform[] plats3 = [];
		
		
		//create levels
		levels.add(new Level(Arrays.asList(plats1)));
		levels.add(new Level(Arrays.asList(plats2)));
		levels.add(new Level(Arrays.asList(plats3)));
		
	

	}
	
	public void update() {
		Character.update();
		Things.update();
	}

	public void render(Graphics g) {
	
		Character.render(g);
		Things.render(g);
		for(Level level:levels){
			level.render(g);
		}
	}

	
}

package main;

public class Launcher {

	public static final int y = 500;
	public static final int x = 500;
	public static void main(String[] args){
		
		Game game= new Game("game",x,y);
		game.start();
	}
}

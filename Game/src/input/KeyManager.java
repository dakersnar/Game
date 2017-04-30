package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import entities.Projectile;
import gfx.Sound;



public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public static ArrayList<Integer> keys2=new ArrayList<Integer>();
	
	public KeyManager(){
		keys = new boolean[1024];
		
	}
	
	
	public boolean isKeyPressed(int keyCode){
		return keys[keyCode];
		
	}
	
	public void keyPressed(KeyEvent pressed) {
				keys[pressed.getKeyCode()] = true;
				keys2.add(pressed.getKeyCode());
				
				
	}
	public boolean isKeyHit(int x) {
		
		
		for(int i=0;i<keys2.size();i++)
		{
			if(x==keys2.get(i))
			{
				keys2.remove(i);
				return true;
			}
			
		}
		return false;
	}
		


	public void keyReleased(KeyEvent pressed) {
		keys[pressed.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent arg0) {
		
	}

}
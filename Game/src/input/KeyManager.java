package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	
	public KeyManager(){
		keys = new boolean[1024];
	}
	
	
	public boolean isKeyPressed(int keyCode){
		return keys[keyCode];
		
	}
	
	public void keyPressed(KeyEvent pressed) {
				keys[pressed.getKeyCode()] = true;
				
	}

	public void keyReleased(KeyEvent pressed) {
		keys[pressed.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent arg0) {
		
	}

}
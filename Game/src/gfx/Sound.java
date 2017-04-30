
package gfx;


import java.io.File;



import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;




public class Sound {

	
	public static void playSound(String i) {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(i).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
}



package gfx;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

//import gfx.Handler;

public class Assets {
	public static BufferedImage i;
	public static BufferedImage j;
	public static BufferedImage k;
	public static BufferedImage l;
	public static BufferedImage spike;
	
	
	public static void init()
	{
		i=ImageLoader.loadimage("/textures/DREW.png");
		j=ImageLoader.loadimage("/textures/IMG_4845.jpg");
		k=ImageLoader.loadimage("/textures/LEAH.png");
		l=ImageLoader.loadimage("/textures/DREW copy.png");
		spike=ImageLoader.loadimage("/textures/Spike2.png");
	}
}
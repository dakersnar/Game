


package gfx;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;

//import gfx.Handler;

public class Assets {
	public static BufferedImage i;
	public static BufferedImage j;
	public static BufferedImage k;
	public static BufferedImage l;
	public static void init()
	{
		i=ImageLoader.loadimage("/textures/DREW.png");
		j=ImageLoader.loadimage("/textures/IMG_4845.jpg");
		k=ImageLoader.loadimage("/textures/LEAH.png");
		l=ImageLoader.loadimage("/textures/DREW copy.png");
	}
}
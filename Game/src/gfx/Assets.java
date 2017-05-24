


package gfx;


import java.awt.image.BufferedImage;


public class Assets {
	public static BufferedImage i;
	public static BufferedImage j;
	public static BufferedImage k;
	public static BufferedImage l;
	public static BufferedImage spike;
	public static BufferedImage spike2;
	public static BufferedImage draganski;
	public static BufferedImage docVR;
	public static BufferedImage docVL;
	public static BufferedImage text1;
	public static BufferedImage text2;
	public static BufferedImage text4;


	
	
	
	public static void init()
	{
		
		i=ImageLoader.loadimage("/textures/DREW.png");
		j=ImageLoader.loadimage("/textures/IMG_4845.jpg");
		k=ImageLoader.loadimage("/textures/LEAH.png");
		l=ImageLoader.loadimage("/textures/DREW copy.png");
		spike=ImageLoader.loadimage("/textures/Spike2.png");
		spike2=ImageLoader.loadimage("/textures/Spike2 copy.png");
		draganski=ImageLoader.loadimage("/textures/draganski.png");
		docVR=ImageLoader.loadimage("/textures/docv copy.png");
		docVL=ImageLoader.loadimage("/textures/docv.png");
		text1=ImageLoader.loadimage("/textures/lvl1.png");
		text2=ImageLoader.loadimage("/textures/lvl2.png");
		text4=ImageLoader.loadimage("/textures/lvl4.png");


		
		
	}
}
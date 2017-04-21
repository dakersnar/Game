package main;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;

import gfx.Assets;


public class Game implements Runnable {
	private Display d;
	private Thread thread;
	private boolean running=false;
	private int width;
	private int height;
	public String title;
	private BufferStrategy bs;
	private Graphics g;
	private long seconds;
	private long timer;

	public Game(String title, int width, int height)
	{
		this.width=width;
		this.height=height;
		this.title=title;
	}

	@Override
    public void run(){

        init();

        seconds = 0;
        int fps = 60;
        double timepertick = 1000000000 / fps;
        double delta = 0;
        long now;
        long LastTime = System.nanoTime();
        timer = 0;
        int updates = 0;

        while(running){
            now = System.nanoTime();
            delta = delta+(now - LastTime) / timepertick;
            timer = timer+now - LastTime;
            LastTime = now;
            if(delta >= 1){
            update();
            render();
          
            updates++;
            delta--;
            }
            if(timer >= 1000000000){
                seconds++;
               
                d.getFrame().setTitle("fps: " + updates);
                updates = 0;
                timer = 0;
            }
        }

        stop();

    }
	public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running)
            return;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void init(){
    	d= new Display(title,width,height);
    	JFrame frame=d.getFrame();
    	Canvas canvas=d.getCanvas();
    	canvas.createBufferStrategy(3);
    	g=canvas.getBufferStrategy().getDrawGraphics();
    	State.setState(new GameState());
    	Assets.init();
    	frame.addKeyListener(Handler.km);
    }
    private void update(){
    	if(State.getState() != null) State.getState().update();

    }
    private void render(){
        bs = d.getCanvas().getBufferStrategy();
        if(bs == null){
            d.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //clear screen
        g.clearRect(0, 0, width, height);
        //draw stuff
        
        if(State.getState() != null) State.getState().render(g);
        else
        	System.out.println("error");

        //end draw
        bs.show();
        g.dispose();
    }
    
    
}

package core;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import display.Window;

public class Game implements Runnable{
	
	private Window window;
	private Thread thread;
	private StateManager stateManager;
	private KeyManager keyManager;
	private boolean isRunning;
	private int fps;
	
	
	public Game(String title)
	{
		fps = 10;
		
		window = new Window(title);
		stateManager = new StateManager();
		keyManager = new KeyManager();
		
		window.addKeyManager(keyManager);
		
		start();
		
	}
	
	public void run()
	{
		double framesPerSecond;
		double delta = 0;
		double timer = 0;
		int count = 0;
		
		long lastTime = System.nanoTime();
		long now;
		
		while(isRunning)
		{
			
			framesPerSecond = 1000000000/fps;
					
			now = System.nanoTime();
			
			delta += (now - lastTime)/framesPerSecond;
			timer += now - lastTime;
			
			lastTime = now;
			
			if(delta >= 1)
			{
				update();
				render();
				
				count++;
				
				delta--;
			}
			
			if(timer >= 1000000000)
			{
				System.out.println(count);
				count = 0;
				timer = 0;
			}
			
		}
		
	}
	
	public void render() 
	{
		
		
		BufferStrategy bs = window.getBufferStrategy();
		
		if(bs==null)
		{
			
			window.createBufferStrategy();
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
		
		stateManager.render(g);
		
		g.dispose();
		bs.show();
		
	}

	public void update() {
		
		
		stateManager.update(this);
		
	}

	public synchronized void start()
	{
		if(thread != null)
		{
			return;
		}
		
		thread = new Thread(this);
		
		thread.start();
		
		isRunning = true;
	}
	
	public synchronized void stop()
	{
		if(thread == null)
		{
			return;
		}
		
		try 
		{
			thread.join();
			
			isRunning = false;
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public int getFps()
	{
		return this.fps;
	}
	
	public void setFps(int fps)
	{
		this.fps = fps;
	}

}

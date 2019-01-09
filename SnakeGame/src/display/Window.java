package display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Window {
	
public static final int WIDTH = 900, HEIGHT = 900;
	
	private JFrame frame;
	private Canvas canvas;
	
	public Window(String title)
	{
		frame = new JFrame(title);
		canvas = new Canvas();
		
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(false);
		frame.setResizable(false);
		frame.add(canvas);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	public void createBufferStrategy()
	{
		canvas.createBufferStrategy(2);
	}
	
	public BufferStrategy getBufferStrategy()
	{
		return canvas.getBufferStrategy();
	}
	
	public void addKeyManager(KeyAdapter k)
	{
		frame.addKeyListener(k);
	}

}

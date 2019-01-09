package core;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyManager extends KeyAdapter {
	
	
	public static boolean w, a ,s ,d;
	
	
	public KeyManager()
	{
		w = a = s = d = false;
	}
	
	public void keyPressed(KeyEvent e)
	{
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W && !s)
		{
			w = true;
			a = false;
			s = false;
			d = false;
		}
		
		if(code == KeyEvent.VK_A && !d)
		{
			w = false;
			a = true;
			s = false;
			d = false;
		}
		
		if(code == KeyEvent.VK_S && !w)
		{
			w = false;
			a = false;
			s = true;
			d = false;
		}
		
		if(code == KeyEvent.VK_D && !a)
		{
			w = false;
			a = false;
			s = false;
			d = true;
		}
	}
	
}

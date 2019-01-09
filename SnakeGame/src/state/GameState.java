package state;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import core.Game;
import core.KeyManager;
import display.Window;
import entities.SnakeBody;

public class GameState implements State{
	
	
	private ArrayList<SnakeBody> snake = new ArrayList<>();
	private int pieceSize;
	private int snakePosX, snakePosY;
	private int applePosX, applePosY;

	
	public GameState()
	{
		pieceSize = (int)Math.sqrt(Window.HEIGHT);
		snakePosX = 15;
		snakePosY = 15;
		applePosX = (int)(Math.random() * pieceSize);
		applePosY = (int)(Math.random() * pieceSize);

		
		snake.add(new SnakeBody(snakePosX, snakePosY));
		
	}

	@Override
	public void update(Game game) {
		
		snake.remove(0);
		
		if(KeyManager.w)
		{
			snakePosY--;
		}
		
		if(KeyManager.a)
		{
			snakePosX--;
		}
		
		if(KeyManager.s)
		{
			snakePosY++;
		}
		
		if(KeyManager.d)
		{
			snakePosX++;
		}
		
		
		
		snake.add(new SnakeBody(snakePosX, snakePosY));
		
	
		for(int i = 0; i < snake.size(); i++)
		{
			if(snakePosX == snake.get(i).getX() && snakePosY == snake.get(i).getY())
			{
				if(i != snake.size()-1)
				{
					JOptionPane.showMessageDialog(null, "Game Over");
					System.exit(0);
					
				}
			}
		}
		
		if(snakePosX < 0 || snakePosX > pieceSize-1 || snakePosY < 0 || snakePosY > pieceSize-1)
		{
			JOptionPane.showMessageDialog(null, "Game Over");
			System.exit(0);
		}
		
		
		if(snakePosX == applePosX && snakePosY == applePosY)
		{
			applePosX = (int)(Math.random() * pieceSize);
			applePosY = (int)(Math.random() * pieceSize);
			
			for(SnakeBody s : snake)
			{
				if(applePosX == s.getX() && applePosY == s.getY())
				{
					applePosX = (int)(Math.random() * pieceSize);
					applePosY = (int)(Math.random() * pieceSize);
				}
			}
			
			snake.add(new SnakeBody(snakePosX, snakePosY));
			
			game.setFps(game.getFps() + 1);
	
		}
		
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.YELLOW);
		
		
		for(SnakeBody s : snake)
		{
			g.fillRect(s.getX() * pieceSize, s.getY() * pieceSize, pieceSize, pieceSize);
		}
		
		g.setColor(Color.RED);
		
		g.fillRect(applePosX * pieceSize,  applePosY * pieceSize, pieceSize, pieceSize);
		
	}

}

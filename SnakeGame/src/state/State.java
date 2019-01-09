package state;

import java.awt.Graphics;

import core.Game;

public interface State {
	
	
	public void update(Game game);
	
	public void render(Graphics g);

}

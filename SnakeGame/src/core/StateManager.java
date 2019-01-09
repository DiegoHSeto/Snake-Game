package core;

import java.awt.Graphics;

import state.GameState;
import state.State;

public class StateManager {
	
	private int numStates;
	private int currentState;
	
	private State [] states;;
	
	public StateManager()
	{
		numStates = 2;
		currentState = 1;
		
		states = new State[numStates];
		
		states[1] = new GameState();
	}
	
	public void update(Game game)
	{
		states[currentState].update(game);
	}
	
	public void render(Graphics g)
	{
		states[currentState].render(g);
	}

}

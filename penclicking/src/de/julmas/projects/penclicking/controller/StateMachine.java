/**
 * 
 */
package de.julmas.projects.penclicking.controller;

import de.julmas.projects.penclicking.util.observer.Observable;

/**
 * @author Thomas
 *
 */
public class StateMachine extends Observable{
	
	public enum State{
		MENU, 
		OPTIONS,
		INGAME,
		RESULT
	}
	
	private State state;
	
	public StateMachine( State state) {
		this.state = state;
	}
	
	
	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}


	/**
	 * Change state from INGAME to MENU
	 */
	public void ingameToMenu() {
		assert(state == State.INGAME);
		state = State.MENU;
		this.notifyObservers();
	}
	
	/**
	 * Change state from MENU to OPTIONS
	 */
	public void menuToOptions() {
		assert(state == State.MENU);
		state = State.OPTIONS;
		this.notifyObservers();
	}
	
	/**
	 * Normal state changes
	 */
	public void nextState() {
		switch ( state ) {
		case MENU:
			state = State.INGAME;
			break;
		case INGAME:
			state = State.RESULT;
			break;
		case OPTIONS:
			state = State.MENU;
			break;
		case RESULT:
			state = State.MENU;
			break;
		default:
			break;
		}
		this.notifyObservers();
	}

}

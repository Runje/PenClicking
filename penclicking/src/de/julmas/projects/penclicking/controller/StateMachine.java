/**
 * 
 */
package de.julmas.projects.penclicking.controller;

/**
 * @author Thomas
 *
 */
public class StateMachine {
	
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
	 * Change state from INGAME to MENU
	 */
	public void ingameToMenu() {
		assert(state == State.INGAME);
		state = State.MENU;
	}
	
	/**
	 * Change state from MENU to OPTIONS
	 */
	public void menuToOptions() {
		assert(state == State.MENU);
		state = State.OPTIONS;
	}
	
	/**
	 * Normal state changes
	 */
	public void nextState() {
		switch ( state ) {
		case MENU:
			state = State.INGAME;
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
	}

}

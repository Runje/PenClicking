/**
 * 
 */
package de.julmas.projects.penclicking.view;

import javax.swing.JFrame;

import de.julmas.projects.penclicking.controller.PenController;
import de.julmas.projects.penclicking.controller.StateMachine;
import de.julmas.projects.penclicking.controller.StateMachine.State;
import de.julmas.projects.penclicking.util.observer.IObserver;

/**
 * @author Thomas
 *
 */
public class GUI implements IObserver{

	private GameFrame game;
	private OptionsMenu options;
	private StartMenu start;
	private ResultDialog result;
	private StateMachine stateMachine;
	private PenController penController;
	public GUI() {
		this.stateMachine = new StateMachine(State.MENU);
		this.penController = new PenController();
		this.start = new StartMenu(stateMachine);
		this.stateMachine.addObserver(this);
	}
	@Override
	public void update() {
		System.out.println("update: " + stateMachine.getState());
		switch (stateMachine.getState()) {
		case INGAME:
			game = new GameFrame(penController, stateMachine);
			start.dispose();
			break;
		case MENU:
			start = new StartMenu(stateMachine);
			if (options != null) {
				options.dispose();
			}
			if (result != null) {
				result.dispose();
			}
			break;
		case OPTIONS:
			options = new OptionsMenu(penController, stateMachine);
			start.dispose();
			break;
		case RESULT:
			result = new ResultDialog(penController, stateMachine);
			game.dispose();
			//Reinit penController for next game
			this.penController = new PenController();
			break;
		default:
			assert(false);
			break;
			
		}
	}
}

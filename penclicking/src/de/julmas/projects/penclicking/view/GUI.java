/**
 * 
 */
package de.julmas.projects.penclicking.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.julmas.projects.penclicking.controller.PenController;
import de.julmas.projects.penclicking.controller.StateMachine;
import de.julmas.projects.penclicking.controller.StateMachine.State;
import de.julmas.projects.penclicking.util.observer.IObserver;

/**
 * @author Thomas
 *
 */
public class GUI implements IObserver{

	private Game game;
	private OptionsMenu options;
	private StartMenu start;
	private ResultDialog result;
	private StateMachine stateMachine;
	private PenController penController;
	private Logger logger = LogManager.getLogger("PenClicking");

	public GUI() {
		this.stateMachine = new StateMachine(State.MENU);
		this.penController = new PenController();
		this.start = new StartMenu(stateMachine);
		this.stateMachine.addObserver(this);
		
	}
	@Override
	public void update() {
		logger.trace("update: " + stateMachine.getState());
		switch (stateMachine.getState()) {
		case INGAME:
			start.dispose();
			game = new Game(penController, stateMachine);
			break;
		case MENU:
			start = new StartMenu(stateMachine);
			if (options != null) {
				options.dispose();
			}
			if (result != null) {
				result.dispose();
			}
			if (game != null) {
				game.dispose();
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

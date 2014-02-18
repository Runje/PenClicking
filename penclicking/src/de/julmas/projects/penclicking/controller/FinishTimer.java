package de.julmas.projects.penclicking.controller;

import java.util.TimerTask;

/**
 * TimerTask when game is finished.
 * @author jmayer
 *
 */
public class FinishTimer extends TimerTask {
    private PenController penController;

    /**
     * Constructor.
     * @param penController Controller to set finish flag.
     */
    public FinishTimer(PenController penController) {
        this.penController = penController;
    }

    @Override
    public void run() {
        this.penController.setFinish(true);
        this.penController.notifyObservers();
    }

}

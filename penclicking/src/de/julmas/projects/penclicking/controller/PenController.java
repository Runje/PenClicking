package de.julmas.projects.penclicking.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import de.julmas.projects.penclicking.model.Pen;
import de.julmas.projects.penclicking.util.observer.Observable;

/**
 * Controller for the model Pen.
 * @author jmayer
 *
 */
public class PenController extends Observable implements ActionListener {

    private Pen pen;
    private Timer timer = new Timer();
    private long timeout = 5 * 1000;
    private String name = "Player";
    private boolean finish = false;

    /**
     * @return the timeout
     */
    public long getTimeout() {
        return this.timeout;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the clicks
     */
    public int getClicks() {
        return this.pen.getClicks();
    }

    /**
     * @return true if game has finished.
     */
    public boolean isFinish() {
        return this.finish;
    }

    /**
     * Sets Timeout for clicking the pen.
     * @param timeout in ms
     */
    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    /**
     * Sets the name of the player.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Indicate that no more clicks could be done.
     */
    public void setFinish() {
        this.finish = true;
    }
    
    /**
     * Initialize the game by initializing the pen and reset finish.
     */
    public void init() {
        pen = new Pen();
        this.finish = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (pen.getClicks() == 0) {
            // set the Timer on first click
            timer.schedule(new FinishTimer(this), timeout);
        }
        pen.click();
        this.notifyObservers();
    }

}

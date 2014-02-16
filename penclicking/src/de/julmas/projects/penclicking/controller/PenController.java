package de.julmas.projects.penclicking.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import de.julmas.projects.penclicking.model.Pen;
import de.julmas.projects.penclicking.util.observer.Observable;

public class PenController extends Observable implements ActionListener {

    private Pen pen;
    private Timer timer = new Timer();
    private final long timeout = 10 * 1000;

    /**
     * @return the pen
     */
    public Pen getPen() {
        return this.pen;
    }

    public void init() {
        pen = new Pen();
        timer.schedule(new TimerTask() {
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                
            }
        }, timeout);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pen.click();
        this.notify();
    }

}

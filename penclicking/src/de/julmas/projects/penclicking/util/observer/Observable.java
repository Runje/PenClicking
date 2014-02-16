package de.julmas.projects.penclicking.util.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Julian Mayer, Marcel Loevenich
 */
public class Observable implements IObservable {

    private List<IObserver> subscribers = new ArrayList<IObserver>(2);

    /**
     * method to add a observer
     * 
     * @param s
     */
    @Override
    public void addObserver(IObserver s) {
        subscribers.add(s);
    }

    /**
     * method to remove one specified observer
     * 
     * @param s
     */
    @Override
    public void removeObserver(IObserver s) {
        subscribers.remove(s);
    }

    /**
     * method to remove all observers
     */
    @Override
    public void removeAllObservers() {
        subscribers.clear();
    }

    /**
     * send notify
     */
    @Override
    public void notifyObservers() {
        for (IObserver iObserver : subscribers) {
            iObserver.update();
        }
    }
}

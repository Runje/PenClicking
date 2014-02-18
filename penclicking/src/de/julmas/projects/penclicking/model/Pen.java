/**
 * 
 */
package de.julmas.projects.penclicking.model;

/**
 * @author Thomas
 * 
 */
public class Pen {

    int clicks = 0;

    /**
     * @return the clicks
     */
    public int getClicks() {
        return clicks;
    }

    @Override
    public String toString() {
        return "Pen [clicks=" + clicks + "]";
    }

    /**
     * Simulates a click by increasing the click counter.
     */
    public void click() {
        ++clicks;
    }
}

/**
 * 
 */
package de.julmas.projects.penclicking.model;

/**
 * @author Thomas
 * 
 */
public class Pen {

    int clicks;

    public Pen() {
        this.clicks = 0;
    }

    /**
     * @return the clicks
     */
    public int getClicks() {
        return clicks;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Pen [clicks=" + clicks + "]";
    }

    public void click() {
        ++clicks;
    }
}

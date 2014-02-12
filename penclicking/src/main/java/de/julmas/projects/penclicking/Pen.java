/**
 * 
 */
package de.julmas.projects.penclicking;

import java.util.Date;

//import java.utils.*;

/**
 * @author Thomas
 *
 */
public class Pen {
	
	int clicks;
	Date startTime;
	
	public Pen( int clicks )
	{
		this.clicks = clicks;
		startTime = new java.util.Date();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pen [clicks=" + clicks + ", startTime=" + startTime + "]";
	}

	public void click()
	{
		++clicks;
	}

}

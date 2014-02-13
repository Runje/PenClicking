/**
 * 
 */
package de.julmas.projects.penclicking;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Thomas
 *
 */
public class Pen {
	
	int clicks;
	Timer timer;
	
	public Pen( int clicktime )
	{
		this.clicks = 0;
		this.timer = new Timer();
		
		timer.schedule( new TimerTask() {
			
			@Override
			public void run() {
				System.out.println( this );
				timer.cancel();
				clicks = 0;
			}
		}, clicktime );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pen [clicks=" + clicks + "]";
	}

	public void click()
	{
		++clicks;
	}

}

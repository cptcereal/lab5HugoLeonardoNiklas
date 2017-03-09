package lab5.sim.general.GUI;

import java.util.Observable;
import java.util.Observer;

/**
 * A view that displays the corresponding data to a specific simulation
 * 
 * @author hugwan-6, leopel-6, inaule-6 
 *
 */
public abstract class View implements Observer {
	
	/**
	 * Print out the correct information depending on what happened in the simulation
	 * 
	 */
	public void update(Observable o, Object arg) {
		
	}
	
}

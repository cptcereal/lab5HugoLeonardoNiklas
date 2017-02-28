package lab5;

import lab5.simulation.Event;
import lab5.simulation.Simulation;

/**
 * Creates a new simulation
 * 
 * @author hugwan-6, leopel-6, inaule-6
 */
public class SimMain {

	private Simulation sim;
	
	/**
	 * Starts the simulation with the start events
	 * 
	 * @param arg an event array that contains the start events
	 * @throws IllegalArgumentException if no start events are provided
	 */
	public static void main(Event[] arg) throws IllegalArgumentException {
		
		if (arg.length == 0) {
			throw new IllegalArgumentException("The simulation requires a start argument with at least one start event.");
		} else {
			sim = new Simulation(arg);
		}
	}
}

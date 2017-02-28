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
	 * @param arg the start argument that contains the start events
	 */
	public static void main(Event[] arg) {
		
		sim = new Simulation(arg);
		
	}
}

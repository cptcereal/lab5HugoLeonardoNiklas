package lab5.sim.hairsalon.main;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.State;

/**
 * Creates a new simulation
 * 
 * @author hugwan-6, leopel-6, inaule-6
 */
public class SimMain {
	
	// Simulation settings
	private static final Event[] startEvents = {};
	
	/**
	 * Starts the simulation with the start events
	 * 
	 * @param arg an event array that contains the start events
	 * @throws IllegalArgumentException if no start events are provided
	 */
	public static void main(String[] args) throws IllegalArgumentException {
		
		if (startEvents.length == 0) {
			throw new IllegalArgumentException("The simulation requires the event array startEvents to contain at least one event to begin the simulation.");
		} else {
			State state = new State();
			Simulation sim = new Simulation(startEvents, state);
		}
	}
}

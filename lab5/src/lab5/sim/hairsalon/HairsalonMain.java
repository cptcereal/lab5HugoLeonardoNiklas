package lab5.sim.hairsalon;

import lab5.sim.general.Event;
import lab5.sim.general.Simulation;
import lab5.sim.general.State;

/**
 * Creates a new hair salon simulation
 * 
 * @author hugwan-6, leopel-6, inaule-6
 */
public class HairsalonMain {
	
	// Simulation settings
	private static final Event[] startEvents = {};	// Should this be and Enter array? Since Enter is the first event that can happen.

	
	/**
	 * Starts the simulation
	 * 
	 * @param arg an event array that contains the start events
	 * @throws IllegalArgumentException if no start events are provided
	 */
	public static void main(String[] args) throws IllegalArgumentException {
		
		if (startEvents.length == 0) {
			throw new IllegalArgumentException("The simulation requires the startEvents array to contain at least one start event in order to begin the simulation.");
		} else {
			HairsalonSettings hairsalonSettings = new HairsalonSettings();
			HairsalonState hairsalonState = new HairsalonState(hairsalonSettings);
			HairsalonSimulation sim = new HairsalonSimulation(startEvents, hairsalonState);
		}
	}
}
package lab5;

import lab5.hairsalon.data.HairsalonSettings;
import lab5.hairsalon.simulation.HairsalonSimulation;
import lab5.harisalon.events.Enter;
import lab5.simulation.Event;
import lab5.simulation.Simulation;

/**
 * Creates a new hair salon simulation
 * 
 * @author hugwan-6, leopel-6, inaule-6
 */
public class HairsalonMain {
	
	// Simulation settings
	private static final Enter[] startEvents = {};	// Should this be and Enter array? Since Enter is the first event that can happen.
	private static final HairsalonSettings hairsalonSettings;
	
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
			hairsalonSettings = new HairsalonSettings();
			HairsalonSimulation sim = new HairsalonSimulation(startEvents, hairsalonSettings);
		}
	}
}
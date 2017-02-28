package lab5.simulation;

import lab5.data.EventStore;
import lab5.data.State;
import lab5.gui.View;

/**
 * Runs the simulation
 * 
 * @author hugwan-6, leopel-6, inaule-6
 *
 */
public class Simulation {
	
	private View view;
	private State state;
	private EventStore eventStore;
	
	/**
	 * Starts up the simulation
	 * 
	 * @param events the event array that contains at least one start event for the simulation.
	 * 
	 */
	public Simulation(Event[] events) {
		state = new State();
		view = new View();	// WIP
		eventStore = new EventStore(events);
		run();
	}
	
	/**
	 * Keeps the simulation running until it's done
	 * 
	 */
	public void run() {
		while(!eventStore.isEmpty) {
			eventStore.nextEvent();
		}
	}
}
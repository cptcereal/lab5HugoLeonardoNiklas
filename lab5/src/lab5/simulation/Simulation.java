package lab5.simulation;

import java.util.Observable;
import java.util.Observer;
import lab5.data.EventStore;
import lab5.data.State;
import lab5.gui.View;

/**
 * Runs the simulation
 * 
 * @author hugwan-6, leopel-6, inaule-6
 *
 */
public class Simulation implements Observer {
	
	private View view;
	private State state;
	private EventStore eventStore;
	
	/**
	 * Starts up the simulation
	 * 
	 * @param events the event array that contains at least one start event for the simulation.
	 * 
	 */
	public Simulation(Event[] startEvents) {
		state = new State();
		view = new View();	// WIP
		eventStore = new EventStore(startEvents);
		run();
	}
	
	/**
	 * Keeps the simulation running until it's done
	 * 
	 */
	public void run() {
		while(!eventStore.isEmpty()) {
			eventStore.nextEvent();
		}
	}
	
	public int setEventTime() {
		
	}
	
	/**
	 * Handle new info when the state of the simulation changes
	 * 
	 */
	public void update(Observable o, Object arg) {
		
	}
}
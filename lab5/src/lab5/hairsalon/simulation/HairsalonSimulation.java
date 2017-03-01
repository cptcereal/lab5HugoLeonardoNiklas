package lab5.hairsalon.simulation;

import java.util.Observable;
import java.util.Observer;
import lab5.data.EventStore;
import lab5.hairsalon.data.HairsalonSettings;
import lab5.hairsalon.data.HairsalonState;
import lab5.harisalon.events.Enter;
import lab5.simulation.Simulation;
import lab5.gui.View;

/**
 * Runs the hair salon simulation
 * 
 * @author hugwan-6, leopel-6, inaule-6
 *
 */
public class HairsalonSimulation extends Simulation implements Observer {
	private View view;
	private HairsalonState state;
	private EventStore eventStore;
	
	/**
	 * Starts up the simulation
	 * 
	 * @param events the event array that contains at least one start event for the simulation.
	 * 
	 */
	public HairsalonSimulation(Enter[] startEvents, HairsalonSettings simSettings) {
		super(startEvents);
		state = new HairsalonState(simSettings);
//		view = new View();	// WIP
//		eventStore = new EventStore(startEvents);
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
	
	public void addToEventStore(Event e) {
		eventStore.add(e);
	}
	
	
	/**
	 * Handle new info when the state of the simulation changes
	 * 
	 */
	public void update(Observable o, Object arg) {
		
	}
}
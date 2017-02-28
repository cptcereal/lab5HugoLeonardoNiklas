package lab5.hairsalon.simulation;

import java.util.Observable;
import java.util.Observer;
import lab5.data.EventStore;
import lab5.hairsalon.data.HairsalonState;
import lab5.harisalon.events.Enter;
import lab5.gui.View;

/**
 * Runs the simulation
 * 
 * @author hugwan-6, leopel-6, inaule-6
 *
 */
public class HairsalonSimulation implements Observer {
	private final int H_MIN;
	private final int H_MAX;
	private final int D_MIN;
	private final int D_MAX;
	private final int P;
	private View view;
	private HairsalonState state;
	private EventStore eventStore;
	
	/**
	 * Starts up the simulation
	 * 
	 * @param events the event array that contains at least one start event for the simulation.
	 * 
	 */
	public HairsalonSimulation(Enter[] startEvents, int H_MIN, int H_MAX, int D_MIN, int D_MAX, int P) {
		this.H_MIN = H_MIN;
		this.H_MAX = H_MAX;
		this.D_MIN = D_MIN;
		this.D_MAX = D_MAX;
		this.P = P;
		state = new HairsalonState();
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
	
	public int setEventID() {
		
	}
	
	/**
	 * Handle new info when the state of the simulation changes
	 * 
	 */
	public void update(Observable o, Object arg) {
		
	}
}
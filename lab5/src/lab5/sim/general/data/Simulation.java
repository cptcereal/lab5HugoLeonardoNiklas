package lab5.sim.general.data;

import lab5.sim.general.GUI.PrintAble;
import lab5.sim.general.GUI.View;

/**
 * Runs the simulation
 * 
 * @author hugwan-6, leopel-6, inaule-6
 *
 */
public abstract class Simulation {
	
	private View view;
	private State state;
	private EventStore eventStore;
	
	/**
	 * Starts up the simulation
	 * 
	 * @param events the event array that contains at least one start event for the simulation.
	 * 
	 */
	public Simulation(Event[] startEvents, State state) {
		this.state = state;
		eventStore = new EventStore(startEvents);
		run();
	}
	
	/**
	 * Keeps the simulation running until it's done
	 * 
	 */
	public void run() {
		while(!eventStore.isEmpty()) {
			state.startEvent(eventStore.nextEvent());
			if (state.getStop()) {
				break;
			}
		}
	}
	
	/**
	 * Add an event to the simulation.
	 * 
	 * @param e the event to add
	 */
	public void addToEventStore(Event e) {
		eventStore.add(e);
	}
	
	/**
	 * Sets the time of when an event should occur
	 * 
	 * @return the time until an event occurs
	 */
	public double setEventTime() {
		return 0;
		
	}
	
	/**
	 * Handle new info when the state of the simulation changes
	 * 
	 */
	public void printInfo(PrintAble infoToPrint) {
		view.showDataOnView(infoToPrint);
	}
}
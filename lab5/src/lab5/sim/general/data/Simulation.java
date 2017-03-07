package lab5.sim.general.data;

import lab5.sim.general.GUI.PrintAble;
import lab5.sim.general.GUI.View;
import lab5.sim.hairsalon.data.HairsalonState;
import lab5.sim.hairsalon.data.Start;

/**
 * Runs the simulation
 * 
 * @author hugwan-6, leopel-6, inaule-6
 */
public class Simulation {
	
	private View view;
	private State state;
	private EventStore eventStore;
	
	/**
	 * Starts up the simulation
	 * 
	 * @param state - the state of the simulation
	 */
	public Simulation(State state) {
		this.view = new View();
		this.state = state;
		eventStore = new EventStore();
		addToEventStore(new Start(this, new Time(0)));	// Add an start event to the EventStore
		run();
	}
	
	/**
	 * Keeps the simulation running until it's done or stopped
	 * 
	 */
	public void run() {
		while(!eventStore.isEmpty()) {
			Event e = eventStore.nextEvent();
			state.startEvent(e);
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
	public double setEventTime() {								// Needed?
		return 0;
		
	}
	
	/**
	 * Returns the simulations state
	 * 
	 * @return the state
	 */
	public State getState() {
		return state;
	}
	
	/**
	 * Changes the information displayed when the state changes
	 * 
	 * @param infoToPrint - the information to display
	 */
	public void printInfo(PrintAble infoToPrint) {
		view.showDataOnView(infoToPrint);
	}
}
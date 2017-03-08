package lab5.sim.general.data;

import java.io.IOException;

import lab5.sim.general.GUI.PrintAble;
import lab5.sim.general.GUI.View;
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
	 * @throws IOException 
	 */
	public Simulation(State state) throws IOException {
		this.view = new View();
		this.state = state;
		eventStore = new EventStore();
		addToEventStore(new Start(this, new Time(0)));	// Add an start event to the EventStore
		run();
	}
	
	/**
	 * Keeps the simulation running until it's done or stopped
	 * @throws IOException 
	 * 
	 */
	public void run() throws IOException {
		while(!eventStore.isEmpty()) {
			Event e = eventStore.nextEvent();
			state.startEvent(e);
			if (state.getStop()) {
				break;
			}
		}
		if (state.getStop() && !eventStore.isEmpty()) {
			throw new IOException("EventStore is not empty");
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
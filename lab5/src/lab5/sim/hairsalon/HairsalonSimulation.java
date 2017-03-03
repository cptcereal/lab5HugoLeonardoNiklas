package lab5.sim.hairsalon;

import java.util.Observable;
import java.util.Observer;
import lab5.sim.general.Event;
import lab5.sim.general.EventStore;
import lab5.sim.general.Simulation;
import lab5.sim.general.State;
import lab5.sim.general.View;

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
	private HairsalonSettings settings;
	private boolean simInfo;
	
	/**
	 * Starts up the simulation
	 * 
	 * @param events the event array that contains at least one start event for the simulation.
	 * 
	 */
	public HairsalonSimulation(Event[] startEvents, HairsalonState hairsalonState) {
		super(startEvents, hairsalonState);
		this.state = hairsalonState;
	}
		
	/**
	 * Handle new info when the state of the simulation changes
	 * 
	 */
	public void update(Observable o, Object arg) {
		
	}
}
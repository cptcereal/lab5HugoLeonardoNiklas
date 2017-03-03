package lab5.sim.hairsalon.data;

import java.util.Observable;
import java.util.Observer;
import lab5.sim.general.GUI.View;
import lab5.sim.general.data.Event;
import lab5.sim.general.data.EventStore;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.State;

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
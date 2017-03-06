package lab5.sim.hairsalon.data;

import java.util.Observable;
import java.util.Observer;

import lab5.sim.general.GUI.PrintAble;
import lab5.sim.general.GUI.View;
import lab5.sim.general.data.Event;
import lab5.sim.general.data.EventStore;
import lab5.sim.general.data.Simulation;

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
//	private HairsalonSettings settings;
	
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
	
	/**
	 * Prints out the simulations settings
	 * 
	 * @param settings - the settings of the simulation
	 */
	public void printSettings() {
		view.showDataOnView(state.getInfo().settings);
	}
	
	/**
	 * Prints out information of the state when an event occurs.
	 * 
	 * @param stateInfo - the information to print
	 */
	public void printEvent() {
		view.showDataOnView();
	}
	
	/**
	 * Prints out the end data of the simulation when the simulation is over.
	 * 
	 * @param simEndData - the end data to print.
	 */
	public void printEndData(PrintAble simEndData) {
		view.printEndData(simEndData);
	}
}
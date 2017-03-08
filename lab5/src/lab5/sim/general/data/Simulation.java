package lab5.sim.general.data;



import lab5.sim.general.GUI.View;

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
	 * @throws Exception 
	 */
	public Simulation(State state, View view) {
		this.view = view;
		this.state = state;
		eventStore = new EventStore();
	}
	
	/**
	 * Keeps the simulation running until it's done or stopped
	 * @throws Exception 
	 * 
	 */
	public void run() throws Exception {
		while(!eventStore.isEmpty() || state.getStop()) {
			Event e = eventStore.nextEvent();
			e.effect();
			if (state.getStop()) {
				break;
			}
		}
		if (state.getStop() && !eventStore.isEmpty()) {
			throw new Exception("EventStore is not empty");
		}
	}
	
	public void addStartEvent(Start e) throws Exception {
		eventStore.add(e);
		run();
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
	public View getView() {
		return view;
	}
}
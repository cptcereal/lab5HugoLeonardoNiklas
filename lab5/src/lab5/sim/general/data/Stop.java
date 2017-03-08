package lab5.sim.general.data;

public class Stop extends Event {
	
	/**
	 * Creates the event and assigns it a simulation, time
	 * 
	 * @param sim - the simulation the event effects
	 * @param time - the time that the event occurs
	 */
	public Stop(Simulation sim, Time time) {
		super(sim, time);
	}

	/**
	 * The effect the event has on the state of the simulation
	 * 
	 */
	public void effect() {
		State state = super.getSim().getState();
		state.stop();
	}
}

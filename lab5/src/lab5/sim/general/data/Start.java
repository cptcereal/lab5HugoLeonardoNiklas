package lab5.sim.general.data;

public class Start extends Event {

	/**
	 * Creates the event and assigns it a simulation, time
	 * 
	 * @param sim - the simulation the event effects
	 * @param time - the time that the event occurs
	 */
	public Start(Simulation sim, Time time) {
		super(sim, time);
	}

	/**
	 * The effect the event has on the state of the simulation
	 * 
	 */
	public void effect() {		
		Stop stop = new Stop(getSim(), new Time(999));
		getSim().addToEventStore(stop);
	}

}

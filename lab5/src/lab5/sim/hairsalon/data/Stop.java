package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.Time;

/**
 * Represents the event that the hair salon simulation ends
 * 
 * @author hugwan-6, leopel-6, inaule-6
 *
 */
public class Stop extends Event {

	/**
	 * Creates the event and assigns it a simulation, time and customer
	 * 
	 * @param sim - the simulation the event effects
	 * @param time - the time that the event occurs
	 * @param customer - the customer the event belongs to
	 */
	public Stop(Simulation sim, Time time) {
		super(sim, time);
	}
	
	/**
	 * The effect the stop event has on the state of the simulation when it occurs
	 * 
	 */
	public void effect() {
		HairsalonState state = ((HairsalonState)getSim().getState());
		state.addtimewaiting(this);
		super.getSim().printInfo(state.getInfo(this));
		state.stop();
	}
}
	
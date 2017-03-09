package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.Time;

/**
 * The event representing the hair salon closing
 * 
 * @author hugwan-6, leopel-6, inaule-6 
 */
public class Closing extends Event{
	
	/**
	 * The constructor
	 * 
	 * @param sim - the simulation the event belongs to
	 * @param time - the time when the event occurs
	 */
	public Closing(Simulation sim, Time time) {
		super(sim, time);
	}
	
	/**
	 * The effect the event has on the state of the simulation when it occurs
	 *
	 */
	public void effect() {
		
	}

	/**
	 * Adds the time of the event to to elapsed time of the simulation
	 * 
	 */
	public void addTime() {
		// TODO Auto-generated method stub
		HairsalonState state = ((HairsalonState)getSim().getState());
		state.addTime(super.getTime());
	}

}

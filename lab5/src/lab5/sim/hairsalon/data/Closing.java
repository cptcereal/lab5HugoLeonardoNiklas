package lab5.sim.hairsalon.data;

import lab5.sim.general.GUI.View;
import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.Time;
import lab5.sim.hairsalon.GUI.HairsalonView;

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
		HairsalonState state = ((HairsalonState)getSim().getState());
		state.addtimewaiting(this);
		state.calculateIdleTime(getTime());
		state.addTime(super.getTime());
		
		StateInfo info = state.getInfo(this);
		HairsalonView view =((HairsalonView)super.getSim().getView());
		view.printClosing(this);
	}

}

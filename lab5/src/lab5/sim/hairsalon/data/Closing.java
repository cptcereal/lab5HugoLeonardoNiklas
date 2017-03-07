package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.Time;

public class Closing extends Event{

	public Closing(Simulation sim, Time time) {
		super(sim, time);
	}
	
	public void effect() {
		HairsalonState state = ((HairsalonState)getSim().getState());
		state.addtimewaiting(this);
		state.calculateIdleTime(getTime());
		state.addTime(super.getTime());
		StateInfo info = state.getInfo(this);
		super.getSim().printInfo(info);
	}

}

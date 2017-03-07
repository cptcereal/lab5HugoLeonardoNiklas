package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.State;
import lab5.sim.general.data.Time;

public class Stop extends Event {

	public Stop(Simulation sim, Time time) {
		super(sim, time);
	}
	
	public void effect(State state) {
		((HairsalonState) state).getInfo(this, null);
		state.stop();
	}
}
	
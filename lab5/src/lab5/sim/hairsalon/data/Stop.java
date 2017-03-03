package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.Time;

public class Stop extends Event {

	public Stop(Simulation sim, Time tempTime) {
		super(sim, tempTime);
	}

	public void effect(HairsalonState state) {
		state.stop();
	}
	
}

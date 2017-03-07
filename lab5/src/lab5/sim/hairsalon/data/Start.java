package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.State;
import lab5.sim.general.data.Time;

public class Start extends Event{

	public Start(Simulation sim, Time tempTime) {
		super(sim, tempTime);
	}
	
	public void effect() {
		HairsalonState state = ((HairsalonState)getSim().getState());
		getSim().printInfo(state.getInfo(this).settings);
		getSim().printInfo(state.getInfo(this));
		Time tempTime = new Time (state.makeNewEnterEventTime());
		Customer c = new Customer( state.setCustoemrID());
		Enter e = new Enter(getSim(), tempTime, c);
		getSim().addToEventStore(e);
		
		Stop s = new Stop(getSim(), new Time(999));
		getSim().addToEventStore(s);
	}
	
}

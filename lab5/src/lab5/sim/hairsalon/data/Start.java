package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.Time;

public class Start extends Event{

	public Start(Simulation sim, Time tempTime) {
		super(sim, tempTime);
	
	}
	
	public void effect(HairsalonState state) {
		Time tempTime = new Time(state.makeNewEneterEventTime());
		Customer c = new Customer(state.setCustoemrID());
		Enter e = new Enter(getSim(), tempTime, c);
		getSim().addToEventStore(e);
	}
	
}
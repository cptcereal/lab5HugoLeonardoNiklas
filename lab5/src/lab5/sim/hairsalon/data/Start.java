package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.State;
import lab5.sim.general.data.Time;

public class Start extends Event{
	HairsalonSimulation sim;

	public Start(Simulation sim, Time tempTime) {
		super(sim, tempTime);
		this.sim = (HairsalonSimulation) sim;
	
	}
	
	public void effect(State state) {
		((HairsalonState) state).getInfo(this, null);
		Time tempTime = new Time(((HairsalonState) state).makeNewEnterEventTime());
		Customer c = new Customer(((HairsalonState) state).setCustoemrID());
		Enter e = new Enter(getSim(), tempTime, c);
		getSim().addToEventStore(e);
	}
	
}

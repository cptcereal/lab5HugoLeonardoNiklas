package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.Time;

/**
 * The event representing the start of the hair salon simulation
 * 
 * @author hugwan-6, leopel-6, inaule-6
 *
 */
public class Start extends Event{
	
	/**
	 * Creates the event and assigns it a simulation, time and customer
	 * 
	 * @param sim - the simulation the event effects
	 * @param time - the time that the event occurs
	 * @param customer - the customer the event belongs to
	 */
	public Start(Simulation sim, Time tempTime) {
		super(sim, tempTime);
	}
	
	/**
	 * The effect the start event has on the state of the hair salon
	 * 
	 */
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
		
		Closing closing = new Closing(getSim(), new Time(state.getInfo(e).settings.getClosingTime()));
		getSim().addToEventStore(closing);
	}
	
}

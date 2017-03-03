package lab5.harisalon.events;

import lab5.data.State;
import lab5.data.Time;
import lab5.hairsalon.data.Customer;
import lab5.hairsalon.data.HairsalonState;
import lab5.simulation.Event;
import lab5.simulation.Simulation;

/**
 * Represents what occurs when the salon is ready to cut a customers hair
 * @author hugwan-6, leopel-6, inaule-6 
 *
 */
public class HaircutReady extends Event{
	private final Customer customer;
	
	/**
	 * This is called when the salon is ready to cut the next customer's hair
	 * @param sim
	 * @param tempTime
	 * @param ID
	 */
	public HaircutReady(Simulation sim, Time tempTime, Customer customer) {
		super(sim, tempTime);
		this.customer = customer;
	}
	
	/**
	 * The desired effect HairCutReady has depending on the immediate state of the simulation, this affects 
	 * the queue, time elapsed, the time in queue 
	 * @param state
	 */
	public void effect(HairsalonState state){
		state.addTime(super.getTime());
		state.haircutFinished();
		if (state.dissatisfied()) {
			Time tempTime = new Time(state.setEventStartTime()); 
			Customer tempcos = customer;
			Dissatisfied event = new Dissatisfied(getSim(), tempTime, tempcos);
			getSim().addToEventStore(event);
		}
	}
	
	/**
	 * Returns customer
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}
}

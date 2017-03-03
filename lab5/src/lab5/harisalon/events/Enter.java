package lab5.harisalon.events;

import lab5.data.Time;
import lab5.hairsalon.data.Customer;
import lab5.hairsalon.data.HairsalonState;
import lab5.simulation.Event;
import lab5.simulation.Simulation;

/**
 * The event representing that a customer enters the hair salon
 * 
 * @author hugwan-6, leopel-6, inaule-6 
 *
 */
public class Enter extends Event{
	private final Customer customer;
	/**
	 * Simulates a customer entering the hair salon, the immediate outcome is defined by the 
	 * state at that exact moment in time. 
	 * @param sim
	 * @param time
	 * @param ID
	 */
	public Enter(Simulation sim, Time time, Customer customer) {
		super(sim, time);
		this.customer = customer;
	}
	
	/**
	 * Since a customer is entering the establishment, depending on the state of the hair salon, the outcome
	 * is decided immediately. 
	 */
	public void effect(HairsalonState state){
		/*The desired effect that enter has on the queue, state, and time*/
		state.addTime(super.getTime());
		state.addCustomer(customer);
		if (state.addHaircut(customer)) {
			Time a = new Time(state.setHaircutTime()); 
			Customer tempcos = customer;
			HaircutReady event = new HaircutReady(getSim(), a, tempcos);
			getSim().addToEventStore(event);
		}
		else {
			state.addToQueue(this);
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

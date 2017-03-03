package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.Time;

/**
 * Represents a customer returning for a free haircut after the previous cut left it dissatisfied
 * @author hugwan-6, leopel-6, inaule-6 
 * 
 */
public class Dissatisfied extends Event{
	private final Customer customer;
	
	/**
	 * This is called when certain conditions are met, and it represents a customer
	 * returning for a haircut after an random time
	 * @param time
	 * @param sim
	 * @param customer
	 */
	public Dissatisfied(Simulation sim, Time time, Customer customer){
		super(sim, time);
		this.customer = customer;
	}
	
	/**
	 * Is the effect that a dissatisfied customer has on the whole simulation state, meaning a the
	 * customer creates changes in the queue, which by itself creates changes to the time elapsed
	 * @param state
	 */
	public void effect(HairsalonState state){
		state.addTime(super.getTime());
		if (state.addHaircut(customer)) {
			Time a = new Time(state.setHaircutTime()); 
			Customer tempcos = customer;
			HaircutReady event = new HaircutReady(getSim(), a, tempcos);
			getSim().addToEventStore(event);
		}
		else {
			state.addToVipQueue(this);
		}
		/*Kunden placeras f�rst i k�n, tiden f�r alla kunder i k�n m�ste �kas med tiden det kommer f�r
		dissatisfied customer att klippa sig.
		*/ 
	}
	
	/**
	 * Returns customer
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}
}

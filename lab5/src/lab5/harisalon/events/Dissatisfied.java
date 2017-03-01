package lab5.harisalon.events;

import lab5.data.State;
import lab5.hairsalon.data.Customer;
import lab5.simulation.Event;
import lab5.simulation.Simulation;

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
	public Dissatisfied(int time, Simulation sim, Customer customer){
		super(sim, time);
		this.customer = customer;
	}
	
	/**
	 * Is the effect that a dissatisfied customer has on the whole simulation state, meaning a the
	 * customer creates changes in the queue, which by itself creates changes to the time elapsed
	 * @param state
	 */
	public void effect(State state){
		/*Kunden placeras f�rst i k�n, tiden f�r alla kunder i k�n m�ste �kas med tiden det kommer f�r
		dissatisfied customer att klippa sig.
		*/ 
	}
}

package lab5.harisalon.events;

import lab5.data.State;
import lab5.simulation.Simulation;

public class Dissatisfied {
	private final int ID;
	
	/**
	 * Dissatisfied is called when certain conditions are met, and it represents a customer
	 * returning for a haircut after an random time
	 * @param time
	 * @param sim
	 * @param ID
	 */
	public Dissatisfied(int time, Simulation sim, int ID){
		this.ID = ID;
		Enter enter = new Enter(sim, time, this.ID);
	}
	
	/**
	 * Is the effect that a dissatisfied customer has on the whole simulation state, meaning a the
	 * customer creates changes in the queue, which by itself creates changes to the time elapsed
	 * @param state
	 */
	public void effect(State state){
		/*Kunden placeras först i kön, tiden för alla kunder i kön måste ökas med tiden det kommer för
		dissatisfied customer att klippa sig.
		*/ 
	}
}

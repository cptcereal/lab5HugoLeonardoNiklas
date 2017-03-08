package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.Time;

/**
 * Represents a customer returning for a free haircut after the previous haircut left it dissatisfied
 * 
 * @author hugwan-6, leopel-6, inaule-6 
 * 
 */
public class Return extends Event{
	private final Customer customer;
	
	/**
	 * The constructor
	 * 
	 * @param time - the time when the event occurs
	 * @param sim - the simulation the event effects
	 * @param customer - the customer the event belongs to
	 */
	public Return(Simulation sim, Time time, Customer customer){
		super(sim, time);
		this.customer = customer;
	}
	
	/**
	 * The effect the return event has on the state of the hair salon
	 * 
	 */
	public void effect(){
		HairsalonState state = ((HairsalonState)getSim().getState());
		
		state.addtimewaiting(this);
		state.calculateIdleTime(getTime());
		
		
		state.addTime(super.getTime());
		
		// Get the new state info
		StateInfo info = state.getInfo(this);
		super.getSim().printInfo(info);
		
		state.addDissatisfied(customer);
		
		if (state.addHaircut()) {
			Time tempTime = new Time(state.setHaircutTime()); 
			Done event = new Done(getSim(), tempTime, customer);
			getSim().addToEventStore(event);
		}
		else {
			// If the dissatisfied queue is full, the customer goes for a walk and comes back later
			if (!state.addToVipQueue(customer)) {
				Time tempTime = new Time(state.setDissatisfiedStartTime());
				Return tempDiss = new Return(getSim(), tempTime, customer);
				getSim().addToEventStore(tempDiss);
			}
		}
	}
	
	/**
	 * Returns the customer whom the event belongs to
	 * 
	 * 
	 * @return the customer
	 */
	public Customer getCustomer(){
		return customer;
	}

}

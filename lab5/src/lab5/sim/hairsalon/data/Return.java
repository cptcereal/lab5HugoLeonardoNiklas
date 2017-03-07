package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.State;
import lab5.sim.general.data.Time;

/**
 * Represents a customer returning for a free haircut after the previous cut left it dissatisfied
 * @author hugwan-6, leopel-6, inaule-6 
 * 
 */
public class Return extends Event{
	private final Customer customer;
	/**
	 * This is called when certain conditions are met, and it represents a customer
	 * returning for a haircut after an random time
	 * @param time
	 * @param sim
	 * @param customer
	 */
	public Return(Simulation sim, Time time, Customer customer){
		super(sim, time);
		this.customer = customer;
	}
	
	/**
	 * Is the effect that a dissatisfied customer has on the whole simulation state, meaning a the
	 * customer creates changes in the queue, which by itself creates changes to the time elapsed
	 * @param state
	 */
	public void effect(){
		HairsalonState state = ((HairsalonState)getSim().getState());
		state.addTime(super.getTime());
		state.calculateIdleTime(getTime());
		StateInfo info = state.getInfo(this);
		super.getSim().printInfo(info);
		if (state.addHaircut(customer)) {
			Time tempTime = new Time(state.setHaircutTime()); 
			Done event = new Done(getSim(), tempTime, customer);
			getSim().addToEventStore(event);
		}
		else {
			if (!state.addToVipQueue(this)) {
				Time tempTime = new Time(state.setDissatisfiedStartTime());
				Return tempDiss = new Return(getSim(), tempTime, customer);
				getSim().addToEventStore(tempDiss);
			}
		}
	}
	
	public Customer getCustomer(){
		return customer;
	}

}

package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.Time;

/**
 * The event of the hair salon simulation that represents a customers hair cut being finished
 * 
 * @author hugwan-6, leopel-6, inaule-6 
 */
public class Done extends Event{
	private final Customer customer;
	
	/**
	 * Creates the event and assigns it a simulation, time and customer
	 * 
	 * @param sim - the simulation the event belongs to
	 * @param time - the time that the event occurs
	 * @param customer - the customer the event belongs to
	 */
	public Done(Simulation sim, Time time, Customer customer) {
		super(sim, time);
		this.customer = customer;
	}
	
	
	/**
	 * The done events effect on the state of the hair salon 
	 * 
	 */
	public void effect(){
		HairsalonState state = ((HairsalonState)getSim().getState());
		
		if (state.haircutFinished(customer)) {
			Done tempD = new Done(getSim(), new Time(state.setHaircutTime()), state.getNextInQueue());
			getSim().addToEventStore(tempD);
		}
		
		// If the customer was dissatisfied, create a new dissatisfied event
		if (state.dissatisfied()) {
			Time tempTime = new Time(state.setDissatisfiedStartTime()); 
			Return event = new Return(getSim(), tempTime, customer);
			getSim().addToEventStore(event);
		}
	}
	
	/**
	 * Returns the customer that the done event belongs to
	 * 
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}


	/**
	 * Adds the time of the event to to elapsed time of the simulation
	 * 
	 */
	public void addTime() {
		HairsalonState state = ((HairsalonState)getSim().getState());
		state.addtimewaiting(this);
		state.calculateIdleTime(getTime());
		
		state.addTime(super.getTime());
	}
}

package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.Time;

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
	public void effect(){
		HairsalonState state = ((HairsalonState)getSim().getState());
		if (super.getTime() > state.getElapsedTimeDouble()) {
			state.addtimewaiting(this);
			state.calculateIdleTime(getTime());
		}
		/*The desired effect that enter has on the queue, state, and time*/
		if (state.isOpen()) {
			if (state.addTime(super.getTime())) {
				Time tempTime  = new Time(state.makeNewEnterEventTime());
				Customer tempCustomer = new Customer(state.setCustoemrID());
				Enter tempEnter = new Enter(super.getSim(), tempTime, tempCustomer);
				super.getSim().addToEventStore(tempEnter);
				
				StateInfo info = state.getInfo(this);
				super.getSim().printInfo(info);
				
			}
			state.addCustomer(customer);
			if (state.addHaircut()) {
				Time timeTemp = new Time(state.setHaircutTime()); 
				Customer tempcos = customer;
				Done event = new Done(getSim(), timeTemp, tempcos);
				getSim().addToEventStore(event);
			}
			else {
				state.addToQueue(this);
			}
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

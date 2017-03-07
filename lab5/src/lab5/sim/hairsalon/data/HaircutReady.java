package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.State;
import lab5.sim.general.data.Time;

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
	public void effect(){
		HairsalonState state = ((HairsalonState)getSim().getState());
		state.addTime(super.getTime());
		
		((HairsalonState) state).calculateIdleTime(getTime());
		StateInfo info = ((HairsalonState) state).getInfo(this);
		super.getSim().printInfo(info);
		
		((HairsalonState) state).haircutFinished();
		if (((HairsalonState) state).dissatisfied(customer)) {
			Time tempTime = new Time(((HairsalonState) state).setDissatisfiedStartTime()); 
			Dissatisfied event = new Dissatisfied(getSim(), tempTime, customer);
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

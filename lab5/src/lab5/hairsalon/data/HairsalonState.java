package lab5.hairsalon.data;

import java.util.ArrayList;

import lab5.data.State;
import lab5.data.Time;
import lab5.harisalon.events.*;
import lab5.simulation.Event;

/**
 * 
 * @author inaule-6
 *
 */
public class HairsalonState extends State {
	
	private HairsalonSettings settings;
	
	private int numHaircut;
	private int numWaiting;
	
	private ArrayList<Customer> customerList;
	private ArrayList<Customer> haircutList;
	private ArrayList<Enter> queueList;
	
	private Time timeIdle;
	
	/**
	 * Makes HarisaloneState.
	 */
	public HairsalonState(HairsalonSettings settings) {
		super();
		
		this.settings = settings;
		
		customerList = new ArrayList<Customer>();
		haircutList = new ArrayList<Customer>();
		queueList = new ArrayList<Enter>();
		
		numHaircut = 0;
		numWaiting = 0;
		timeIdle = new Time();
		
	}
	
	/**
	 * 
	 * @param e
	 */
	public void handleCustomer(Event e) {
		e.effect(this);
	}
	
	public boolean addHaircut(Customer c) {
		if (settings.getMAX_CHAIRS() - numHaircut > 0) {
			numHaircut += 1;
			haircutList.add(c);
		} 
		return false;
	}
	
	
	
	public void addToQueue(Enter e) {
		queueList.add(e);
	}
	
	public boolean addCustomer(Customer c) {
		for (int i = 0; i < customerList.size(); i++) {
			if (c.equals(customerList.get(i))) {
				return false;
			} 
		}
		customerList.add(c);
		return true;
	}
}

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
	
	private final int MAX_CHAIRS;
	private final int MAX_QUEUE;
	
	private int numHaircut;
	private int numWaiting;
	
	private ArrayList<Customer> customerList;
	private ArrayList<Customer> haircutList;
	private ArrayList<Enter> queueList;
	
	private Time timeIdle;
	
	/**
	 * Makes HarisaloneState.
	 */
	public HairsalonState(int chairs, int queue, double hmin, double hmax, double dmin, double  dmanx, int p) {
		super();
		MAX_CHAIRS = chairs;
		MAX_QUEUE = queue;
		
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
		if (e instanceof Enter) {
			addcustomer(e.getCustomer());
			if (numHaircut < MAX_CHAIRS) {
				haircutList.add(e.getCustomer());
				e.effect(this);
			} 
			else {
				
			}
		} 
		else if (e instanceof Dissatisfied) {
			
		}
		else {
			
		}
		e.effect(this);
		addcustomer(e.getCustomer());
	}
	
	/**
	 * Get all the info about the simulator and returns it.
	 * @return
	 */
	public int[][] getInfo() {
		return null;
	}
	
	private void addcustomer(Customer c) {
		for (int i = 0; i < customerList.size(); i++) {
			if (c.equals(customerList.get(i))) {
				return;
			} 
		}
		customerList.add(c);
	}
}

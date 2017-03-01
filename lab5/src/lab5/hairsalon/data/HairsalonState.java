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
		if (e instanceof Enter) {
			// Tar hand om alla enter events
			if (numHaircut < MAX_CHAIRS) {
				haircutList.add(e.getCustomer());
				//calkCuttime();
				e.effect(this);
			} 
			else {
				queueList.add(e);
			}
		} 
		else if (e instanceof Dissatisfied) {
			// Tar hand om alla dissatisfied events.
			
		}
		else {
			// Tar hand om alla haircutevents.
		}
		e.effect(this);
		addToList(e.getCustomer(), customerList);
	}
	
	/**
	 * Get all the info about the simulator and returns it.
	 * @return
	 */
	public int[][] getInfo() {
		return null;
	}
	
	private void addToList(Customer c, ArrayList<Customer> a) {
		for (int i = 0; i < a.size(); i++) {
			if (c.equals(a.get(i))) {
				return;
			} 
		}
		a.add(c);
	}
}

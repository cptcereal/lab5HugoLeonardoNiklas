package lab5.hairsalon.data;

import java.util.ArrayList;

import lab5.data.State;
import lab5.data.Time;
import lab5.harisalon.events.Enter;
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
	public HairsalonState(int chairs, int queue) {
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
		e.effect(this);
		
	}
	
	/**
	 * Get all the info about the simulator and returns it.
	 * @return
	 */
	public int[][] getInfo() {
		return null;
	}
	
}

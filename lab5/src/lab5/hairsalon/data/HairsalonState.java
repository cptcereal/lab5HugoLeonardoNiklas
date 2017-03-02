package lab5.hairsalon.data;

import java.util.ArrayList;

import lab5.data.State;
import lab5.data.Time;
import lab5.hairsalon.random.UniformRandomStream;
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
	private UniformRandomStream randomHaircutTime;
	
	private int lastId;
	
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
		lastId = 0;
		
		timeIdle = new Time();
		randomHaircutTime = new UniformRandomStream(settings.getHmin(), settings.getHmax(), );
		
	}
	
	public boolean addHaircut(Customer c) {
		if (settings.getMAX_CHAIRS() - numHaircut > 0) {
			numHaircut += 1;
			haircutList.add(c);
		} 
		return false;
	}
	
	public boolean addToQueue(Enter e) {
		if (queueList.size() < settings.getMaxQueue()) {
			queueList.add(e);
			return true;
		}
		return false;
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
	
	/**
	 * Sets the time of when a event in the hair salon occurs.
	 * 
	 * @return the time when the event should occur.
	 */
	public double setEventTime() {
		return hj;
	}
	
	public int setEventID() {
		lastId += 1;
		return lastId;
	}
}

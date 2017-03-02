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
	private QueueList queueList;
	
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
		queueList = new QueueList(settings.getMAX_CHAIRS());
		
		numHaircut = 0;
		numWaiting = 0;
		lastId = 0;
		
		timeIdle = new Time();
		randomHaircutTime = new UniformRandomStream(settings.getHmin(), settings.getHmax(), System.currentTimeMillis());
		
	}
	
	public boolean addHaircut(Customer c) {
		if (settings.getMAX_CHAIRS() - numHaircut > 0) {
			numHaircut += 1;
			haircutList.add(c);
		} 
		return false;
	}
	
	public boolean addToQueue(Event e) {
		return queueList.addToQueue(e);
	}
	
	public boolean addToVipQueue(Event e) {
		return queueList.addToVIPQueue(e);
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
	public double getEventStartTime() {
		return hj;
	}
	
	public double getHaircutTime() {
		double temp = randomHaircutTime.next();
		return temp;
	}
	
	public int getEventID() {
		lastId += 1;
		return lastId;
	}
}

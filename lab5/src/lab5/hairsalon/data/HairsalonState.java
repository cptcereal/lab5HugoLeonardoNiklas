package lab5.hairsalon.data;

import lab5.data.State;
import lab5.data.Time;
import lab5.hairsalon.random.*;
import lab5.harisalon.events.*;
import lab5.simulation.Event;

/**
 * 
 * @author hugwan-6, leopel-6, inaule-6 
 *
 */
public class HairsalonState extends State {
	
	private HairsalonSettings settings;
	private CustomerList customerList;
	private CustomerList haircutList;
	private QueueList queueList;
	private Time timeIdle;
	
	private int numHaircut;
	private int lastId;
	
	private UniformRandomStream randomHaircutTime;
	private UniformRandomStream randomEnterTime;
	private ExponentialRandomStream randomNewEnter;
	
	
	/**
	 * Makes HarisaloneState.
	 */
	public HairsalonState(HairsalonSettings settings) {
		super();
		
		this.settings = settings;
		
		customerList = new CustomerList();
		haircutList = new CustomerList();
		queueList = new QueueList(settings.getMAX_CHAIRS());
		
		numHaircut = 0;
		lastId = 0;
		
		timeIdle = new Time();
		randomHaircutTime = new UniformRandomStream(settings.getHmin(), settings.getHmax(), System.currentTimeMillis());
		randomEnterTime = new UniformRandomStream(settings.getDmin(), settings.getDmax(), System.currentTimeMillis());
		randomNewEnter = new ExponentialRandomStream(settings.getCustomersPerHour(), System.currentTimeMillis());
		
	}
	
	
	
	public StateInfo getInfo() {
		StateInfo info = new StateInfo(settings, customerList, haircutList, queueList, timeIdle, super.getElapsedTime());
		return info;
	}
	
	
	
	
	
	public void haircutFinished() {
		numHaircut -= 1;
		if (queueList.isEmpty() == false) {
			Event e = queueList.next();
			timeIdle.addTime(super.getElapsedTimeDouble()-e.getTime());
		}
	}
	
	
	public boolean addHaircut(Customer c) {
		if (settings.getMAX_CHAIRS() - numHaircut > 0) {
			numHaircut += 1;
			haircutList.addCustomer(c);
			return true;
		} 
		return false;
	}
	
	public boolean addToQueue(Enter e) {
		return queueList.addToQueue(e);
	}
	
	public boolean addToVipQueue(Dissatisfied e) {
		return queueList.addToVIPQueue(e);
	}
	
	public boolean addCustomer(Customer c) {
		return customerList.addCustomer(c);
	}
	
	/**
	 * Sets the time of when a event in the hair salon occurs.
	 * 
	 * @return the time when the event should occur.
	 */
	public double setEventStartTime() {
		return randomEnterTime.next() + super.getElapsedTimeDouble();
	}
	/**
	 * Vet ej vad den gör
	 * Använder håkans class
	 * @return
	 */
	public double makeNewEneterEvent() {
		return randomNewEnter.next();
	}
	
	public double setHaircutTime() {
		return randomHaircutTime.next() + super.getElapsedTimeDouble();
	}
	
	public int setEventID() {
		lastId += 1;
		return lastId;
	}
}

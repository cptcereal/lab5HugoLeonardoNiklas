package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.State;
import lab5.sim.general.data.Time;
import lab5.sim.hairsalon.random.*;

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
	private UniformRandomStream randomDissatisfied;
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
		randomDissatisfied = new UniformRandomStream(settings.getDmin(), settings.getDmax(), System.currentTimeMillis());
		randomNewEnter = new ExponentialRandomStream(settings.getCustomersPerHour(), System.currentTimeMillis());
		
	}
	
	
	public boolean isOpen() {
		if (super.getStop()) {
			return false;
		}
		return settings.getClosingTime() < super.getElapsedTimeDouble(); 
	}
	
	
	public StateInfo getInfo() {
		StateInfo info = new StateInfo(settings, customerList, haircutList, queueList, timeIdle, super.getElapsedTime());
		return info;
	}
	
	public void haircutFinished() {
		numHaircut -= 1;
		if (queueList.isEmpty() == false) {
			Event e = queueList.next();
			timeIdle.addTime(super.getElapsedTimeDouble() * 2 -e.getTime());
			e.effect(this);
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
	 * Sets the time of when a Dissatisfied customer returns.
	 * 
	 * @return the time when the event should occur.
	 */
	public double setDissatisfiedStartTime() {
		return randomDissatisfied.next() + super.getElapsedTimeDouble();
	}
	
	public boolean dissatisfied() {
		
		return false;
	}
	
	/**
	 *  Returns the time when the next customers comes. 
	 *  
	 * @return
	 */
	public double makeNewEneterEventTime() {
		return randomNewEnter.next() + super.getElapsedTimeDouble();
	}
	
	/**
	 * 
	 * @return
	 */
	public double setHaircutTime() {
		return randomHaircutTime.next() + super.getElapsedTimeDouble();
	}
	
	public int setCustoemrID() {
		lastId += 1;
		return lastId;
	}
}

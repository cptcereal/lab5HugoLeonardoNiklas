package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.State;
import lab5.sim.general.data.Time;
import lab5.sim.hairsalon.random.*;

/**
 * The state of the hair salon
 * 
 * @author hugwan-6, leopel-6, inaule-6 
 *
 */
public class HairsalonState extends State {
	
	private HairsalonSettings settings;
	private CustomerList customerList;
	private CustomerList haircutList;
	private QueueList queueList;
	private Time timeWaiting;
	private Time timeIdle;

	private int numDissatisfied;
	private int numHaircut;
	private int lastId;
	
	private UniformRandomStream randomHaircutTime;
	private UniformRandomStream randomDissatisfiedTime;
	private UniformRandomStream randomNewDissatisfied;
	private ExponentialRandomStream randomNewEnter;

	
	/**
	 * Creates a hair salon state with the desired settings specified
	 * 
	 * @param settings - the settings to use
	 */
	public HairsalonState(HairsalonSettings settings) {
		super();
		
		this.settings = settings;
		customerList = new CustomerList();
		haircutList = new CustomerList();
		queueList = new QueueList(settings.getMaxQueue());
		
		numHaircut = 0;
		lastId = 0;
		numDissatisfied = 0;
		
		timeWaiting = new Time();
		timeIdle = new Time();
		randomHaircutTime = new UniformRandomStream(settings.getHmin(), settings.getHmax(), settings.getSeed());
		randomDissatisfiedTime = new UniformRandomStream(settings.getDmin(), settings.getDmax(), settings.getSeed());
		randomNewEnter = new ExponentialRandomStream(settings.getCustomersPerTimeUnit(), settings.getSeed());
		randomNewDissatisfied = new UniformRandomStream(0, 1, settings.getSeed());
		
		
	
	}
	
	/**
	 * @return true if the hair salon is open
	 * 
	 */
	public boolean isOpen() {
		return settings.getClosingTime() > super.getElapsedTimeDouble(); 
	}
	
	/**
	 * Creates a object containing all the information of the state when something changes
	 * 
	 * @param e - the event that changes the state
	 * @return information about the state
	 */
	public StateInfo getInfo(Event e) {
		StateInfo info = new StateInfo(settings, customerList, haircutList, queueList, timeIdle, timeWaiting, super.getElapsedTime(), e, 
				numHaircut, numDissatisfied);
		return info;
	}
	
	/**
	 * 
	 * @param c
	 */
	public void haircutFinished(Customer c) {
		haircutList.addCustomer(c);
		numHaircut -= 1;
		if (queueList.isEmpty() == false) {
			Event e = queueList.next();
			e.effect();
		}
	}
	
	public void addtimewaiting(Event e) {
		timeWaiting.addTime(queueList.getQueueSize() *(e.getTime() - super.getElapsedTimeDouble()));
	}
	
	public boolean addHaircut() {
		if (settings.getMaxChairs() - numHaircut > 0) {
			numHaircut += 1;
			return true;
		} 
		return false;
	}
	
	public boolean addToQueue(Enter e) {
		return queueList.addToQueue(e);
	}
	
	public boolean addToVipQueue(Return e) {
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
		return randomDissatisfiedTime.next() + super.getElapsedTimeDouble();
	}
	
	public boolean dissatisfied(Customer c) {
		double temp = randomNewDissatisfied.next();
		if (temp <= settings.getP()) {
			return true;
		}
		return false;
	}
	
	public void calculateIdleTime(double time) {
		double idleTime = (settings.getMaxChairs() - numHaircut)*(time - super.getElapsedTimeDouble());
		timeIdle.addTime(idleTime);
	}
	
	/**
	 *  Returns the time when the next customers comes. 
	 *  
	 * @return
	 */
	public double makeNewEnterEventTime() {
		double a = randomNewEnter.next() + super.getElapsedTimeDouble();
		return a;
	}
	
	/**
	 * 
	 * @return
	 */
	public double setHaircutTime() {
		return randomHaircutTime.next() + super.getElapsedTimeDouble();
	}
	
	public int setCustoemrID() {
		int temp = lastId;
		lastId += 1;
		return temp;
	}
	
	public void addDissatisfied(){
		numDissatisfied += 1;
	}

}

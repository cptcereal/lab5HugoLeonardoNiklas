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
	 * Change the state when an haircut is completed
	 * 
	 * @param c - the customer that's finished
	 */
	public void haircutFinished(Customer c) {
		haircutList.addCustomer(c);
		numHaircut -= 1;
		if (queueList.isEmpty() == false) {
			Event e = queueList.next();
			e.effect();
		}
	}
	
	/**
	 * Adds time the time customers waited in queue to the total time all customers have been waiting in the queue
	 * 
	 * @param e - the event to add time from
	 */
	public void addtimewaiting(Event e) {
		timeWaiting.addTime(queueList.getQueueSize() *(e.getTime() - super.getElapsedTimeDouble()));
	}
	
	/**
	 * Starts cutting the hair of a customer if a chair in the hair salon is available
	 * 
	 * @return true if the customer can start getting their haircut
	 */
	public boolean addHaircut() {
		if (settings.getMaxChairs() - numHaircut > 0) {
			numHaircut += 1;
			return true;
		} 
		return false;
	}
	
	/**
	 * Moves a customer to the queue if no chairs are available when they enter the hair salon
	 * 
	 * @param e - the event to move to the queue
	 * @return if the customer could be added to the queue
	 */
	public boolean addToQueue(Enter e) {
		return queueList.addToQueue(e);
	}
	
	/**
	 * Moves a dissatisfied customer that enters the hair salon to the queue
	 * 
	 * @param e - the return event to move to the queue
	 * @return if the customer could be added to the queue
	 */
	public boolean addToVipQueue(Return e) {
		return queueList.addToVIPQueue(e);
	}
	
	/**
	 * Adds a new customer to the hair salons customer list
	 * 
	 * @param c - the customer
	 * @return if the customer was a new customer or not
	 */
	public boolean addCustomer(Customer c) {
		return customerList.addCustomer(c);
	}
	
	/**
	 * Sets the time of when a dissatisfied customer returns to the hair salon to get their haircut fixed
	 * 
	 * @return the time when the event should occur
	 */
	public double setDissatisfiedStartTime() {
		return randomDissatisfiedTime.next() + super.getElapsedTimeDouble();
	}
	
	/**
	 * Randomly decides if the customer was dissatisfied with their haircut or not
	 * 
	 * @param c - the customer that might get dissatisfied
	 * @return whether or not the customer became dissatisfied
	 */
	public boolean dissatisfied(Customer c) {
		double temp = randomNewDissatisfied.next();
		if (temp <= settings.getP()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Calculates the time chairs in the hair salon was idle
	 * 
	 * @param time - the new time of the simulation
	 */
	public void calculateIdleTime(double time) {
		double idleTime = (settings.getMaxChairs() - numHaircut)*(time - super.getElapsedTimeDouble());
		timeIdle.addTime(idleTime);
	}
	
	/**
	 * Decides a new time for a customer to arrive at the hair salon
	 *  
	 * @return the time of the customers arrival
	 */
	public double makeNewEnterEventTime() {
		double a = randomNewEnter.next() + super.getElapsedTimeDouble();
		return a;
	}
	
	/**
	 * Decide the time it takes to cut a customers hair
	 * 
	 * @return the haircut time
	 */
	public double setHaircutTime() {
		return randomHaircutTime.next() + super.getElapsedTimeDouble();
	}
	
	/**
	 * Picks an ID for a new customer
	 * 
	 * @return the customers ID
	 */
	public int setCustoemrID() {
		int temp = lastId;
		lastId += 1;
		return temp;
	}
	
	/**
	 * Increase the amount of dissatisfied customer the hair salon has had during the simulation
	 * 
	 * 
	 */
	public void addDissatisfied(){
		numDissatisfied += 1;
	}

}

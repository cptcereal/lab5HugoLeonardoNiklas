package lab5.sim.hairsalon.data;

import lab5.sim.general.data.Time;

/**
 * All the information about the state of the hair salon that's going to be displayed
 * 
 * @author hugwan-6, leopel-6, inaule-6
 *
 */
public class StateInfo {
	
	private final HairsalonSettings settings;
	private final CustomerList customerList;
	private final CustomerList haircutList;
	private final CustomerList dissatisfiedlist;
	private final QueueList queueList;
	private final Time timeWaiting;
	private final Time elapsedTime;
	private final Time timeIdle;
	private final int numHaircut;
	
	/**
	 * The constructor takes in all the information about that simulation that we are interested in displaying
	 * 
	 * @param settings - the settings of the simulation
	 * @param customerList 
	 * @param haircutList
	 * @param queueList
	 * @param timeIdle - the time chairs in the hair salon was idle
	 * @param timeWaiting - the total waiting time of the customers
	 * @param elapsedTime - the time of the simulation
	 * @param numHaircut
	 * @param dissatisfiedlist
	 */
	public StateInfo(HairsalonSettings settings, CustomerList customerList, CustomerList haircutList, QueueList queueList, 
			Time timeIdle, Time timeWaiting, Time elapsedTime, int numHaircut, CustomerList dissatisfiedlist){
		
		this.settings = settings;
		this.customerList = customerList;
		this.haircutList = haircutList;
		this.queueList = queueList;
		this.timeWaiting = timeWaiting;
		this.elapsedTime = elapsedTime;
		this.numHaircut = numHaircut;
		this.dissatisfiedlist = dissatisfiedlist;
		this.timeIdle = timeIdle;
	}
	
	/**
	 * 
	 * @return number of customers in the queue
	 */
	public int numWaiting() {
		return queueList.getQueueSize();
	}
	
	/**
	 * 
	 * @return number of lost customers
	 */
	public int numLost(){
		return queueList.getLost();
	}
	
	/**
	 * 
	 * @return number of idle chairs in the hair salon
	 */
	public  int idleChairs(){
		return (settings.getMaxChairs() - numHaircut);
	}
	
	/**
	 * 
	 * @return number of customers that have been cut in the hair salon
	 */
	public  int numCut(){
		return haircutList.numCustomers();
	}
	/**
	 * 
	 * @return idle time of the chairs in the hair salon
	 */
	public double tIdle(){
		return timeIdle.getElapsedTime(); 
	}
	
	/**
	 * Returns the average cutting time of all the customers who got their hair cut during the simulation
	 * 
	 * @return average cutting time
	 */
	public  double averageCuttingTime() { 
		return ((elapsedTime.getElapsedTime() * settings.getMaxChairs()) - tIdle()) / numCut();
	}
	
	/**
	 * Returns the average queue time of all the customers who got their hair cut during the simulation
	 * 
	 * @return average queue time
	 */
	public  double averageQueueTime() {
		return (timeWaiting.getElapsedTime() /  numCut()); 
	}

	/**
	 * Returns the settings of the hairsalon
	 * @return
	 */
	public HairsalonSettings getSettings(){
		return settings;
	}
	
	/**
	 * Returns the number of customers in the list
	 * @return
	 */
	public int getnumCustomer(){
		return customerList.numCustomers();
	}
	
	/**
	 * Returns the number of dissatisfied customers in the simulation
	 * @return
	 */
	public int getDissatisfiedCustomers(){
		return dissatisfiedlist.numCustomers();
	}
	
	/**
	 * Returns the time a customer has been waiting in the queue
	 * @return
	 */
	public double getTimeWaiting(){
		return timeWaiting.getElapsedTime();
	}
	
	/**
	 * Returns the amount of max amount of customers the queue can "handle"
	 * @return
	 */
	public int getMaxNumWaiting(){
		return queueList.getMaxNumWaiting();
	}
}

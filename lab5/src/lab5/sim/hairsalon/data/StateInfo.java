package lab5.sim.hairsalon.data;

import com.sun.scenario.Settings;

import lab5.sim.general.GUI.PrintAble;
import lab5.sim.general.data.Event;
import lab5.sim.general.data.Time;

/**
 * All the information about the state of the hair salon that's going to be displayed
 * 
 * @author hugwan-6, leopel-6, inaule-6
 *
 */
public class StateInfo implements PrintAble {
	
	private final HairsalonSettings settings;
	private final CustomerList customerList;
	private final CustomerList haircutList;
	private final CustomerList dissatisfiedlist;
	private final QueueList queueList;
	private final Time timeWaiting;
	private final Time elapsedTime;
	private final Time timeIdle;
	//private final Event event;
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
	 * @param event
	 * @param numHaircut
	 * @param dissatisfiedlist
	 */
	public StateInfo(HairsalonSettings settings, CustomerList customerList, CustomerList haircutList, QueueList queueList, 
			Time timeIdle, Time timeWaiting, Time elapsedTime, Event event, int numHaircut, CustomerList dissatisfiedlist){
		
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
		return (timeWaiting.getElapsedTime() / numCut()); 
	}

	public HairsalonSettings getSettings(){
		return settings;
	}
	
	public int getnumCustomer(){
		return customerList.numCustomers();
	}
	
	public CustomerList getHaircutList(){
		return haircutList;
	}
	
	public CustomerList getDissatisfiedList(){
		return dissatisfiedlist;
	}
	
	public QueueList getQueueList(){
		return queueList; 
	}
	
	public double getTimeWaiting(){
		return timeWaiting.getElapsedTime();
	}
	
	

	
	/**
	 * Updates the information about the state depending on what event that happens
	 */
	public void printAll() {
		
		if (event.getClass().equals(StartHSS.class)) {
			System.out.format("%s %2s %6s %6s %6s %7s %6s %6s %6s %6s %n", "- Time" , "Event", "Id", "Idle", "TIdle", "TWait", "InQ", "Cut", "Lost", "Ret -");
			System.out.format("%6.2f %2s %n", elapsedTime.getElapsedTime(), eventName());
		
		} else if (event.getClass().equals(StopHSS.class)) {
			System.out.format("%6.2f %2s %10s %6.2f %7.2f %6s %6s %6s %4s %n", event.getTime(), eventName(), idleChairs(), tIdle(), timeWaiting.getElapsedTime(), numWaiting(), numCut(),numLost(),dissatisfiedlist.numCustomers());
			System.out.println("---------------------------------------------------------------------");
			System.out.format("%s %2s %n", "Number of customers cut: ......:", numCut());
			System.out.format("%s %2.2f %n", "Average cutting time...........:", averageCuttingTime());
			System.out.format("%s %2.2f %n", "Average queueing time: ........:", averageQueueTime());
			System.out.format("%s %1s %n", "Largest queue (max NumWaiting) :", queueList.getMaxNumWaiting());
			System.out.format("%s %1s %n", "Customers not cut (NumLost) ...:", numLost());
			System.out.format("%s %1s %n", "Dissatisfied customers: .......:", dissatisfiedlist.numCustomers());
			System.out.format("%s %2.2f", "Time chairs were idle: ........:", tIdle());
			
		} else if (event.getClass().equals(Done.class)) {
			System.out.format("%6.2f %2s %6s %6s %6.2f %7.2f %6s %6s %6s %4s %n", elapsedTime.getElapsedTime(), eventName(),customerID() ,idleChairs(), tIdle(), timeWaiting.getElapsedTime(), numWaiting(), numCut(),numLost(), dissatisfiedlist.numCustomers());
		
		} else if (event.getClass().equals(Return.class)) {
			System.out.format("%6.2f %2s %4s %6s %6.2f %7.2f %6s %6s %6s %4s %n", elapsedTime.getElapsedTime(), eventName(),customerID() ,idleChairs(), tIdle(), timeWaiting.getElapsedTime(), numWaiting(), numCut(),numLost(), dissatisfiedlist.numCustomers());
		
		} else if (event.getClass().equals(Enter.class)) {
			System.out.format("%6.2f %2s %5s %6s %6.2f %7.2f %6s %6s %6s %4s %n", elapsedTime.getElapsedTime(), eventName(),customerID() ,idleChairs(), tIdle(), timeWaiting.getElapsedTime(), numWaiting(), numCut(),numLost(), dissatisfiedlist.numCustomers());
		
		} else if (event.getClass().equals(Closing.class)) {
			System.out.format("%6.2f %2s %n", elapsedTime.getElapsedTime(), eventName());
		}
	}
}

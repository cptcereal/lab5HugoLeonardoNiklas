package lab5.sim.hairsalon.data;

import lab5.sim.general.GUI.PrintAble;
import lab5.sim.general.data.Event;
import lab5.sim.general.data.EventStore;
import lab5.sim.general.data.State;
import lab5.sim.general.data.Time;

/**
 * All state info.
 * 
 * @author inaule-6
 *
 */
public class StateInfo implements PrintAble {
	public final HairsalonSettings settings;
	public final CustomerList customerList;
	public final CustomerList haircutList;
	public final int numDissatisfied;
	public final QueueList queueList;
	public final Time timeWaiting;
	public final Time elapsedTime;
	public final Time timeIdle;
	public final Event event;
	public final int numHaircut;
	//public final Customer customer;
	
	public StateInfo(HairsalonSettings settings, CustomerList customerList, CustomerList haircutList, QueueList queueList, 
			Time timeIdle, Time timeWaiting, Time elapsedTime, Event event, int numHaircut, int numDissatisfied){
		this.settings = settings;
		this.customerList = customerList;
		this.haircutList = haircutList;
		this.queueList = queueList;
		this.timeWaiting = timeWaiting;
		this.elapsedTime = elapsedTime;
		this.event = event;
		this.numHaircut = numHaircut;
		this.numDissatisfied = numDissatisfied;
		this.timeIdle = timeIdle;
//		this.state = state;
		//this.customer = customer;
	}
	
	private int numWaiting() {
		return queueList.getQueueSize();
	}
	
	private int numLost(){
		return queueList.getLost();
	}
	
	private int idleChairs(){
		return (settings.getMAX_CHAIRS() - numHaircut);
	}
	
	private int numCut(){
		return haircutList.numCustomers();
	}
	
	private String eventName(){
		return event.toString();
	}
	
	private double tIdle(){
		return timeIdle.getElapsedTime(); 
	}
	
	private double averageCuttingTime() {
		return (elapsedTime.getElapsedTime() - tIdle()) / numCut();
	}
	
	private double averageQueueTime() {
		return 2.0;
	}
	
	private int customerID(){
		if(event.getClass().equals(Enter.class)) {
			return ((Enter) event).getCustomer().getID();
		} else if (event.getClass().equals(Done.class)) {
			return ((Done) event).getCustomer().getID();
		} else {
			return ((Return) event).getCustomer().getID();
		}
	}

	public void printAll() {
		
		if(event.getClass().equals(Start.class)) {
			System.out.format("%s %2s %6s %6s %6s %7s %6s %6s %6s %6s %n", "- Time" , "Event", "Id", "Idle", "TIdle", "TWait", "InQ", "Cut", "Lost", "Ret -");
			System.out.format("%6.2f %2s %n", elapsedTime.getElapsedTime(), eventName());
		}else if(event.getClass().equals(Stop.class)) {
			System.out.format("%6.2f %2s %13s %6.2f %7.2f %6s %6s %6s %4s %n", event.getTime(), eventName(), idleChairs(), tIdle(), timeWaiting.getElapsedTime(), numWaiting(), numCut(),numLost(), numDissatisfied);
			System.out.println("----------------------------------------------------------------");
			System.out.format("%s %2s %n", "Number of customers cut: ......:", numCut());
			System.out.format("%s %2.2f %n", "Average cutting time...........:", averageCuttingTime());
			System.out.format("%s %2.2f %n", "Average queueing time: ........:", averageQueueTime());
			System.out.format("%s %1s %n", "Largest queue (max NumWaiting) :", queueList.getMaxNumWaiting());
			System.out.format("%s %1s %n", "Customers not cut (NumLost) ...:", numLost());
			System.out.format("%s %1s %n", "Dissatisfied customers: .......:", numDissatisfied);
			System.out.format("%s %2.2f", "Time chairs were idle: ........:", tIdle());
		}else if(event.getClass().equals(Done.class)) {
			System.out.format("%6.2f %2s %6s %6s %6.2f %7.2f %6s %6s %6s %4s %n", elapsedTime.getElapsedTime(), eventName(),customerID() ,idleChairs(), tIdle(), timeWaiting.getElapsedTime(), numWaiting(), numCut(),numLost(), numDissatisfied);
		}
		else if(event.getClass().equals(Return.class)) {
			System.out.format("%6.2f %2s %4s %6s %6.2f %7.2f %6s %6s %6s %4s %n", elapsedTime.getElapsedTime(), eventName(),customerID() ,idleChairs(), tIdle(), timeWaiting.getElapsedTime(), numWaiting(), numCut(),numLost(), numDissatisfied);
		}
		else if(event.getClass().equals(Enter.class)) {
			System.out.format("%6.2f %2s %5s %6s %6.2f %7.2f %6s %6s %6s %4s %n", elapsedTime.getElapsedTime(), eventName(),customerID() ,idleChairs(), tIdle(), timeWaiting.getElapsedTime(), numWaiting(), numCut(),numLost(), numDissatisfied);
		}
	}
}

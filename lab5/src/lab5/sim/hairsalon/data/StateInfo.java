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
	public final CustomerList dissatisfiedList;
	public final QueueList queueList;
	public final Time timeWaiting;
	public final Time elapsedTime;
	public final Event event;
	public final int numHaircut;
	//public final Customer customer;
	
	public StateInfo(HairsalonSettings settings, CustomerList customerList, CustomerList haircutList, QueueList queueList, 
			Time timeIdle, Time elapsedTime, Event event, int numHaircut, CustomerList dissatisfiedList){
		this.settings = settings;
		this.customerList = customerList;
		this.haircutList = haircutList;
		this.queueList = queueList;
		this.timeWaiting = timeIdle;
		this.elapsedTime = elapsedTime;
		this.event = event;
		this.numHaircut = numHaircut;
		this.dissatisfiedList = dissatisfiedList;
//		this.state = state;
		//this.customer = customer;
	}
	
	private int numWaiting() {
		return queueList.getQueueSize();
	}
	
	private int numLost(){
		return (customerList.numCustomers() - haircutList.numCustomers());
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
		return 2; 
	}
	
	private int numReturning(){
		return dissatisfiedList.numCustomers();
	}
	
	private int customerID(){
		if(eventName() == "Enter") {
			return ((Enter) event).getCustomer().getID();
		} else if (eventName() == "HaircutReady") {
			return ((HaircutReady) event).getCustomer().getID();
		} else {
			return ((Dissatisfied) event).getCustomer().getID();
		}
	}

	public void printAll() {
		System.out.print("hugo ");
		if(eventName() == "Start"){
			System.out.format("%s %2s %10s %5s %5s %5s %5s %5s %5s %5s %5s", "- Time" , "Event", "Id", "Idle", "TIdle", "TWait", "InQ", "Cut", "Lost", "Ret -");
			System.out.format("%.2f %2s", elapsedTime, eventName());
		}else if(eventName() == "Stop"){
			System.out.format("%.2f %2s ", elapsedTime, eventName(), idleChairs(), tIdle(), timeWaiting, numWaiting(), numCut(),numLost(), numReturning());
		}else{
			System.out.format("%.2f %2s ", elapsedTime, eventName(),customerID() ,idleChairs(), tIdle(), timeWaiting, numWaiting(), numCut(),numLost(), numReturning());
		}
	}
}

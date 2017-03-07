package lab5.sim.hairsalon.data;

import lab5.sim.general.GUI.PrintAble;
import lab5.sim.general.data.Event;
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
	public final QueueList queueList;
	public final Time timeWaiting;
	public final Time elapsedTime;
	public final Event event;
	public final HairsalonState state;
	
	public StateInfo(HairsalonSettings settings, CustomerList customerList, CustomerList haircutList, QueueList queueList, Time timeIdle, Time elapsedTime, Event event, HairsalonState state){
		this.settings = settings;
		this.customerList = customerList;
		this.haircutList = haircutList;
		this.queueList = queueList;
		this.timeWaiting = timeIdle;
		this.elapsedTime = elapsedTime;
		this.event = event;
		this.state = state;
	}
	
	private int numWaiting() {
		return queueList.getQueueSize();
	}
	
	private int numLost(){
		return (state.getCustomerList()-state.getNumCutCustomers());
	}
	
	private int idleChairs(){
		return (settings.getMAX_CHAIRS() - state.getNumHaircut());
	}
	
	private int numCut(){
		return state.getNumCutCustomers();
	}
	
	private String eventName(){
		return event.toString();
	}
	
	private double tIdle(){
		return 2; 
	}
	
	private int numReturning(){
		return state.getNumReturning();
	}

	public void printAll() {
		if(eventName() == "Start"){
			System.out.format("%s %2s %10s %5s %5s %5s %5s %5s %5s %5s %5s", "- Time" , "Event", "Id", "Idle", "TIdle", "TWait", "InQ", "Cut", "Lost", "Ret -");
			System.out.format("%.2f %2s", elapsedTime, eventName());
		}else if(eventName() == "Stop"){
			System.out.format("%.2f %2s ", elapsedTime, eventName(), idleChairs(), tIdle(), timeWaiting, numWaiting(), numCut(),numLost(), numReturning());
		}else{
			System.out.format("%.2f %2s ", elapsedTime, eventName(), ,idleChairs(), tIdle(), timeWaiting, numWaiting(), numCut(),numLost(), numReturning());
		}
		event.toString();
		customerList.printAll();
		haircutList.printAll();
		queueList.printAll();
		System.out.println("Elapsed Time :" + elapsedTime.getElapsedTime());
		System.out.println("Total time customers waited :" + timeWaiting.getElapsedTime());
	}
}

package lab5.sim.hairsalon.data;

import lab5.sim.general.GUI.PrintAble;
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
	public final Time timeIdle;
	public final Time elapsedTime;
	
	public StateInfo(HairsalonSettings settings, CustomerList customerList, CustomerList haircutList, QueueList queueList, Time timeIdle, Time elapsedTime){
		this.settings = settings;
		this.customerList = customerList;
		this.haircutList = haircutList;
		this.queueList = queueList;
		this.timeIdle = timeIdle;
		this.elapsedTime = elapsedTime;
	}

	public void printAll() {
		customerList.printAll();
		haircutList.printAll();
		queueList.printAll();
		System.out.println("Elapsed Time :" + elapsedTime.getElapsedTime());
		System.out.println("Total time customers waited :" + timeIdle.getElapsedTime());
	}
}

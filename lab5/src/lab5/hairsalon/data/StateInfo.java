package lab5.hairsalon.data;

import lab5.data.Time;
import lab5.data.PrintAble;

/**
 * All state info.
 * Vet inte om den behövs.
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
		settings.printAll();
		customerList.printAll();
		haircutList.printAll();
		queueList.printAll();
	}
}

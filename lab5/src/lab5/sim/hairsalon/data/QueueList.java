package lab5.sim.hairsalon.data;

import lab5.sim.general.GUI.PrintAble;
import lab5.sim.general.data.Event;
/**
 * Create a queue to store elements in an orderly way
 * @author hugwan-6, leopel-6, inaule-6
 *
 */
public class QueueList implements PrintAble{
	private Event[] queue;
	private Dissatisfied[] vipQueue;
	
	private int lastInQueue;
	private int lastInVIPQueue;
	
	public QueueList(int maxQueue) {
		queue = new Event[maxQueue];
		vipQueue = new Dissatisfied[maxQueue];
		lastInQueue = 0;
		lastInVIPQueue = 0;
	}
	
	/**
	 * Adds and event a queue, returns true if the event was added and false otherwise
	 * @param e
	 * @return
	 */
	public boolean addToQueue(Enter e) {
		if (lastInQueue + lastInVIPQueue < queue.length) {
			queue[lastInQueue] = e;
			lastInQueue += 1;
			return true;
		}
		return false;
	}
	
	/**
	 * Represents a queue consisting of disappointed customers
	 * @param e
	 * @return
	 */
	public boolean addToVIPQueue(Dissatisfied e) {
		if (lastInVIPQueue < vipQueue.length) {
			vipQueue[lastInQueue] = e;
			lastInVIPQueue += 1;
			if (lastInQueue + lastInVIPQueue >= queue.length) {
				lastInQueue -= 1;
			}
			return true;
		}
		return false;
	}
	
	
	/**
	 * Returns the next event according to a specific time order
	 * @return
	 */
	public Event next() {
		if (lastInVIPQueue != 0) {
			lastInVIPQueue -= 1;
			Event temp =vipQueue[0];
			for (int i = 0; i < lastInVIPQueue; i++) {
				vipQueue[i] = vipQueue[i + 1];
			}
			return temp;
		}
		Event temp = queue[0];
		lastInQueue -= 1;
		for (int i = 0; i < lastInQueue; i++) {
			queue[i] = queue[i + 1];
		}
		return temp;
	}
	
	/**
	 * Checks if both the VIP queue and the normal queue are empty
	 * @return
	 */
	public boolean isEmpty() {
		return (lastInQueue == 0 && lastInVIPQueue == 0);
	}

	public void printAll() {
		System.out.println("Left in queue");
		for (int i = 1; i <= lastInVIPQueue; i++) {
			System.out.print(" : "+ i + ". " + vipQueue[i-1].getCustomer().getID());
		}
		for (int i = 1; i <= lastInQueue; i++) {
			System.out.print(" : "+ lastInVIPQueue + i + ". " + vipQueue[i-1].getCustomer().getID());
		}
	}
}

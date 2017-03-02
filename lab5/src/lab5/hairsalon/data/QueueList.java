package lab5.hairsalon.data;

import lab5.harisalon.events.Dissatisfied;
import lab5.harisalon.events.Enter;
import lab5.simulation.Event;

public class QueueList {
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
	
	public boolean addToQueue(Enter e) {
		if (lastInQueue + lastInVIPQueue < queue.length) {
			queue[lastInQueue] = e;
			lastInQueue += 1;
			return true;
		}
		return false;
	}
	
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
	
	public boolean isEmpty() {
		return (lastInQueue == 0 && lastInVIPQueue == 0);
	}
}

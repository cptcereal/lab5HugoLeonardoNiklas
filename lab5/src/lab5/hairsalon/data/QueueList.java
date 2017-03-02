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
		if (lastInQueue != queue.length) {
			queue[lastInQueue] = e;
			lastInQueue += 1;
			return true;
		}
		return false;
	}
	
	public boolean addToVIPQueue(Dissatisfied e) {
		if (lastInVIPQueue != vipQueue.length) {
			vipQueue[lastInQueue] = e;
			lastInVIPQueue += 1;
			
			return true;
		}
		return false;
	}
	
	private void addVIPToQueue() {
		for (int i = 0; i < lastInQueue; i++) {
			queue[0:-1] = queue
			queue[i] = vipQueue[i];
		}
	}
	
	public Event next() {
		return queue[0];
	}

}

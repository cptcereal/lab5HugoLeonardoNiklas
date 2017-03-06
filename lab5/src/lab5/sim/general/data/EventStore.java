package lab5.sim.general.data;

import java.util.ArrayList;



/**
 * This class Stores events and
 * 
 * @author hugwan-6, leopel-6, inaule-6 
 * 
 */
public class EventStore {
	private Node start, pre;
	
	/**
	 * Inserts the start events.
	 * 
	 * @param startEvents the start events to insert
	 */
	public EventStore(Event[] startEvents) {
		start = new Node();
		pre = start;
		for (int i = 0; i < startEvents.length; i++) {
			if (start.next != null) {
				while (pre.next != null) {
					if (pre.next.event.getTime() > startEvents[i].getTime()) {
						Node newNode = new Node();
						newNode.event = startEvents[i];
						newNode.next = pre.next;
						pre.next = newNode;
						pre = pre.next;
					}
				}
			} else {
				Node newNode = new Node();
				newNode.event = startEvents[i];
				newNode.next = start.next;
				start.next = newNode;
			}
		}
	}
	
	private class Node {
		private Node next = null;
		private Event event;
	}

	/**
	 * Adds an event to EventStore in the last position.
	 * @param e 
	 */
	public void add(Event e){
		while (pre.next != null) {
			if (pre.next.event.getTime() > e.getTime()) {
				Node newNode = new Node();
				newNode.event = e;
				newNode.next = pre.next;
				pre.next = newNode;
				pre = start;
			} else {
				pre = pre.next;
			}
		}
	}
	
	/**
	 * Returns the first event and removes it from the EventStore
	 * @return
	 * @throws 
	 */
	public Event nextEvent() throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Event store is empty");
		}
		Event temp = start.next.event;	// Store the first event in queue
		
		// Rearrange the event store
		start.next = start.next.next;
		
		return temp;

	}
	/**
	 * Returns true if EventStore is empty, false otherwise.
	 * 
	 * @return true if event store is empty
	 */
	public boolean isEmpty(){
		return start.next == null;
	}
}



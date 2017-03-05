package lab5.sim.general.data;

import java.util.ArrayList;



/**
 * This class Stores events and
 * 
 * @author hugwan-6, leopel-6, inaule-6 
 * 
 */
public class EventStore {
	private ArrayList<Event> eventStore = new ArrayList<Event>();
	private Node start, pre;
	
	public EventStore(Event[] startEvents) {
		start = new Node();
		pre = start;
		for (int i = 0; i < startEvents.length; i++) {
			if (start.next != null) {
				if (start.next.time > startEvents[i].getTime()) {
					Node tempNode = start.next;
					start.next = new Node();
					start.next.event = startEvents[i];
					start.next.time = startEvents[i].getTime();
					start.next.next = tempNode;
				} else {
					
				}
			} else {
				start.next = new Node();
				start.next.event = startEvents[i];
				start.next.time = startEvents[i].getTime();
			}
		}
	}
	
	private class Node {
		private double time;
		private Node next = null;
		private Event event;
	}

	/**
	 * Adds an event to EventStore in the last position.
	 * @param e 
	 */
	public void add(Event e){
		eventStore.add(e);
	}
	
	/**
	 * Returns the first event and removes it from the EventStore
	 * @return
	 * @throws 
	 */
	public Event nextEvent() throws IndexOutOfBoundsException {
		if (eventStore.isEmpty()){
			throw new IndexOutOfBoundsException("EventStore is empty");
		}
		Event temp = eventStore.get(0);
		eventStore.remove(0);
		return temp;
	}
	/**
	 * Returns true if EventStore is empty, false otherwise.
	 * @return
	 */
	public boolean isEmpty(){
		return eventStore.isEmpty();
	}
}



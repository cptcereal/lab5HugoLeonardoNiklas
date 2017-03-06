package lab5.sim.general.data;



/**
 * This class Stores events.
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
		pre = start;	// The pre-pointer.
		
		for (int i = 0; i < startEvents.length; i++) {
			add(startEvents[i]);
		}
	}
	
	private class Node {
		private Node next = null;
		private Event event;
	}

	/**
	 * Adds an event to the event store depending on the time of the event.
	 * 
	 * @param e the event to add
	 */
	public void add(Event e){
		while (pre.next != null) {
			if (pre.next.event.getTime() > e.getTime()) {
				Node newNode = new Node();
				newNode.event = e;
				newNode.next = pre.next;
				pre.next = newNode;
				return;
			} else {
				pre = pre.next;	// Continue forward.
			}
		}
		
		// Add the event last in event store if we made it to the end without adding it.
		Node newNode = new Node();
		newNode.event = e;
		newNode.next = pre.next;
		pre.next = newNode;
	}
	
	/**
	 * Returns the first event and removes it from the EventStore
	 * 
	 * @return first event in the event store
	 * @throws IndexOutOfBoundsException if the event store is empty
	 */
	public Event nextEvent() throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Event store is empty");
		}
		Event temp = start.next.event;	// Store the first event in queue
		
		// Remove the first event
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



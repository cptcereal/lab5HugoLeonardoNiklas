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
	 * The constructor
	 * 
	 */
	public EventStore() {
		start = new Node(null);
		pre = start;	// The pre-pointer starts pointing at start.
	}
	
	private class Node {
		private Node next;
		private final Event event;
		
		public Node(Event e) {
			this.event = e;
			next = null;
		}
	}

	/**
	 * Adds an event to the event store
	 * 
	 * @param e the event to add
	 */
	public void add(Event e){
		pre = start;
		while (pre.next != null) {
			// If the event that is being added occurs before an event already in the store,
			// add it before the later event.
			if (pre.next.event.getTime() > e.getTime()) {
				Node newNode = new Node(e);
				newNode.next = pre.next;
				pre.next = newNode;
				return;
			} else {
				pre = pre.next;	// Continue forward.
			}
		}
		
		// Add the event last in event store if we made it to the end without adding it.
		Node newNode = new Node(e);
		newNode.next = pre.next;
		pre.next = newNode;
	}
	
	/**
	 * Returns the first event and removes it from the EventStore
	 * 
	 * @return the first event in the event store
	 * @throws IndexOutOfBoundsException if the event store is empty
	 */
	public Event nextEvent() throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Event store is empty");
		}
		Event temp = start.next.event;
		
		// Remove the first event
		start.next = start.next.next;

		return temp;
	}
	
	/**
	 * Returns true if EventStore is empty, false otherwise
	 * 
	 * @return true if event store is empty
	 */
	public boolean isEmpty(){
		return start.next == null;
	}
	
	/**
	 * Prints the event
	 * 
	 * @param e - the event to print
	 */
	public void print(Event e) { 		// Not needed right?
		System.out.println(e.toString());
	}
}



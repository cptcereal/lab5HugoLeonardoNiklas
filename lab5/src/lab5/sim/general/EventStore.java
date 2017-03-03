package lab5.sim.general;

import java.util.ArrayList;


/**
 * This class Stores events and
 * 
 * @author hugwan-6, leopel-6, inaule-6 
 * 
 */
public class EventStore {
	private ArrayList<Event> eventStore = new ArrayList<Event>();
	// Fixa nod system, bygg p� Time klassen som h�ller tid HUGO fixar
	public EventStore(Event[] startEvents) {
		for (int i = 0; i < startEvents.length; i++) {
			eventStore.add(startEvents[i]);
		}
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



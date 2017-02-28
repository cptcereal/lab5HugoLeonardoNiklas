package lab5.data;

import java.util.ArrayList;
import lab5.simulation.Event;

/**
 * This class Stores events and
 * 
 * @author inaule-6
 * 
 */

public class EventStore {
	private ArrayList<Event> eventStore = new ArrayList<Event>();
	
	public EventStore(Event[] startEvents) {
		for (int i = 0; i < startEvents.length; i++) {
			eventStore.add(startEvents[i]);
		}
	}

	public void add(Event e){
		eventStore.add(e);
	}
	
	public Event nextEvent(){
		if (eventStore.isEmpty()){
			throw new IndexOutOfBoundsException("EventStore is empty");
		}
		Event temp = eventStore.get(0);
		eventStore.remove(0);
		return temp;
	}
}

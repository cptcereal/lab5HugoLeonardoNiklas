package lab5.simulation;

import lab5.data.EventStore;

public class Simulation {
	
	private View view;
	private State state;
	private EventStore eventStore;
	
	public Simulation(Event[] events) {
		eventStore = new EventStore(events);
		run();
	}
	
	public void run() {
		while(!eventStore.isEmpty) {
			eventStore.nextEvent();
		}
	}
}
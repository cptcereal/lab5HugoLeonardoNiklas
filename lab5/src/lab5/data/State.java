package lab5.data;

import java.util.Observable;

import lab5.simulation.Event;

/**
 * Has the state of the simulator, info about time and running.
 * @author inaule-6
 *
 */
public abstract class State extends Observable {
	
	private Time time;
	private boolean stop;
	
	/**
	 * Makes state object.
	 */
	public State(){
		time = new Time();
		stop = false;
	}
	
	public void startEvent(Event e) {
		e.effect(this);
	}
	
	
	/**
	 * Sets stop to true. 
	 * Stop makes it impossible to make new events.
	 */
	public void stop() {
		stop = true;
	}
	
	public boolean getStop() {
		return stop;
	}
	
	/**
	 * Returns the elapsedTime of simulator
	 * @return
	 */
	public int getElapsedTime(){
		return time.getElapsedTime();
	}
	
	/**
	 * Adds time to elapsedTime.
	 * @param t
	 */
	public void addTime(int t) {
		time.addTime(t);
	} 
}

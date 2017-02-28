package lab5.data;

import java.util.Observable;

/**
 * Has the state of the simulator, info about time and running.
 * @author inaule-6
 *
 */
public class State extends Observable {
	
	private Time time;
	private boolean stop;
	
	/**
	 * Makes state object.
	 */
	public State(){
		time = new Time();
		stop = false;
	}
	
	/**
	 * Sets stop to true. 
	 * Stop makes it impossible to make new events.
	 */
	public void stop() {
		stop = true;
	}
	
	/**
	 * Returns the elapsedTime of simulator
	 * @return
	 */
	public int getElapsedTime(){
		return time.getElapsedTime();
	}
}

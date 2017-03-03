package lab5.sim.general.data;

import java.util.Observable;



/**
 * Has the state of the simulator, info about time and running.
 * @author hugwan-6, leopel-6, inaule-6 
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
	public Time getElapsedTime(){
		return time;
	}
	
	public double getElapsedTimeDouble() {
		return time.getElapsedTime();
	}
	
	/**
	 * Adds the diffrens in time between t and elapsedtime.
	 * t must be bigger then elapsedtime.
	 * @param t
	 */
	public void addTime(double t) {
		if (t > time.getElapsedTime()) {
			time.addTime(t- time.getElapsedTime());
		}
	} 
}

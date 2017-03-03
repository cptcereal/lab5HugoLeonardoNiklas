package lab5.sim.general.data;


/**
 * Creates events based with a specified time and simulator
 * @author hugwan-6, leopel-6, inaule-6 
 * 
 */
public abstract class Event {
	private final Time TIME;
	private Simulation sim;
	
	/**
	 * Creates an Event object with specified simulation and time values
	 * @param sim
	 * @param tempTime
	 */
	public Event(Simulation sim, Time tempTime){
		sim = this.sim;
		this.TIME = tempTime;
	} 
	
	/**
	 * Makes a call to a specific Event depending on the specified state
	 * @param state
	 */
	public void effect(State state){
		//Needs to make a call to the appropriate effect depending on the state sent in 
	} 
	
	/**
	 * Returns the value of a time for an object
	 * @return
	 */
	public double getTime(){
		return TIME.getElapsedTime();
	}
	
	/**
	 * Returns the value the simulation value for an object
	 * @return
	 */
	public Simulation getSim(){
		return sim;
	}
	
	public String toString() {
		String s = this.getClass().getName();
		return s;
	}
}

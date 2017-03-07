package lab5.sim.general.data;


/**
 * Creates events based with a specified time and simulator
 * 
 * @author hugwan-6, leopel-6, inaule-6 
 * 
 */
public abstract class Event {
	private final Time TIME;
	private Simulation sim;
	
	/**
	 * Creates an Event object with specified simulation and time values
	 * 
	 * @param sim - The simulation the event belongs to
	 * @param time - The time when the event occurs
	 */
	public Event(Simulation sim, Time time){
		this.sim = sim;
		this.TIME = time;
	} 
	
	/**
	 * The effect the event has on the state of the simulation when it occurs
	 * 
	 */
	public abstract void effect(); 
	
	/**
	 * Returns the time when the event occurs
	 * 
	 * @return the time when the event occurs
	 */
	public double getTime(){
		return TIME.getElapsedTime();
	}
	
	/**
	 * Returns the simulation the event belongs to
	 * 
	 * @return the simulation
	 */
	public Simulation getSim(){
		return sim;
	}
	
	/**
	 * Returns the name of the event as an string
	 * 
	 * @return the name of the event
	 */
	public String toString() {
		String s = this.getClass().getSimpleName();
		return s;
	}
}

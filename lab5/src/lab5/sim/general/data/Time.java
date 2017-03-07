package lab5.sim.general.data;

/**
 * The class that handles the time of the simulator
 * 
 * @author hugwan-6, leopel-6, inaule-6 
 */
public class Time {
	private double elapsedTime;
	
	/**
	 * The constructor of the time object
	 * 
	 */
	public Time() {
		elapsedTime = 0;
	}
	
	/**
	 * Assigns the elapsed time a new value
	 * 
	 * @param elapsedTime the new elapsed time
	 */
	public Time(double elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	
	/**
	 * Adds time to elapsed time
	 * 
	 * @param t - the time to add
	 */
	public void addTime(double t) {
		elapsedTime += t;
	}
	
	/**
	 * Returns the elapsed time
	 * 
	 * @return elapsed time
	 */
	public double getElapsedTime() {
		return elapsedTime;
	}

}

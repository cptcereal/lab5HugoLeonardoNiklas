package lab5.data;

/**
 * Saves elapsed time
 * @author inaule-6
 *
 */
public class Time {
	private double elapsedTime;
	
	/**
	 * Makes time object
	 */
	public Time() {
	elapsedTime = 0;
	}
	
	/**
	 * Adds time to elapsed time.
	 * @param t
	 */
	public void addTime(double t) {
		elapsedTime += t;
	}
	
	/**
	 * Returns the elapsed time.
	 * @return
	 */
	public double getElapsedTime() {
		return elapsedTime;
	}
}

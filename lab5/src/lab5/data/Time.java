package lab5.data;

/**
 * Saves elapsed time and the time of last event.
 * @author inaule-6
 *
 */
public class Time {
	private int elapsedTime;
	private int lastEventTime;
	
	/**
	 * Makes time object
	 */
	public Time() {
	elapsedTime = 0;
	lastEventTime = elapsedTime;
	}
	
	/**
	 * Adds time to elapsed time.
	 * @param t
	 */
	public void addTime(int t) {
		elapsedTime += t;
	}
	
	/**
	 * Returns the elapsed time.
	 * @return
	 */
	public int getElapsedTime() {
		return elapsedTime;
	}
	
	/**
	 * Sets lastEventTime to elapsedTime.
	 */
	public void resetLastEventTime() {
		lastEventTime = elapsedTime;
	}
	
	/**
	 * Returns lastEventTime.
	 * @return
	 */
	public int getLastEventTime() {
		return lastEventTime;
	}
}

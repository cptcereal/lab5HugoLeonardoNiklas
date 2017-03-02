package lab5.data;

/**
 * Saves elapsed time
 * @author hugwan-6, leopel-6, inaule-6 
 *
 */
public class Time {
	private double elapsedTime;
	
	/**
	 * Makes a time object
	 */
	public Time() {
	elapsedTime = 0;
	}
	
	public Time(double elapsedTime) {
		this.elapsedTime = elapsedTime;
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

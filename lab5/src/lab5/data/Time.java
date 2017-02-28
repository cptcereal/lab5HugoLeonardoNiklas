package lab5.data;

/**
 * Inte färdig
 * @author inaule-6
 *
 */
public class Time {
	private int elapsedTime;
	private int lastEventTime;
	
	public Time() {
	elapsedTime = 0;
	lastEventTime = elapsedTime;
	}
	
	public void addTime(int t) {
		elapsedTime += t;
	}
	
	public int getElapsedTime() {
		return elapsedTime;
	}
	
	public void resetLastEventTime() {
		lastEventTime = elapsedTime;
	}
	
	public int getTempTime() {
		return lastEventTime;
	}
}

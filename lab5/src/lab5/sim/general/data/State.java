package lab5.sim.general.data;

/**
 * The state of the simulation
 * 
 * @author hugwan-6, leopel-6, inaule-6 
 */
public abstract class State {
	
	private Time time;
	private boolean stop;
	
	/**
	 * The constructor
	 * 
	 */
	public State(){
		time = new Time();
		stop = false;
	}
	
	/**
	 * Stop the simulation
	 * 
	 */
	public void stop() {
		stop = true;
	}
	
	/**
	 * Returns whether or not the simulation is stopped or not
	 * 
	 * @return true if the simulation is stopped
	 */
	public boolean getStop() {
		return stop;
	}
	
	/**
	 * Returns the simulations time object
	 * 
	 * @return the time object
	 */
	public Time getElapsedTime() {
		return time;
	}
	
	/**
	 * Returns the elapsed time of the simulation
	 * 
	 * @return elapsed time
	 */
	public double getElapsedTimeDouble() {
		return time.getElapsedTime();
	}
	
	/**
	 * Increases the elapsed time of the simulator
	 * 
	 * @param t - the time to add
	 * @return true if the elapsed time was updated
	 * @precondition the time to add must be greater than the old elapsed time of the simulator
	 * @postcondition the elapsed time of the simulator is updated
	 */
	public boolean addTime(double t) {
		if (t > time.getElapsedTime()) {
			time.addTime(t- time.getElapsedTime());
			return true;
		}
		return false;
	} 
}

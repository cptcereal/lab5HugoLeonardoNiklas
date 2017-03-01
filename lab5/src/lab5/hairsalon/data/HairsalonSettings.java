package lab5.hairsalon.data;

/**
 * The settings of the hair salon simulation.
 * 
 * @author hugwan-6, leopel-6, inoule-6
 *
 */
public class HairsalonSettings {
	private final double H_MIN;
	private final double H_MAX;
	private final double D_MIN;
	private final double D_MAX;
	private final double P;
	private final int CLOSING_TIME;
	private final double CUSTOMERS_PER_HOUR;
	private final int MAX_QUEUE;
	private final int MAX_CHAIRS;
	
	public HairsalonSettings(){
		H_MIN = 20;
		H_MAX = 50;
		D_MIN = 10;
		D_MAX = 200;
		P = 0.2;
		CLOSING_TIME = 3000;
		CUSTOMERS_PER_HOUR = 5;
		MAX_QUEUE = 5;
		MAX_CHAIRS = 3;
	}
	
	public HairsalonSettings(double H_MIN, double H_MAX, double D_MIN, double D_MAX, double P, int CLOSING_TIME, double CUSTOMERS_PER_HOUR, int MAX_QUEUE, int MAX_CHAIRS){
		this.H_MIN = H_MIN ;
		this.H_MAX = H_MAX;
		this.D_MIN = D_MIN;
		this.D_MAX = D_MAX;
		this.P = P;
		this.CLOSING_TIME = CLOSING_TIME;
		this.CUSTOMERS_PER_HOUR = CUSTOMERS_PER_HOUR;
		this.MAX_QUEUE = MAX_QUEUE;
		this.MAX_CHAIRS = MAX_CHAIRS;
	}
	
	/**
	 * Returns the minimum time a haircut can take.
	 * 
	 * @return the minimum time a haircut can take
	 */
	public double getHmin() {
		return H_MIN;
	}
	
	/**
	 * Returns the maximum time a haircut can take.
	 * 
	 * @return the maximum time a haircut can take
	 */
	public double getHmax() {
		return H_MAX;
	}
	
	/**
	 * Returns the minimum time it takes before a dissatisfied customer returns to the salon.
	 * 
	 * @return the minimum time before a dissatisfied customer returns
	 */
	public double getDmin() {
		return D_MIN;
	}
	
	/**
	 * Returns the maximum time it takes before a dissatisfied customer returns to the salon.
	 * 
	 * @return the maximum time before a dissatisfied customer returns
	 */
	public double getDmax() {
		return D_MAX;
	}
	
	/**
	 * Returns the percent of customers that return because they are dissatisfied.
	 * 
	 * @return precent that a customer returns because they are dissatisfied
	 */
	public double getP() {
		return P;
	}
	
	/**
	 * Returns the closing time of the hair salon
	 * 
	 * @return the closing time
	 */
	public int getClosingTime() {
		return CLOSING_TIME;
	}
	
	/**
	 * Returns the number of customers per hour.
	 * 
	 * @return customers per hour
	 */
	public double getCustomersPerHour() {
		return CUSTOMERS_PER_HOUR;
	}
	
	/**
	 * Returns the maximum allowed size of the queue.
	 * 
	 * @return maximum allowed size of the queue.
	 */
	public int getMaxQueue() {
		return MAX_QUEUE;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getMAX_CHAIRS() {
		return MAX_CHAIRS;
	}
}

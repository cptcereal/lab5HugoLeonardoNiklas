package lab5.sim.hairsalon.data;



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
	private final double CLOSING_TIME;
	private final double CUSTOMERS_PER_TIMEUNIT;
	private final int MAX_QUEUE;
	private final int MAX_CHAIRS;
	private final long SEED;
	
	/**
	 * The constructor that assigns all the hair salons settings values
	 * 
	 */
	public HairsalonSettings() {
		H_MIN = 1.0;
		H_MAX = 2.0;
		D_MIN = 1.0;
		D_MAX = 2.0;
		P = 0.5;
		CLOSING_TIME = 7.0;
		CUSTOMERS_PER_TIMEUNIT = 1.2;
		MAX_QUEUE = 2;
		MAX_CHAIRS = 2;
		SEED = 1116;
	}
	
	/**
	 * The constructor that assigns all the hair salons settings values
	 * 
	 * @param args the values to use
	 */
	public HairsalonSettings(String[] args) {
		H_MIN = Double.parseDouble(args[0]);
		H_MAX = Double.parseDouble(args[1]);
		D_MIN = Double.parseDouble(args[2]);
		D_MAX = Double.parseDouble(args[3]);
		P = Double.parseDouble(args[4]);
		CLOSING_TIME = Double.parseDouble(args[5]);
		CUSTOMERS_PER_TIMEUNIT = Double.parseDouble(args[6]);
		MAX_QUEUE = Integer.parseInt(args[7]);
		MAX_CHAIRS = Integer.parseInt(args[8]);
		SEED = Long.parseLong(args[9]);
	}
	
	/**
	 * Returns the minimum time a haircut can take.
	 * 
	 * @return minimum time
	 */
	public double getHmin() {
		return H_MIN;
	}
	
	/**
	 * Returns the maximum time a haircut can take.
	 * 
	 * @return maximum time
	 */
	public double getHmax() {
		return H_MAX;
	}
	
	/**
	 * Returns the minimum time it takes before a dissatisfied customer returns to the salon.
	 * 
	 * @return minimum time
	 */
	public double getDmin() {
		return D_MIN;
	}
	
	/**
	 * Returns the maximum time it takes before a dissatisfied customer returns to the salon.
	 * 
	 * @return maximum time
	 */
	public double getDmax() {
		return D_MAX;
	}
	
	/**
	 * Returns the risk that a dissatisfied customer returns
	 * 
	 * @return the risk of a customer getting dissatisfied
	 */
	public double getP() {
		return P;
	}
	
	/**
	 * Returns the closing time of the hair salon
	 * 
	 * @return the closing time
	 */
	public double getClosingTime() {
		return CLOSING_TIME;
	}
	
	/**
	 * Returns the number of customers per hour.
	 * 
	 * @return customers per hour
	 */
	public double getCustomersPerTimeUnit() {
		return CUSTOMERS_PER_TIMEUNIT;
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
	 * Returns the number of chairs in the hair salon where customers can sit down and get a haircut.
	 * 
	 * @return the number of haircut chairsS
	 */
	public int getMaxChairs() {
		return MAX_CHAIRS;
	}
	
	/**
	 * Returns the seed used in the simulations pseudo random generators
	 * 
	 * @return the seed
	 */
	public long getSeed() {
		return SEED;
	}
}

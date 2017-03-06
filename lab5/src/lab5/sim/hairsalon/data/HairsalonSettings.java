package lab5.sim.hairsalon.data;

import lab5.sim.general.GUI.PrintAble;

/**
 * The settings of the hair salon simulation.
 * 
 * @author hugwan-6, leopel-6, inoule-6
 *
 */
public class HairsalonSettings implements PrintAble{
	private final double H_MIN = 20;
	private final double H_MAX = 50;
	private final double D_MIN = 10;
	private final double D_MAX = 200;
	private final double P = 0.2;
	private final double CLOSING_TIME = 3000;
	private final double CUSTOMERS_PER_TIMEUNIT = 5;
	private final int MAX_QUEUE = 5;
	private final int MAX_CHAIRS = 3;
	private final long SEED = System.currentTimeMillis();
	
	public void printAll() {
		System.out.println("Closing time of the day ..............: " + CLOSING_TIME);
		System.out.println("Total number of chairs ...............: " + MAX_CHAIRS);
		System.out.println("Maximum queue size ...................: " + MAX_QUEUE);
		System.out.println("Lambda (customers/timeunit entering)..: " + CUSTOMERS_PER_TIMEUNIT);
		System.out.println("hmin and hmax (cutting time interval) : [" + H_MIN + ", " + H_MAX + "]");
		System.out.println("dmin and dmax (return time interval) .: [" + D_MIN + ", "+ D_MAX + "]");
		System.out.println("Risk dissatisfied returns: ...........: " + P);
		System.out.println("Seed used in pseudo random generator .: " + SEED);
		System.out.println("----------------------------------------------------------------");
		System.out.println("- Time  Event      Id  Idle  TIdle  TWait  InQ  Cut  Lost  Ret -");
		System.out.println( "  StartHSS");
		
		
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
	public int getMAX_CHAIRS() {
		return MAX_CHAIRS;
	}
	
	/**
	 * Returns the seed used in the simulations random functions
	 * 
	 * @return the seed
	 */
	public long getSEED() {
		return SEED;
	}
}

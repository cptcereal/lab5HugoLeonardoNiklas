package lab5.sim.hairsalon.data;

import lab5.sim.general.GUI.PrintAble;

/**
 * The settings of the hair salon simulation.
 * 
 * @author hugwan-6, leopel-6, inoule-6
 *
 */
public class HairsalonSettings implements PrintAble{
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
		H_MIN = 0.8;
		H_MAX = 1.2;
		D_MIN = 1.0;
		D_MAX = 2.0;
		P = 0.1;
		CLOSING_TIME = 8.0;
		CUSTOMERS_PER_TIMEUNIT = 2.0;
		MAX_QUEUE = 5;
		MAX_CHAIRS = 2;
		SEED = 1234;
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
	 * Prints the settings of the hair salon
	 * 
	 */
	public void printAll() {
		String formatSF = "%s %.2f %n";
		String formatSS = "%s %s %n";
		String formatMinMax = "%s %.2f %s %.2f %s %n";
		
//		System.out.println("Closing time of the day ..............: " + CLOSING_TIME);
//		System.out.println("Total number of chairs ...............: " + MAX_CHAIRS);
//		System.out.println("Maximum queue size ...................: " + MAX_QUEUE);
//		System.out.println("Lambda (customers/timeunit entering)..: " + CUSTOMERS_PER_TIMEUNIT);
//		System.out.println("hmin and hmax (cutting time interval) : [" + H_MIN + ", " + H_MAX + "]");
//		System.out.println("dmin and dmax (return time interval) .: [" + D_MIN + ", "+ D_MAX + "]");
//		System.out.println("Risk dissatisfied returns: ...........: " + P);
//		System.out.println("Seed used in pseudo random generator .: " + SEED);
//		System.out.println("----------------------------------------------------------------");
		
		System.out.format(formatSF, "Closing time of the day ..............:", CLOSING_TIME);
		System.out.format(formatSS, "Total number of chairs ...............:", MAX_CHAIRS);
		System.out.format(formatSS, "Maximum queue size ...................:", MAX_QUEUE);
		System.out.format(formatSF, "Lambda (customers/timeunit entering)..:", CUSTOMERS_PER_TIMEUNIT);
		System.out.format(formatMinMax, "hmin and hmax (cutting time interval) : [", H_MIN, ", ", H_MAX, "]");
		System.out.format(formatMinMax, "dmin and dmax (return time interval) .: [", D_MIN, ", ", D_MAX, "]");
		System.out.format(formatSF, "Risk dissatisfied returns: ...........:", P);
		System.out.format(formatSS, "Seed used in pseudo random generator .:", SEED);
		System.out.format("%s %n", "----------------------------------------------------------------");
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

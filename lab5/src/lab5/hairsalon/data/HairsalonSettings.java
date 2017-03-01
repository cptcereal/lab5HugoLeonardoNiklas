package lab5.hairsalon.data;

/**
 * The settings of the hair salon simulation.
 * 
 * @author hugwan-6, leopel-6, inoule-6
 *
 */
public class HairsalonSettings {
	private final double H_MIN = 20;
	private final double H_MAX = 50;
	private final double D_MIN = 10;
	private final double D_MAX = 200;
	private final double P = 0.2;
	private final int CLOSING_TIME = 3000;
	private final double CUSTOMERS_PER_HOUR = 5;
	
	public double getHmin() {
		return H_MIN;
	}
	
	public double getHmax() {
		return H_MAX;
	}
	
	public double getDmin() {
		return D_MIN;
	}
	
	public double getDmax() {
		return D_MAX;
	}
	
	public double getP() {
		return P;
	}
	
	public int getClosingTime() {
		return CLOSING_TIME;
	}
	
	public double getCustomersPerHour() {
		return CUSTOMERS_PER_HOUR;
	}
}

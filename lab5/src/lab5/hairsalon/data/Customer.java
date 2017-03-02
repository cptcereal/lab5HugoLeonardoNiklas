package lab5.hairsalon.data;

import lab5.data.Time;

/**
 * A customer who has a id and time they entered the store
 * @author hugwan-6, leopel-6, inaule-6 
 *
 */
public class Customer {
	private final int id;
	private double timeEnterdStore;
	
	/**
	 * Adds id to the customer.
	 * @param id
	 */
	public Customer(int id, double timeEnterdStore) {
		this.id = id;
		this.timeEnterdStore = timeEnterdStore;
	}
	
	/**
	 * returns the id of the customer.
	 * @return
	 */
	public int getID(){
		return id;
	}
	
	/**
	 * Returns the time a customer enters the store
	 * @return
	 */
	public double getTimeEnterdStore() {
		return timeEnterdStore;
	}
	
	/**
	 * Sets the time a customer enters the salon
	 * @param timeEnterdStore
	 */
	public void setTimeEnterdStore(int timeEnterdStore) {
		this.timeEnterdStore = timeEnterdStore;
	}
}

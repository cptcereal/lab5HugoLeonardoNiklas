package lab5.hairsalon.data;
/**
 * A customer who has a id and time they entered the store
 * @author inaule-6
 *
 */
public class Customer {
	private final int id;
	private int timeEnterdStore;
	
	/**
	 * Adds id to the customer.
	 * @param id
	 */
	public Customer(int id, int timeEnterdStore) {
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
	 * 
	 * @return
	 */
	public int getTimeEnterdStore() {
		return timeEnterdStore;
	}
	
	public void setTimeEnterdStore(int timeEnterdStore) {
		this.timeEnterdStore = timeEnterdStore;
	}
}
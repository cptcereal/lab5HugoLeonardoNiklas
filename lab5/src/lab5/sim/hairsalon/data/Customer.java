package lab5.sim.hairsalon.data;

/**
 * A customer who has a id and time they entered the store
 * @author hugwan-6, leopel-6, inaule-6 
 *
 */
public class Customer {
	private final int ID;
	
	/**
	 * Adds id to the customer.
	 * 
	 * @param id - the customers id
	 */
	public Customer(int id) {
		this.ID = id;
	}
	
	/**
	 * returns the id of the customer
	 * 
	 * @return the customers id
	 */
	public int getID(){
		return ID;
	}
}

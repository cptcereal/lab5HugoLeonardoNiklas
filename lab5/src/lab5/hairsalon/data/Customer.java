package lab5.hairsalon.data;
/**
 * A customer who has a id
 * @author inaule-6
 *
 */
public class Customer {
	private final int id;

	/**
	 * Adds id to the customer.
	 * @param id
	 */
	public Customer(int id) {
		this.id = id;
	}
	
	/**
	 * returns the id of the customer.
	 * @return
	 */
	public int getID(){
		return id;
	}
}

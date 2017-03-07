package lab5.sim.hairsalon.data;


/**
 * This class is a list of customers
 * 
 * @author hugwan-6, leopel-6, inaule-6 
 *
 */
public class CustomerList {
	private Node first;
	private int numCustomers;
	
	public CustomerList() {
		first = new Node(null);
	}
	
	public boolean addCustomer(Customer c) {
		Node temp = first;
		while(true){
			if (temp.customer == null) {
				temp = new Node(c);
				temp.next = first;
				first = temp;
				numCustomers += 1;
				return true;
			}
			if (temp.customer.equals(c)) {
				return false;
			}
			temp = temp.next;
		}
	} 
	
	/**
	 * Returns the number of customers in the list
	 * 
	 * @return number of customers 
	 */
	public int numCustomers() {
		return numCustomers;
	}
	
	/**
	 * Returns all the customers in the list
	 * 
	 * @return an customer array
	 */
	public Customer[] getCustomers() {
		Customer[] svar = new Customer[numCustomers];
		Node temp = first;
		for (int i = 0; i < numCustomers; i++) {
			svar[i] = temp.customer;
			temp = temp.next;
		}
		return svar;
	}
	
	class Node{								// Private?
		public final Customer customer;
		public Node next;
		
		public Node(Customer c) {
			this.customer = c;
		}
	}
}

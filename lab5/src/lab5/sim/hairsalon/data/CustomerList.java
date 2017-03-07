package lab5.sim.hairsalon.data;


/**
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
	
	public int numCustomers() {
		return numCustomers;
	}
	
	public Customer[] getCustomers() {
		Customer[] svar = new Customer[numCustomers];
		Node temp = first;
		for (int i = 0; i < numCustomers; i++) {
			svar[i] = temp.customer;
			temp = temp.next;
		}
		return svar;
	}
	
	class Node{
		public final Customer customer;
		public Node next;
		
		public Node(Customer c) {
			this.customer = c;
		}
	}
}

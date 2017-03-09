package lab5.sim.hairsalon.data;

/**
 * Create a queue to store elements in an orderly way
 * 
 * @author hugwan-6, leopel-6, inaule-6
 *
 */
public class QueueList {
	private Customer[] queue;
	private Customer[] vipQueue;
	private Double[] timeOfEnter;
	
	private int lastInQueue;
	private int lastInVIPQueue;
	private int maxNumWaiting;
	private int lost;
	
	private double timetoLose;
	
	/**
	 * The constructor creates a queue
	 * 
	 * @param maxQueue - the maximum size of the queue
	 */
	public QueueList(int maxQueue) {
		queue = new Customer[maxQueue];
		vipQueue = new Customer[maxQueue];
		timeOfEnter = new Double[maxQueue];
		lastInQueue = 0;
		lastInVIPQueue = 0;
		maxNumWaiting = 0;
		lost = 0;
		timetoLose = 0;
	}
	
	/**
	 * Adds an enter event to queue
	 * 
	 * @param e - the enter event to add to the queue
	 * @return true if the event was added and false otherwise
	 */
	public boolean addToQueue(Customer c, double timeofEnter) {
		if (lastInQueue + lastInVIPQueue < queue.length) {
			queue[lastInQueue] = c;
			// Store the entry time of a regular customer who enters the store this is important 
			// if we need to later kick this customer because a dissatisfied customer returns
			timeOfEnter[lastInQueue] = timeofEnter;
			
			lastInQueue += 1;						
			
			
			if (lastInQueue + lastInVIPQueue > maxNumWaiting) {
				maxNumWaiting = lastInQueue + lastInVIPQueue;
			}
			return true;
		}
		
		// If the queue was full, the hair salon lost a customer
		lost += 1;
		return false;
	}
	
	/**
	 * Adds a dissatisfied customer to the queue
	 * 
	 * @param e - the return event to add
	 * @return true if the event was added and false otherwise
	 */
	public boolean addToVIPQueue(Customer c) {
		if (lastInVIPQueue < vipQueue.length) {
			vipQueue[lastInVIPQueue] = c;
			lastInVIPQueue += 1;
			
			if (lastInQueue + lastInVIPQueue > queue.length) {
				lastInQueue -= 1;
				timetoLose = timeOfEnter[lastInQueue]; 	// A regular customer was kicked from the queue, so we have a time we need to remove from the total waiting time of all the customers.
				lost += 1;	
			}
			
			if (lastInQueue + lastInVIPQueue > maxNumWaiting) {
				maxNumWaiting = lastInQueue + lastInVIPQueue;
			}
			return true;
		}
		return false;
	}
	
	
	/**
	 * If all the chairs in the hair salon no longer is occupied a customer is taken from the queue to get their hair cut.
	 * If there's dissatisfied customers in the queue they are prioritised over regular customers.
	 * 
	 * @return the next event in the queue
	 */
	public Customer next() {
		if (lastInVIPQueue != 0) {
			lastInVIPQueue -= 1;
			Customer temp = vipQueue[0];
			for (int i = 0; i < lastInVIPQueue; i++) {
				vipQueue[i] = vipQueue[i + 1];
			}
			return temp;
		}
		
		Customer temp = queue[0];
		lastInQueue -= 1;
		for (int i = 0; i < lastInQueue; i++) {
			queue[i] = queue[i + 1];
			timeOfEnter[i] = timeOfEnter[i + 1];
		}
		return temp;
	}
	
	/**
	 * Checks if the queue is empty
	 * 
	 * @return whether or not the queue is empty
	 */
	public boolean isEmpty() {
		return (lastInQueue == 0 && lastInVIPQueue == 0);
	}
	
	/**
	 * Returns the size of the queue in the hair salon
	 * 
	 * @return the current queue size
	 */
	public int getQueueSize(){
		return lastInQueue + lastInVIPQueue;
	}
	
	/**
	 * Returns the maximum size the queue in the hair salon reached during the simulation
	 * 
	 * @return maximum size of the queue
	 */
	public int getMaxNumWaiting(){
		return maxNumWaiting; 
	}
	
	/**
	 * Returns the number of customers who entered the hair salon but didn't get their hair cut
	 * 
	 * @return number of lost customers
	 */
	public int getLost() {
		return lost;
		
	}
	
	/**
	 * Returns the time a customer who got kicked from the queue entered the queue
	 * 
	 * @return time entered
	 */
	public double timeToLose() {
		double temp = timetoLose;
	
		return temp;
	}
	
	/**
	 * Resets the time stored in time to lose
	 * 
	 */
	public void resetTimeToLose() {
		timetoLose = 0;
	}
}

package lab5.hairsalon.data;

import lab5.data.State;
import lab5.data.Time;

/**
 * 
 * @author inaule-6
 *
 */
public class HairsalonState extends State {
	
	private final int MAX_CHAIRS;
	private final int MAX_QUEUE;
	
	private ArrayList<>
	
	private Time timeWaiting;
	
	private int numHaircut;
	private int numWaiting;
	
	/**
	 * 
	 */
	public HairsalonState(int chairs, int queue){
		super();
		MAX_CHAIRS = chairs;
		MAX_QUEUE = queue;
		numHaircut = 0;
		numWaiting = 0;
		timeWaiting = new Time();
	}
	
	
}

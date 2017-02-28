package lab5.simulation;

public abstract class Event {
	private final int TIME;
	private Simulation sim;
	
	public Event(int time, Simulation sim){
		
	}
	
	public void effect(State state){
		
	}
	
	public int getTime(){
		return TIME; 
	}
	
	public Simulation getSim(){
		return sim;
	}
}

package lab5.simulation;

public abstract class Event {
	private final int TIME;
	private Sim sim;
	
	public Event(int time, Sim sim){
		
	}
	
	public void effect(State state){
		
	}
	
	public int getTime(){
		return TIME; 
	}
	
	public Sim getSim(){
		return sim;
	}
}

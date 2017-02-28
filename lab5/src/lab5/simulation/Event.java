package lab5.simulation;

public abstract class Event {
	private final int TIME;
	private Simulation sim;
	
	public Event(Simulation sim, int time){
		sim = this.sim;
		TIME = this.time;
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

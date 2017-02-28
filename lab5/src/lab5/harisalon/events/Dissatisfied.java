package lab5.harisalon.events;

import lab5.data.State;
import lab5.simulation.Simulation;

public class Dissatisfied {
	private final int ID;
	
	public Dissatisfied(int time, Simulation sim, int id){
		Enter enter= new Enter(time, sim,id);
	}
	
	public void effect(State state){
		
	}
}

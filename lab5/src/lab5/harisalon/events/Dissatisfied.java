package lab5.harisalon.events;

import lab5.data.State;
import lab5.simulation.Simulation;

public class Dissatisfied {
	private final int ID;
	
	public Dissatisfied(int time, Simulation sim, int ID){
		this.ID = ID;
		Enter enter= new Enter(time, sim, this.ID);
	}
	
	public void effect(State state){
		/*Kunden placeras först i kön, tiden för alla kunder i kön måste ökas med tiden det kommer för
		dissatisfied customer att klippa sig.
		*/ 
	}
}

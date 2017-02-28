package lab5.harisalon.events;

import lab5.simulation.Event;
import lab5.simulation.Simulation;

/**
 * The event representing that a customer enters the hair salon
 * 
 * @author hugwan-6, leopel-6, inaule-6
 *
 */
public class Enter extends Event{

	public Enter(Simulation sim, int time, int ID) {
		super(sim, time);
		
	}

}

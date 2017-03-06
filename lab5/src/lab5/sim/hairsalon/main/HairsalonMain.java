package lab5.sim.hairsalon.main;

import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.State;
import lab5.sim.hairsalon.data.HairsalonSettings;
import lab5.sim.hairsalon.data.HairsalonSimulation;
import lab5.sim.hairsalon.data.HairsalonState;

/**
 * Creates a new hair salon simulation
 * 
 * @author hugwan-6, leopel-6, inaule-6
 */
public class HairsalonMain {

	
	/**
	 * Starts the simulation
	 * 
	 * @param The settings of the hairsalon
	 */
	public static void main(String[] args) {
		HairsalonSettings hairsalonSettings;
		if (args.length != 10) {
			hairsalonSettings = new HairsalonSettings();
		} else {
			hairsalonSettings = new HairsalonSettings(args);
		}
		HairsalonState hairsalonState = new HairsalonState(hairsalonSettings);
		HairsalonSimulation sim = new HairsalonSimulation(hairsalonState);
	}
}
package lab5.sim.hairsalon.main;


import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.Time;
import lab5.sim.hairsalon.GUI.HairsalonView;
import lab5.sim.hairsalon.data.HairsalonSettings;
import lab5.sim.hairsalon.data.HairsalonState;
import lab5.sim.hairsalon.data.StartHSS;


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
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		HairsalonSettings hairsalonSettings;
		if (args.length != 10) {
			hairsalonSettings = new HairsalonSettings();
		} else {
			hairsalonSettings = new HairsalonSettings(args);
		}
		HairsalonState hairsalonState = new HairsalonState(hairsalonSettings);
		Simulation sim = new Simulation(hairsalonState, new HairsalonView());
		sim.addStartEvent(new StartHSS(sim, new Time(0)));
	}
}
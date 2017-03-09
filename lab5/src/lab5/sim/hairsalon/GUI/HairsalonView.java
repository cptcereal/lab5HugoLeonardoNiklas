package lab5.sim.hairsalon.GUI;

import java.util.Observable;
import lab5.sim.general.GUI.View;
import lab5.sim.general.data.Event;
import lab5.sim.general.data.Simulation;
import lab5.sim.general.data.Start;
import lab5.sim.general.data.Stop;
import lab5.sim.hairsalon.data.Closing;
import lab5.sim.hairsalon.data.Done;
import lab5.sim.hairsalon.data.Enter;
import lab5.sim.hairsalon.data.HairsalonSettings;
import lab5.sim.hairsalon.data.HairsalonState;
import lab5.sim.hairsalon.data.Return;
import lab5.sim.hairsalon.data.StartHSS;
import lab5.sim.hairsalon.data.StateInfo;
import lab5.sim.hairsalon.data.StopHSS;

public class HairsalonView extends View {
	/**
	 * Prints out the first section of the complete simulation information, containing only constant values
	 * @param settings
	 */
	private void printSettings(HairsalonSettings settings) {
		System.out.println("Closing time of the day ..............: " + settings.getClosingTime());
		System.out.println("Total number of chairs ...............: " + settings.getMaxChairs());
		System.out.println("Maximum queue size ...................: " + settings.getMaxQueue());
		System.out.println("Lambda (customers/timeunit entering)..: " + settings.getCustomersPerTimeUnit());
		System.out.println("hmin and hmax (cutting time interval) : [" + settings.getHmin() + ", " + settings.getHmax() + "]");
		System.out.println("dmin and dmax (return time interval) .: [" + settings.getDmin() + ", "+ settings.getDmax() + "]");
		System.out.println("Risk dissatisfied returns: ...........: " + settings.getP());
		System.out.println("Seed used in pseudo random generator .: " + settings.getSeed());
		System.out.println("---------------------------------------------------------------------");
	}
	
	/**
	 * Prints out the start event's corresponding information at that moment 
	 * @param e, a Start event
	 */
	private void printStartHSS(Start e) { 
		System.out.format("%s %2s %6s %6s %6s %7s %6s %6s %6s %6s %n", "- Time" , "Event", "Id", "Idle", "TIdle", "TWait", "InQ", "Cut", "Lost", "Ret -");
		System.out.format("%6.2f %2s %n", e.getTime(), e.toString());
	}
	
	/**
	 * Prints out a stop event's corresponding information at that moment
	 * @param e, a Stop event
	 * @param info, the information taken from the simulations state
	 */
	private void printStopHSS(Stop e, StateInfo info) {
		System.out.format("%6.2f %2s %10s %6.2f %7.2f %6s %6s %6s %4s %n", 
				e.getTime(), e.toString(), info.idleChairs(), info.tIdle(), info.getTimeWaiting(), info.numWaiting(), 
				info.numCut(), info.numLost(), info.getDissatisfiedCustomers());
	}
	
	/**
	 * Prints out a return event's corresponding information at that moment
	 * @param e, a Return even
	 * @param info, the information taken from the simulations state
	 */
	private void printReturn(Return e, StateInfo info) {
		System.out.format("%6.2f %2s %4s %6s %6.2f %7.2f %6s %6s %6s %4s %n", 
				e.getTime(), e.toString(), e.getCustomer().getID(), info.idleChairs(), info.tIdle(), info.getTimeWaiting(), info.numWaiting(), 
				info.numCut(), info.numLost(), info.getDissatisfiedCustomers());
		
	}
	
	/**
	 * Prints out a message with the closing time and "Closing" in it
	 * @param e, a Closing event
	 */
	private void printClosing(Closing e) {
		System.out.format("%6.2f %2s %n", e.getTime(), e.toString());
	}

	/**
	 * Prints out a an enter event's current information as well as the event's name
	 * @param e, a Start event
	 * @param info, the information taken from the simulation state
	 */
	private void printEnter(Enter e, StateInfo info) {
		System.out.format("%6.2f %2s %5s %6s %6.2f %7.2f %6s %6s %6s %4s %n", 
				e.getTime(), e.toString(), e.getCustomer().getID(), info.idleChairs(), info.tIdle(), info.getTimeWaiting(), info.numWaiting(), 
				info.numCut(),info.numLost(), info.getDissatisfiedCustomers());
	}
	
	/**
	 * Prints out a a done event's current information as well as the event's name
	 * @param e, a Done event
	 * @param info, the information taken from the simulation state
	 */
	private void printDone(Done e, StateInfo info) {
		System.out.format("%6.2f %2s %6s %6s %6.2f %7.2f %6s %6s %6s %4s %n", 
				e.getTime(), e.toString(), e.getCustomer().getID(), info.idleChairs(), info.tIdle(), info.getTimeWaiting(), info.numWaiting(), 
				info.numCut(), info.numLost(), info.getDissatisfiedCustomers());
	}
	
	
	private void printResults(StateInfo info) {
		System.out.println("---------------------------------------------------------------------");
		System.out.format("%s %2s %n", "Number of customers cut: ......:", info.numCut());
		System.out.format("%s %2.2f %n", "Average cutting time...........:", info.averageCuttingTime());
		System.out.format("%s %2.2f %n", "Average queueing time: ........:", info.averageQueueTime());
		System.out.format("%s %1s %n", "Largest queue (max NumWaiting) :", info.getMaxNumWaiting());
		System.out.format("%s %1s %n", "Customers not cut (NumLost) ...:", info.numLost());
		System.out.format("%s %1s %n", "Dissatisfied customers: .......:", info.getDissatisfiedCustomers());
		System.out.format("%s %2.2f", "Time chairs were idle: ........:", info.tIdle());
	}

	/**
	 * Prints information depending on what happened in the simulation
	 * 
	 */
	public void update(Observable o, Object arg) {
		Simulation sim = ((Simulation)o);
		HairsalonState state = ((HairsalonState)sim.getState());
		StateInfo info = state.getInfo();
		Event temp = ((Event)arg);
		
		if (temp.toString().equals("Enter")) {
			printEnter(((Enter)temp), info);
		}
		else if (temp.toString().equals("Done")) {
			printDone((Done) temp, info);
		}
		else if (temp.toString().equals("Return")) {
			printReturn((Return) temp, info);
		}
		else if (temp.toString().equals("Closing")) {
			printClosing((Closing) temp);
		}
		else if (temp.toString().equals("StartHSS")) {
			printSettings(state.getInfo().getSettings());
			printStartHSS((StartHSS) temp);
		}
		else if (temp.toString().equals("StopHSS")) {
			printStopHSS((StopHSS) temp, info);
			printResults(state.getInfo());
		}
	}

}

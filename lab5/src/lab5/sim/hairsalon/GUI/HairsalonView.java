package lab5.sim.hairsalon.GUI;

import java.util.Observable;
import java.util.Observer;

import lab5.sim.hairsalon.data.Enter;
import lab5.sim.hairsalon.data.HairsalonSettings;
import lab5.sim.hairsalon.data.HairsalonState;
import lab5.sim.hairsalon.data.StateInfo;

public class HairsalonView implements Observer {
	
	public void printSettings(HairsalonSettings settings) {
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
	
	public void printEnter(Enter e, StateInfo info) {
		System.out.format("%6.2f %2s %5s %6s %6.2f %7.2f %6s %6s %6s %4s %n", 
				e.getTime(), e.toString(), e.getCustomer().getID(), idleChairs(info), tIdle(), timeWaiting.getElapsedTime(), numWaiting(), 
				numCut(),numLost(), dissatisfiedlist.numCustomers());
	}
	
	public void update(Observable arg0, Object arg1) {
		
		
	}

}

package lab5.sim.hairsalon.GUI;

import java.util.Observable;
import java.util.Observer;

import com.sun.prism.paint.Stop;

import lab5.sim.general.data.Start;
import lab5.sim.hairsalon.data.Closing;
import lab5.sim.hairsalon.data.Done;
import lab5.sim.hairsalon.data.Enter;
import lab5.sim.hairsalon.data.HairsalonSettings;
import lab5.sim.hairsalon.data.Return;
import lab5.sim.hairsalon.data.StateInfo;

public class HairsalonView {
	
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
	
	public void printStartHSS(Start e) {
		System.out.format("%s %2s %6s %6s %6s %7s %6s %6s %6s %6s %n", "- Time" , "Event", "Id", "Idle", "TIdle", "TWait", "InQ", "Cut", "Lost", "Ret -");
		System.out.format("%6.2f %2s %n", e.getTime(), e.toString());
	}
	
	public void printStopHSS(Stop e) {
		
	}
	
	public void printReturn(Return e) {
		
	}
	
	public void printClosing(Closing e) {
		
		
	}
	
	public void printEnter(Enter e, StateInfo info) {
		System.out.format("%6.2f %2s %5s %6s %6.2f %7.2f %6s %6s %6s %4s %n", 
				e.getTime(), e.toString(), e.getCustomer().getID(), info.idleChairs(), info.tIdle(), info.timeWaiting, info.numWaiting(), 
				info.numCut(),info.numLost(), info.dissatisfiedlist.numCustomers());
	}
	
	public void printDone(Done e, StateInfo info) {
		System.out.format("%6.2f %2s %6s %6s %6.2f %7.2f %6s %6s %6s %4s %n", 
				e.getTime(), e.toString(), e.getCustomer().getID(), info.idleChairs(), info.tIdle(), info.timeWaiting, info.numWaiting(), 
				info.numCut(), info.numLost(), info.dissatisfiedlist.numCustomers());
	}

}

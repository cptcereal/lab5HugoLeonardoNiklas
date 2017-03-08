package lab5.sim.hairsalon.GUI;

import java.util.Observable;
import java.util.Observer;
import com.sun.prism.paint.Stop;

import lab5.sim.general.GUI.View;
import lab5.sim.general.data.Start;
import lab5.sim.hairsalon.data.Closing;
import lab5.sim.hairsalon.data.Done;
import lab5.sim.hairsalon.data.Enter;
import lab5.sim.hairsalon.data.HairsalonSettings;
import lab5.sim.hairsalon.data.Return;
import lab5.sim.hairsalon.data.StateInfo;

public class HairsalonView extends View {
	
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
	
	public void printStopHSS(Stop e, StateInfo info) {
		System.out.format("%6.2f %2s %10s %6.2f %7.2f %6s %6s %6s %4s %n", 
				e.getTime(), e.toString(), info.idleChairs(), info.tIdle(), info.timeWaiting, info.numWaiting(), 
				info.numCut(), info.numLost(), info.dissatisfiedlist.numCustomers());
		System.out.println("---------------------------------------------------------------------");
		System.out.format("%s %2s %n", "Number of customers cut: ......:", info.numCut());
		System.out.format("%s %2.2f %n", "Average cutting time...........:", info.averageCuttingTime());
		System.out.format("%s %2.2f %n", "Average queueing time: ........:", info.averageQueueTime());
		System.out.format("%s %1s %n", "Largest queue (max NumWaiting) :", info.queueList.getMaxNumWaiting());
		System.out.format("%s %1s %n", "Customers not cut (NumLost) ...:", info.numLost());
		System.out.format("%s %1s %n", "Dissatisfied customers: .......:", info.dissatisfiedlist.numCustomers());
		System.out.format("%s %2.2f", "Time chairs were idle: ........:", info.tIdle());
	}
	
	public void printReturn(Return e, StateInfo info) {
		System.out.format("%6.2f %2s %4s %6s %6.2f %7.2f %6s %6s %6s %4s %n", 
				elapsedTime.getElapsedTime(), eventName(),customerID() , idleChairs(), tIdle(), timeWaiting.getElapsedTime(), numWaiting(), 
				numCut(),numLost(), dissatisfiedlist.numCustomers());
		
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

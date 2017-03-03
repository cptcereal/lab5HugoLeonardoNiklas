package lab5.gui;

import lab5.data.PrintAble;


/**
 * Displays the corresponding data to a specific simulation,i.e. important information crucial to the simulation
 * @author hugwan-6, leopel-6, inaule-6 
 *
 */
public class View {

	/**
	 * Calls the printAll method in the given object.
	 * @param setting - Settings of the Simulator.
	 */
	public View(PrintAble setting) {
		setting.printAll();
	}
	/**
	 * Calls the printAll method in the given object.
	 * @param stateInfo - All the States Info.
	 */
	public void showDataOnView(PrintAble stateInfo) {
		stateInfo.printAll();
	}
}

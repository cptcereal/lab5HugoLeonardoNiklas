package lab5.gui;

import lab5.data.PrintAble;


/**
 * Displays the corresponding data to a specific simulation,i.e. important information crucial to the simulation
 * @author hugwan-6, leopel-6, inaule-6 
 *
 */
public class View {

	
	public View(PrintAble setting) {
		setting.printAll();
	}
	public void showDataOnView(PrintAble stateInfo) {
		stateInfo.printAll();
	}
}

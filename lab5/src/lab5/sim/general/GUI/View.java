package lab5.sim.general.GUI;




/**
 * Displays the corresponding data to a specific simulation,i.e. important information crucial to the simulation
 * @author hugwan-6, leopel-6, inaule-6 
 *
 */
public class View {

	/**
	 * Calls the printAll method in the given object.
	 * @param stateInfo - All the States Info.
	 */
	public void showDataOnView(PrintAble infoPrint) {
		infoPrint.printAll();
	}
}

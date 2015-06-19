package fr.utbm.info.gl52;

import fr.utbm.info.gl52.Graphics.Controller;

/**
 * Main launcher. Call the controller for lunching the application.
 * @author Alexandre
 *
 */
public class MainLauncher {

	/**
	 * The main methods does not take any arguments.
	 * @param args None are checked
	 */
	public static void main(String[] args) {
		Controller.getInstance().start();
	}
}

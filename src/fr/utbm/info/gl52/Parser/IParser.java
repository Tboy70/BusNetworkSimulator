package fr.utbm.info.gl52.Parser;

import fr.utbm.info.gl52.Collection.graph.Graph;


/**
 * Interface to parse all type of file in this project
 */
public interface IParser<Dn,De> extends Runnable {
	
	/**
	 * Implement Runnable (Thread)
	 */
	public void run();
	
	/**
	 * Indicate if the parsing is finished or not
	 * @return true if the parsing is finished, flase otherwise
	 */
	public boolean hasFinished();
	
	/**
	 * Get Graph corresponding to the parsed file
	 * @return The model graph of the parsed file
	 */
	public Graph<Dn,De> getData();
}
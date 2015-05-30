package fr.utbm.info.gl52.Parser;

import fr.utbm.info.gl52.Collection.graph.IGraph;


/**
 * Interface to parse all type of file in this project
 */
public interface IParser<G extends IGraph<?,?>> extends Runnable {
	
	/**
	 * Implement Runnable (Thread)
	 */
	public void run();
	
	/**
	 * Get Graph corresponding to the parsed file
	 * @return The model graph of the parsed file
	 */
	public G getData();
	
	public void setGraph(G graph);	
	
	public void addFinishedCallback(FinishedParsingCallcack c);
}
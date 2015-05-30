package fr.utbm.info.gl52.Parser;

import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;


/**
 * Interface to parse all type of file in this project
 */
public interface IParser<N extends INode<?>, E extends IEdge<?>> extends Runnable {
	
	/**
	 * Implement Runnable (Thread)
	 */
	public void run();
	
	/**
	 * Get Graph corresponding to the parsed file
	 * @return The model graph of the parsed file
	 */
	public IGraph<N,E> getData();
	
	public void setGraph(IGraph<N,E> graph);	
	
	public void addCallBack(FinishedParsingCallcack c);
}
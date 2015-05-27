package fr.utbm.info.gl52.Parser;

import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;

/**
 * 
 */
public interface IParser<N extends INode<?,N>,E extends IEdge<?,E>> extends Runnable {
	
	public void setFile(String file);
	
	public void run();
	
	public boolean hasFinished();
	
	public IGraph<N,E> getData();
}
package fr.utbm.info.gl52.Collection.graph;

/**
 * 
 */
public interface IGraph<N extends INode<?>, E extends IEdge<?>> extends Iterable<IEdge<?>> {

	public void addEdge(E e);
	public boolean removeEdge(E e);
	
}
package fr.utbm.info.gl52.Collection.graph;

/**
 * 
 */
public interface IGraph<N extends INode<?>, E extends IEdge<?>> extends Iterable<IEdge> {

	public void addEdge(E edge1);
	public boolean removeEdge(E e);
	
}
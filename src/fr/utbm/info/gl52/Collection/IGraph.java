package fr.utbm.info.gl52.Collection;

/**
 * 
 */
public interface IGraph<Dn, De, N extends INode<Dn,N>, E extends IEdge<De, E>> extends Iterable<E> {

	public void addEdge(E edge1);
	public boolean removeEdge(E e);
	
}
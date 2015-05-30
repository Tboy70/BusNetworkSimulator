package fr.utbm.info.gl52.Collection.graph;

/**
 * Simple generic graph with no redundant check for objects
 */
public interface IGraph<N extends INode<?>, E extends IEdge<?>> extends Iterable<IEdge<?>> {
	
	/**
	 * Add an edge with its nodes to the graph
	 * @param e Edge to insert
	 */
	public void addEdge(E e);
	
	/**
	 * Remove an edge from the graph 
	 * @param e The edge to delete
	 * @return true if succeed, false otherwise
	 */
	public boolean removeEdge(E e);
	
	/**
	 * Add a node with its edges to the graph
	 * @param e Node to insert
	 */
	public void addNode(N n);
	
	/**
	 * Remove a node from the graph 
	 * @param e The node to delete
	 * @return true if succeed, false otherwise
	 */
	public boolean removeNode(N n);
	
	/**
	 * Add an edge without its nodes 
	 * @param e The edge to add
	 */
	public void add(E e);
	
	/**
	 * Add a node without its edges
	 * @param n The node to add
	 */
	public void add(N n);
}
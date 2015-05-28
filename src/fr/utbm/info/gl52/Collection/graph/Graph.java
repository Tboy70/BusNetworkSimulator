package fr.utbm.info.gl52.Collection.graph;


/**
 * Graphe non orienté
 * Orientation faisable en fonction de l'utilisation de NodeA et de NodeB
 */
public class Graph<Dn, De> extends AbstractGraph<Node<Dn>, Edge<De>> {

	public Graph()
	{
		super();
	}

	@Override
	public String toString() {
		return "Graph [listEdge=" + listEdge + ", listNode=" + listNode + "]";
	}
}

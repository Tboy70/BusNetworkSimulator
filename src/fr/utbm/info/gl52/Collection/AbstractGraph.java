package fr.utbm.info.gl52.Collection;

import java.util.*;

/**
 * 
 */
public abstract class AbstractGraph extends AbstractTree implements IGraph {

	private List<INode> nodes = new ArrayList<INode>();
	
	private List<IEdge> edges = new ArrayList<IEdge>();
    /**
     * 
     */
    public AbstractGraph() {
    }

    /**
     * @param Edge e
     */
    public void addEdge(IEdge e) {
        edges.add(e);
    }

    /**
     * @param Edge e
     */
    public void removeEdge(IEdge e) {
        edges.remove(e);
    }
    
    public void addNode(INode n) {
    	nodes.add(n);
    }

    public void removeNode(INode n) {
    	nodes.remove(n);
    }
    
    public void createEdge( Node n1, Node n2) {
    	OrientedEdge newEdge = new OrientedEdge(n1, n2);
    	addEdge(newEdge);
    }
}
package fr.utbm.info.gl52.Collection;

public class Edge<De> extends AbstractEdge<De, Edge<De> > {
	
	public Edge() {
		super();
    }
    public Edge(De D) {
    	super(D);
    }
    public Edge(De D, Node A, Node B)
    {
    	super(D, A, B);
    }

}

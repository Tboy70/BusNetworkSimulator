package fr.utbm.info.gl52.Collection.graph;

public class Edge<De> extends AbstractEdge<De> {
	
	public Edge() {
		super();
    }
    public Edge(De D) {
    	super(D);
    }
    public Edge(De D, Node<?> A, Node<?> B)
    {
    	super(D, A, B);
    }
    
	@Override
	public String toString() {
		return "Edge [data=" + this.data + "]";
	}
}

package fr.utbm.info.gl52.Collection;

/**
 * 
 */
public class OrientedEdge<D> extends AbstractEdge<D, Node<D>> {

	private Node<D> nodeStart;
	
	private Node<D> nodeEnd;
	
	private D data;
	
    /**
     * 
     */
    public OrientedEdge(Node<D> n1, Node<D> n2) {
    	this.nodeStart = n1;
    	this.nodeEnd = n2;
    }
    
	public Node<D> getNodeStart() {
		return nodeStart;
	}
	public void setNodeStart(Node<D> nodeStart) {
		this.nodeStart = nodeStart;
	}
	public Node<D> getNodeEnd() {
		return nodeEnd;
	}
	public void setNodeEnd(Node<D> nodeEnd) {
		this.nodeEnd = nodeEnd;
	}

	@Override
	public D getData() {
		return this.data;
	}

	@Override
	public void setData(D data) {
		this.data = data;
	}
}
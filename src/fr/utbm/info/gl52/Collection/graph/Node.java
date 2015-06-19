package fr.utbm.info.gl52.Collection.graph;

public class Node<Dn> extends AbstractNode<Dn> {

	public Node(Dn d) {
		super(d);
	}
	
	@Override
	public String toString() {
		return "Node [data=" + this.data + "]";
	}	
}

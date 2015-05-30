package fr.utbm.info.gl52.Middle;

import fr.utbm.info.gl52.Collection.graph.Edge;
import fr.utbm.info.gl52.Collection.graph.INode;

/**
 * 
 */
public class Segment<De> extends Edge<De> {

    /**
     * 
     */
    public Segment() {
    	super();
    }

	public Segment(De D) {
		super(D);
	}
	
	public Segment(De D, INode<?> A, INode<?> B) {
		super(D, A, B);
	}
}
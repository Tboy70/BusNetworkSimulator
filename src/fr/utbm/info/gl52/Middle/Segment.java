package fr.utbm.info.gl52.Middle;

import fr.utbm.info.gl52.Collection.graph.Edge;
import fr.utbm.info.gl52.Collection.graph.INode;

/**
 * Segment which represent each line of the itinerary
 * @author Alexandre
 *
 * @param <De> The data to set in the segment
 */
public class Segment<De> extends Edge<De> {

    /**
     * Default constructor
     */
    public Segment() {
    	super();
    }

    /**
     * Constructor with direct et of Data
     * @param D The data to set in
     */
	public Segment(De D) {
		super(D);
	}
	
	/**
	 * Constructor which set the data and nodes
	 * @param D Data to set in
	 * @param A First linked node
	 * @param B Second linked node
	 */
	public Segment(De D, INode<?> A, INode<?> B) {
		super(D, A, B);
	}
}
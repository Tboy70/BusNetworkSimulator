package fr.utbm.info.gl52.Middle;

import java.io.Serializable;

import fr.utbm.info.gl52.Collection.graph.Node;


/**
 * [MODEL] Connection between to Segment
 * @author Alexandre
 *
 * @param <D> D is data to store in Connection
 */
public class Connection<D> extends Node<D> implements Serializable {

	private static final long serialVersionUID = 2662377960152199468L;

	/**
     * Initialize basic Connection with a data  
     */
    public Connection(D data) {
    	super(data);
    }

}

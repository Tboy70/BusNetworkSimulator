package fr.utbm.info.gl52.Middle;

import java.io.Serializable;

import fr.utbm.info.gl52.Collection.graph.Node;


/**
 * 
 */
public class Connection<D> extends Node<D> implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2662377960152199468L;

	/**
     * 
     */
    public Connection(D data) {
    	super(data);
    }

}

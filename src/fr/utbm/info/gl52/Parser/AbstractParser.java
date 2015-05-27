package fr.utbm.info.gl52.Parser;

import fr.utbm.info.gl52.Collection.graph.Graph;
import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;


/**
 * Abstract Parsing class.
 * Launch Thread at construction.
 */
public class AbstractParser<N extends INode<?>,E extends IEdge<?>> implements IParser<N,E> {

	/**
	 * The file to parse
	 */
	private final String file;
	
	/**
	 * Boolean to indicate if the parsing is finished or not
	 */
	private boolean finished;
	
	/**
	 * Graph for importing data
	 */
	private IGraph<N, E> graph;
	
	@SuppressWarnings("unused")
	private AbstractParser(){
		this.file = "";
	}
	
    /**
     * Default constructor 
     */
    public AbstractParser(String file) {
    	this.finished = false;
    	this.file = file;
    	
    	Thread t = new Thread(this);
    	t.start();
    }


	@Override
	public void run() {
		// To implement
	}

	@Override
	public boolean hasFinished() {
		return this.finished;
	}

	@Override
	public IGraph<N,E> getData() {
		return this.graph;
	}

}
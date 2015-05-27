package fr.utbm.info.gl52.Parser;

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
	protected final String file;
	
	/**
	 * Once finished parsing
	 */
	protected FinishedParsingCallcack callback;
	
	/**
	 * Graph for importing data
	 */
	protected IGraph<N, E> graph;
	
	@SuppressWarnings("unused")
	private AbstractParser(){
		this.file = "";
	}
	
    /**
     * Default constructor 
     */
    public AbstractParser(String file) {
    	this.file = file;
    }


	@Override
	public void run() {
		// To implement
	}

	@Override
	public IGraph<N,E> getData() {
		return this.graph;
	}

	@Override
	public void addCallBack(FinishedParsingCallcack c){
		this.callback = c;
	}
}
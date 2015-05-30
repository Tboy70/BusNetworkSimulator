package fr.utbm.info.gl52.Parser;

import fr.utbm.info.gl52.Collection.graph.IGraph;


/**
 * Abstract Parsing class.
 * Launch Thread at construction.
 */
public class AbstractParser<G extends IGraph<?,?>> implements IParser<G> {

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
	protected G graph;
	
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
	public G getData() {
		return this.graph;
	}
	
	@Override
	public synchronized void setGraph(G graph){
		this.graph = graph;		
	}

	@Override
	public void addFinishedCallback(FinishedParsingCallcack c){
		this.callback = c;
	}
}
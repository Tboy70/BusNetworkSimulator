package fr.utbm.info.gl52.Parser;

import fr.utbm.info.gl52.Collection.graph.Graph;


/**
 * Abstract Parsing class.
 * Launch Thread at construction.
 */
public class AbstractParser<N,E> implements IParser<N,E> {

	/**
	 * The file to parse
	 */
	private final String file;
	
	/**
	 * Boolean to indicate if the parsing is finished or not
	 */
	private boolean finished;
	
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Graph<N,E> getData() {

		return null;
	}

}
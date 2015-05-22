package fr.utbm.info.gl52.Parser;

import fr.utbm.info.gl52.Collection.IGraph;
import fr.utbm.info.gl52.Collection.INode;
import fr.utbm.info.gl52.Middle.MapGraph;

public abstract class AbstractBad<D,N extends INode<D, N>> implements IBad<D,N> {

	/**
	 * Graph with no duplicated nodes and edges. 
	 */
	private IGraph<D,N> graph;
	
	/**
	 * Initialize new AbstractBad with new empty Graph
	 */
	public AbstractBad(){
		this.graph = new MapGraph();
	}
	
	@Override
	public boolean insertNewPoint(D point) {
		return false;
	}

	@Override
	public boolean insertNewPolyLine(D[] points) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IGraph addAllTo(IGraph<D,N> g) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}

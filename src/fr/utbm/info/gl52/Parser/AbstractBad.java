package fr.utbm.info.gl52.Parser;

import fr.utbm.info.gl52.Collection.IGraph;
import fr.utbm.info.gl52.Middle.MapGraph;
import fr.utbm.set.io.shape.ESRIPoint;

public abstract class AbstractBad implements IBad {

	private IGraph graph;
	
	public AbstractBad(){
		this.graph = new MapGraph();
	}
	
	@Override
	public void insertNewPoint(ESRIPoint point) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertNewPolyLine(ESRIPoint[] points) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAllTo(IGraph g) {
		// TODO Auto-generated method stub

	}

	@Override
	public IGraph getGraph() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

}

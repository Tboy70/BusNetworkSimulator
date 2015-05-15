package fr.utbm.info.gl52.Parser;

import fr.utbm.info.gl52.Collection.IGraph;
import fr.utbm.set.io.shape.ESRIPoint;

public interface IBad {
	
	public void insertNewPoint(ESRIPoint point);
	
	public void insertNewPolyLine(ESRIPoint points[]);
	
	public void addAllTo(IGraph g);
	
	public IGraph getGraph();
	
	public void flush();

}

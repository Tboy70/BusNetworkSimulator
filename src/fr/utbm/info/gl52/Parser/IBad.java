package fr.utbm.info.gl52.Parser;

import fr.utbm.info.gl52.Collection.IGraph;
import fr.utbm.info.gl52.Collection.INode;

/**
 * Allow to create new graph without duplicated points and polylines
 * @author Alexandre
 */
public interface IBad<D,N extends INode<D,N>> {
	
	/**
	 * Insert new point to the object
	 * @param point The point to add
	 * @return true if added, false otherwise (mainly because it has already be inserted)
	 */
	public boolean insertNewPoint(D point);
	
	/**
	 * Insert new polyline into the object
	 * @param points Points of the polyline to insert
	 * @return true if added, false otherwise (mainly because it has already be inserted)
	 */
	public boolean insertNewPolyLine(D points[]);
	
	/**
	 * Add all points and polylines inserted to an existing graph and get it back
	 * @param g Existing graph to add inserted point and polylines
	 * @return Return the same IGraph with no duplicated points and polylines and inserted points and polylines 
	 */
	public IGraph addAllTo(IGraph<D,N> g);
	
	/**
	 * Delete all points and polylines inserted in this instance
	 */
	public void flush();

}

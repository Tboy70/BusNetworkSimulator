package fr.utbm.info.gl52.Collection.graph;

import java.util.List;

/**
 * 
 */
public interface INode<Dn> {

	public void setData(Dn d);
	public Dn getData();
	public void addEdge(IEdge<?> e);
	public boolean removeEdge(IEdge<?> e);
	public int getNumberEdge();
	public List<IEdge<?>> getEdges();
	
	public boolean equals(Object object);
}
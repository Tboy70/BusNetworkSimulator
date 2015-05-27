package fr.utbm.info.gl52.Collection.graph;

/**
 * 
 */
public interface INode<Dn, N extends INode<Dn,N>> {

	public void setData(Dn d);
	public Dn getData();
	public void addEdge(IEdge e);
	public boolean removeEdge(IEdge e);
	public int getNumberEdge();
	@Override
	public boolean equals(Object object);
}
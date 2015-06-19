package fr.utbm.info.gl52.Collection.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public abstract class AbstractNode<Dn> implements INode<Dn> {

	protected Dn data;
	private List<IEdge<?>> listEdge;
	public AbstractNode()
	{
		this.listEdge = new ArrayList<>();
		this.data = null;
	}
	public void addEdge(IEdge<?> e)
	{
		if (!this.listEdge.contains(e))
			this.listEdge.add(e);
	}
	public boolean removeEdge(IEdge<?> e)
	{
		return this.listEdge.remove(e);
	}
	public AbstractNode(Dn d)
	{
		this.data = d;
	}
	public void setData(Dn d)
	{
		this.data = d;
	}
	public Dn getData()
	{
		return this.data;
	}
	public int getNumberEdge()
	{
		return this.listEdge.size();
	}
	
    /* (non-Javadoc)
	 * @see fr.utbm.info.gl52.Collection.graph.INode#getEdges()
	 */
	@Override
	public List<IEdge<?>> getEdges() {
		return this.listEdge;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.data == null) ? 0 : this.data.hashCode());
		result = prime * result
				+ ((this.listEdge == null) ? 0 : this.listEdge.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbstractNode))
			return false;
		AbstractNode<?> other = (AbstractNode<?>) obj;
		if (this.data == null) {
			if (other.data != null)
				return false;
		} else if (!this.data.equals(other.data))
			return false;
		if (this.listEdge == null) {
			if (other.listEdge != null)
				return false;
		} else if (!this.listEdge.equals(other.listEdge))
			return false;
		return true;
	}
}
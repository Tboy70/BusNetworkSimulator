package fr.utbm.info.gl52.Collection.graph;


/**
 * 
 */
public abstract class AbstractEdge<De> implements IEdge<De>  {

	protected De data;
	private INode<?> A;
	private INode<?> B;
	public AbstractEdge() {
    	this.data = null;
    	this.A = null;
    	this.B = null;
    }
    public AbstractEdge(De D) {
    	this.data = D;
    }
    public AbstractEdge(De D, INode<?> A, INode<?> B)
    {
    	this.data = D;
    	this.A = A;
    	this.B = B;
    }
	public void setNodes(INode<?>[] ns)
	{
		if (ns.length == 2)
		{
			this.A = ns[0];
			this.B = ns[1];
		}
	}
	
	public INode<?> getNodeA()
	{
		return this.A;
	}
	public INode<?> getNodeB()
	{
		return this.B;
	}
	
	public void setNodeA(INode<?> A)
	{
		this.A = A;
	}
	public void setNodeB(INode<?> B)
	{
		this.B = B;
	}
	
	public void setData(De D)
	{
		this.data = D;
	}
	public De getData()
	{
		return this.data;
	}

    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.A == null) ? 0 : this.A.hashCode());
		result = prime * result + ((this.B == null) ? 0 : this.B.hashCode());
		result = prime * result + ((this.data == null) ? 0 : this.data.hashCode());
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
		if (!(obj instanceof AbstractEdge))
			return false;
		AbstractEdge<?> other = (AbstractEdge<?>) obj;
		if (this.A == null) {
			if (other.A != null)
				return false;
		} else if (!this.A.equals(other.A))
			return false;
		if (this.B == null) {
			if (other.B != null)
				return false;
		} else if (!this.B.equals(other.B))
			return false;
		if (this.data == null) {
			if (other.data != null)
				return false;
		} else if (!this.data.equals(other.data))
			return false;
		return true;
	}
}
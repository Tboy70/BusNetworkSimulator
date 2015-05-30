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

    public boolean equals(Object object)
	{
        boolean sameSame = false;
        if (object != null && object instanceof AbstractEdge)
        {
        	AbstractEdge e = (AbstractEdge) object;
            sameSame = (e.getData().equals(this.getData())) && (e.getNodeA().equals(this.getNodeA())) && (e.getNodeB().equals(this.getNodeB()));
        }

        return sameSame;		
	}
}
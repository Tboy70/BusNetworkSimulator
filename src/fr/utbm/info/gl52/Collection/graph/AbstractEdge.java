package fr.utbm.info.gl52.Collection.graph;


/**
 * 
 */
public abstract class AbstractEdge<De> implements IEdge<De>  {

	protected De data;
	private INode<?> A;
	private INode<?> B;
	public AbstractEdge() {
    	data = null;
    	A = null;
    	B = null;
    }
    public AbstractEdge(De D) {
    	data = D;
    }
    public AbstractEdge(De D, INode<?> A, INode<?> B)
    {
    	data = D;
    	this.A = A;
    	this.B = B;
    }
	public void setNodes(INode<?>[] ns)
	{
		if (ns.length == 2)
		{
			A = ns[0];
			B = ns[1];
		}
	}
	
	public INode<?> getNodeA()
	{
		return A;
	}
	public INode<?> getNodeB()
	{
		return B;
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
		data = D;
	}
	public De getData()
	{
		return data;
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
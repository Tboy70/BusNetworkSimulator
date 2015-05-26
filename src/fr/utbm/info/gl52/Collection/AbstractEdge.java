package fr.utbm.info.gl52.Collection;


/**
 * 
 */
public abstract class AbstractEdge<De, E extends IEdge<De, E> > implements IEdge<De, E>  {

	private De data;
	private Node A;
	private Node B;
	public AbstractEdge() {
    	data = null;
    	A = null;
    	B = null;
    }
    public AbstractEdge(De D) {
    	data = D;
    }
    public AbstractEdge(De D, Node A, Node B)
    {
    	data = D;
    	this.A = A;
    	this.B = B;
    }
	public void setNodes(Node[] ns)
	{
		if (ns.length == 2)
		{
			A = ns[0];
			B = ns[1];
		}
	}
	
	public Node getNodeA()
	{
		return A;
	}
	public Node getNodeB()
	{
		return B;
	}
	
	public void setNodeA(Node A)
	{
		this.A = A;
	}
	public void setNodeB(Node B)
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
}
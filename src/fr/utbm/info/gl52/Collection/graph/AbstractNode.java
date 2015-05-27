package fr.utbm.info.gl52.Collection.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public abstract class AbstractNode<Dn, N extends AbstractNode<Dn,N>> implements INode<Dn, N> {

	private Dn data;
	private List<IEdge> listEdge;
	public AbstractNode()
	{
		listEdge = new ArrayList<IEdge>();
		data = null;
	}
	public void addEdge(IEdge e)
	{
		if (!listEdge.contains(e))
			listEdge.add(e);
	}
	public boolean removeEdge(IEdge e)
	{
		return listEdge.remove(e);
	}
	public AbstractNode(Dn d)
	{
		data = d;
	}
	public void setData(Dn d)
	{
		data = d;
	}
	public Dn getData()
	{
		return data;
	}
	public int getNumberEdge()
	{
		return listEdge.size();
	}
	
    public boolean equals(Object object)
	{
        boolean sameSame = false;
        if (object != null && object instanceof AbstractNode)
        {
        	AbstractNode n = (AbstractNode) object;
            sameSame = (n.getData().equals(this.getData()));
        }

        return sameSame;		
	}
}
package fr.utbm.info.gl52.Collection;

import java.lang.ref.WeakReference;

/**
 * 
 */
public abstract class AbstractNode<Dn, N extends AbstractNode<Dn,N>> implements INode<Dn, N> {

	private Dn data;
	
	public AbstractNode()
	{
		data = null;
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
	
}
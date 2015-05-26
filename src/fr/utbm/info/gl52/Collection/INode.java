package fr.utbm.info.gl52.Collection;

/**
 * 
 */
public interface INode<Dn, N extends INode<Dn,N>> {

	public void setData(Dn d);
	public Dn getData();
	
}
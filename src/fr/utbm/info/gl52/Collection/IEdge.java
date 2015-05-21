package fr.utbm.info.gl52.Collection;

/**
 * 
 */
public interface IEdge<D, N extends INode<D,N>> {
	
	/**
	 * To get the user data of the tree node.
	 * 
	 * @return D Data of the user.
	 */
	public D getData();
	
	/**
	 * To set the user data.
	 * @param data Data of the user.
	 */
	public void setData(D data);

}
package fr.utbm.info.gl52.Collection;

/**
 * 
 */
public interface IGraph<D, N extends INode<D,N>> {

	/**
	 * To get the data of the tree node.
	 * 
	 * @return D Data.
	 */
	public D getData();
	
	/**
	 * To set the data.
	 * @param data Data.
	 */
	public void setData(D data);
}
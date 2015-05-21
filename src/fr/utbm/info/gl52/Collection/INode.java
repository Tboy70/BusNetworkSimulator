package fr.utbm.info.gl52.Collection;

/**
 * 
 */
public interface INode<D, N extends INode<D,N>> {

	/**
	 * To get the parent node.
	 * 
	 * @return the parent node.
	 */
	public N getParentNode();
	
	/**
	 * To get the parent node of a particular node.
	 * 
	 * @param node Child of the node which is searched.
	 */
	public void getParentNode(N node);
	
	/**
	 * To set a parent to the node.
	 * 
	 * @param newParent The new parent.
	 */
	public void setParentNode(N newParent);
	
	/**
	 * To get the user data of the tree node.
	 * 
	 * @return D Data of the user.
	 */
	public D getUserData();
	
	/**
	 * To set the user data.
	 * @param data Data of the user.
	 */
	public void setUserData(D data);
	
	/**
	 * To get the number of children.
	 * 
	 * @return Integer Number of children.
	 */
	public int getChildCount();
	
	/**
	 * To get a node child.
	 * 
	 * @param index Integer Index of the child.
	 * 
	 * @return N Node.
	 * 
	 * @throws IndexOutOfBoundsException if index doesn't exist.
	 */
	public N getChildAt(int index) throws IndexOutOfBoundsException;
	
	/**
	 * To set a direct child from index and node.
	 * 
	 * @param index Integer Position of the child.
	 * @param node N Node to set as child.
	 * 
	 * @throws IndexOutOfBoundsException if index doesn't exist.
	 */
	public void setChildAt(int index, N node) throws IndexOutOfBoundsException;
	
	/**
	 * To check if a tree node is the root node.
	 * 
	 * @return True if the node is the root, false otherwise.
	 */
	public boolean isRoot();
	
	/**
	 * To check if a node is a leaf.
	 * 
	 * @return True if a node is a leaf, false otherwise.
	 */
	public boolean isLeaf();
}
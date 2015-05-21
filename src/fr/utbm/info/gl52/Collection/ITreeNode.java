package fr.utbm.info.gl52.Collection;

import java.util.Collection;
import java.util.List;

import fr.utbm.info.gl52.Utils.maths.Rectangle2f;
import fr.utbm.info.gl52.Utils.others.ShapedObject;

public interface ITreeNode<D extends ShapedObject, N extends ITreeNode<D, N>> {
	
	/**
	 * To get the data of the node
	 * 
	 * @return the data.
	 */
	public Collection<D> getData();
	
	/**
	 * To add a data in the node.
	 * 
	 * @param data The data to add.
	 * @return True if the data has been well added.
	 */
	public boolean addData(D data);
	
	/**
	 * To remove a data in the node.
	 * 
	 * @param data The data to remove.
	 * @return True if the data has been well removed.
	 */
	public boolean removeData(D data);
	
	/**
	 * To get the number of datas of a node.
	 * @return the number of data.
	 */
	public int getDataCount();
	
	/**
	 * To get the borders of the area covered by the node.
	 * @return the border of the area covered by the node.
	 */
	Rectangle2f getBorders();
	
	/**
	 * To get the parent node.
	 * 
	 * @return the parent node.
	 */
	public N getParentNode();
	
	/**
	 * To get the children of a node.
	 * @return The list of children.
	 */
	public List<N> getChildren();

	/**
	 * To create a children.
	 */
	public void createChildren();
	
	/**
	 * To remove a children.
	 */
	public void removeChildren();
	
	/**
	 * To check if a node is a leaf.
	 * 
	 * @return True if a node is a leaf, false otherwise.
	 */
	public boolean isLeaf();
	
	/**
	 * To check of the node has no data in it.
	 * @return True if there is no data.
	 */
	public boolean isEmpty();
}
package fr.utbm.info.gl52.Collection;

import java.io.Serializable;
import java.util.*;

import fr.utbm.info.gl52.Utils.maths.Rectangle2f;
import fr.utbm.info.gl52.Utils.others.ShapedObject;

/**
 * 
 */
public interface ITree<D extends ShapedObject, N extends ITreeNode<D, N>> extends Iterable<N>, Serializable {

	/**
	 * To get the borders covered by all the tree nodes.
	 * @return The borders covered by all the tree nodes.
	 */
	Rectangle2f getBorders();
		
	/**
	 * To get the root node of the tree.
	 * 
	 * @return N The root node of the tree.
	 */
	public N getRootNode();
	
	/**
	 * To set the root node of the tree.
	 * 
	 * @param root the root node of the tree.
	 */
	public void setRootNode(N root);

}
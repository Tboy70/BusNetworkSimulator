package fr.utbm.info.gl52.Collection;

import fr.utbm.info.gl52.Utils.maths.Rectangle2f;
import fr.utbm.info.gl52.Utils.others.ShapedObject;
import fr.utbm.info.gl52.Utils.others.SpatialDataStructure;

public abstract class AbstractTree<D extends ShapedObject, N extends ITreeNode<D, N>> implements ITree<D, N>, SpatialDataStructure<D> {

private static final long serialVersionUID = 1L;
	
	/**
	 * Root node of the tree.
	 */
	private N root;

	public AbstractTree() {
		this.root = null;
	}
	
	/**
	 * Other constructor.
	 * 
	 * @param root Root of the tree.
	 */
	public AbstractTree(N root){
		this.root = root;
	}
	
	/****************/
	/*** METHODS ***/
	/****************/
	
	/**
	 * To get the borders.
	 * @return The borders;
	 */
	public Rectangle2f getBorders() {
		N root = getRootNode();
		if (root == null) {
			return new Rectangle2f();
		}
		return root.getBorders();
	}
	
	@Override
	public N getRootNode() {
		return this.root;
	}

	@Override
	public void setRootNode(N root) {
		this.root = root;
	}
	
	public boolean addData(D data) {
		if (data == null) {
			return false;
		}
		N root = getRootNode();
		if (root != null) {
			return root.addData(data);
		}
		return false;
	}

	public boolean removeData(D data) {
		if (data == null) {
			return false;
		}
		N root = getRootNode();
		if (root != null) {
			return root.removeData(data);
		}
		return false;
	}


}
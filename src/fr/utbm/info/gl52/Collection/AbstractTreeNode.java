package fr.utbm.info.gl52.Collection;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import fr.utbm.info.gl52.Utils.maths.Rectangle2f;
import fr.utbm.info.gl52.Utils.others.ShapedObject;

@SuppressWarnings("rawtypes")
public abstract class AbstractTreeNode<D extends ShapedObject, N extends AbstractTreeNode<D, N>> extends AbstractNode implements ITreeNode<D, N> {

	/**
	 * Borders of the area of a node.
	 */
	private Rectangle2f borders;
	/**
	 * Data of a node.
	 */
	private Collection<D> data;
	/**
	 * The parent node of the current one.
	 */
	private transient WeakReference<N> parentNode;
	/**
	 * The tree of the node.
	 */
	private transient WeakReference<ITree<D, N>> tree;
	/** 
	 * Array of the child nodes.
	 */
	protected N[] children;
	
	public AbstractTreeNode() {
		this.parentNode = null;
		this.data = null;
	}
	
	/**
	 *  @param borders Borders of the covered area.
	 */
	public AbstractTreeNode(Rectangle2f borders) {
		this.borders = borders;
	}
		
	/**
	 * {@inheritDoc}
	 */
	public N getParentNode() {
		if (this.parentNode != null) {
			return this.parentNode.get();
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setParentNode(N parent) {
		this.parentNode = new WeakReference<N>(parent);
	}
	
	/**
	 * To get the children nodes.
	 */
	public List<N> getChildren() {
		List<N> nodes = new ArrayList<>(4);
		if (this.children != null) {
			for (int i  = 0; i < this.children.length; ++i) {
				if (this.children[i] != null) {
					nodes.add(this.children[i]);
				}
			}
		}
		return nodes;
	}

	/**
	 * To get the data of the node.
	 */
	public Collection<D> getData() {
		if (this.data == null) {
			return Collections.emptyList();
		}
		return this.data;
	}

	/**
	 * To set the data of the node.
	 * @param data The data to set.
	 */
	public void setData(Collection<D> data) {
		this.data = data;
	}

	/**
	 * To get the borders.
	 */
	public Rectangle2f getBorders(){
		return this.borders;
	}

	/**
	 * To get the tree of the node.
	 * @return The tree of the node.
	 */
	public WeakReference<ITree<D, N>> getTree() {
		return this.tree;
	}

	/**
	 * To set the tree of the node.
	 * @param tree The tree to set.
	 */
	public void setTree(WeakReference<ITree<D, N>> tree) {
		this.tree = tree;
	}
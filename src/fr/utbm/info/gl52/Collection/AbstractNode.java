package fr.utbm.info.gl52.Collection;

import java.lang.ref.WeakReference;

/**
 * 
 */
public abstract class AbstractNode<D, N extends AbstractNode<D,N>> implements INode<D, N> {

	/**
	 * To make the parent node a weak link to his child
	 */
	private transient WeakReference<N> parentNode;

	/**
	 * Constructor of the class.
	 */
	public AbstractNode() {
		this.parentNode = null;
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
	public void setParentNode(N iparent) {
		this.parentNode = new WeakReference<N>(iparent);
	}
}
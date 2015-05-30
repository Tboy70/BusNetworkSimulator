package fr.utbm.info.gl52.Collection.tree;

public abstract class AbstractTree<D, N extends AbstractTreeNode<D,N> > implements ITree<D, N> {

	protected N root;
	protected N[] children;
	public AbstractTree(N root)
	{
		this.root = root;
	}
	
	public AbstractTree()
	{
		this(null);
	}
	
	@Override
	public N getRoot() {
		return this.root;
	}

	@Override
	public void setRoot(N root) {
		this.root = root;
	}

}

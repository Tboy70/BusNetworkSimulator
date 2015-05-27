package fr.utbm.info.gl52.Collection.tree;

public abstract class AbstractTreeNode<D, N extends AbstractTreeNode<D,N> > implements ITreeNode<D, N> {

	protected D data;
	public AbstractTreeNode(D data)
	{
		this.data = data;
	}
	public AbstractTreeNode()
	{
		this.data = null;
	}
	
	@Override
	public D getData() {
		return data;
	}

	@Override
	public void setData(D data) {
		this.data = data;
	}

}

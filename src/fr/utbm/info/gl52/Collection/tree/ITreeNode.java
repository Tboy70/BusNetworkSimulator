package fr.utbm.info.gl52.Collection.tree;

public interface ITreeNode<D, N extends ITreeNode<D,N> > {
	
	public D getData();
	public void setData(D data);
	
	public void setParent(N parent);
	public N getParent();
	
	public N[] getChildren();
	
	public void insert(N child);
	public boolean remove(D data);
	public boolean remove(N child);
	
}

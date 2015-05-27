package fr.utbm.info.gl52.Collection.tree;

public interface ITree<D, N extends ITreeNode<D, N> > {
	
	public N getRoot();
	public void setRoot(N root);
	
	public void insert(D data);
	public boolean remove(D data);
}

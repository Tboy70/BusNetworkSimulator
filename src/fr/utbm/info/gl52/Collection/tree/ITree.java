package fr.utbm.info.gl52.Collection.tree;

import java.awt.Shape;

public interface ITree<D, N extends ITreeNode<D, N> > {
	
	public N getRoot();
	public void setRoot(N root);
	
	public boolean insert(D data);
	public boolean remove(D data);
	public D getData(Shape s);
}

package fr.utbm.info.gl52.Collection.tree;

import java.awt.Rectangle;

import fr.utbm.info.gl52.Collection.SpatialObject;

public class QuadTree<D extends SpatialObject> extends AbstractTree<D, QuadTreeNode<D>> {

	private Rectangle worldSize;
	public QuadTree(Rectangle r)
	{

	}
	@Override
	public void insert(D data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remove(D data) {
		// TODO Auto-generated method stub
		return false;
	}
}

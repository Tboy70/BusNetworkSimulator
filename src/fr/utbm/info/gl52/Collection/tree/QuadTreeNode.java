package fr.utbm.info.gl52.Collection.tree;

import java.awt.Rectangle;
import java.awt.Shape;

import fr.utbm.info.gl52.Collection.SpatialObject;

public class QuadTreeNode<D extends SpatialObject> extends AbstractTreeNode<D, QuadTreeNode<D> > {

	
	private Shape s;
	public QuadTreeNode(Rectangle r)
	{

	}
	
	@Override
	public void setParent(QuadTreeNode<D> parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public QuadTreeNode<D> getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuadTreeNode<D>[] getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(QuadTreeNode<D> child) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remove(D data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(QuadTreeNode<D> child) {
		// TODO Auto-generated method stub
		return false;
	}

}

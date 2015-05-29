package fr.utbm.info.gl52.Collection.tree;

import java.awt.Rectangle;
import java.awt.Shape;

import fr.utbm.info.gl52.Collection.SpatialObject;

public class QuadTree<D extends SpatialObject> extends AbstractTree<D, QuadTreeNode<D>> {

	private Rectangle worldSize;
	private QuadTreeNode<D> root;

	public QuadTree(Rectangle r) {
		this.worldSize = r;
	}

	@Override
	public void insert(D data) {

		if (!checkBounds(data.getShape())) {
			
			//throw new RuntimeException("can't insert a data that is outside the world : object's position ("+data+")");
		}
		if (this.root == null) {
			this.root = new QuadTreeNode<>(this.worldSize);
		}
		this.root.insert(data);

		// If data is not set, set the data to this node.
		// If a data is already set, create 4 childrens, re allocate the node's
		// current data to the new node
		// Then allocate the given data.
	}

	private boolean checkBounds(Shape s) {
		return this.worldSize.contains(s.getBounds());
	}

	@Override
	public boolean remove(D data) {
		if (this.root == null)
			throw new RuntimeException("QuadTree not initialized");
		return this.root.remove(data);
	}

	@Override
	public D getData(Shape s) {
		if(this.root == null){
			throw new RuntimeException("QuadTree not initialized");
		}
		
		return null;
	}
}

package fr.utbm.info.gl52.Collection;

import java.util.*;

import fr.utbm.info.gl52.Utils.maths.Point2f;
import fr.utbm.info.gl52.Utils.maths.Rectangle2f;
import fr.utbm.info.gl52.Utils.maths.Shape2f;
import fr.utbm.info.gl52.Utils.others.ShapedObject;

/**
 * 
 */
public class QuadTreeNode<D extends ShapedObject> extends AbstractTreeNode<D, QuadTreeNode<D>> {

	private static final int NB_OBJECTS_PER_NODE = 1;

	/*********************/
	/*** CONSTRUCTORS ***/
	/*********************/
	public  QuadTreeNode(Rectangle2f borders) {
		super(borders);
	}


	/***************/
	/*** METHODS ***/
	/***************/
	
	/**
	 * To add a data in a node.
	 */
	public boolean addData(D data) {
		if (isLeaf()) {
			if (getDataCount() >= NB_OBJECTS_PER_NODE ) {
				createChildren();
				Iterator<D> iterator = getData().iterator();
				while (iterator.hasNext()) {
					D existingData = iterator.next();
					if (addInChildWhenPossible(existingData)) {
						iterator.remove();
					}
				}
				if (!addInChildWhenPossible(data)) {
					return this.getData().add(data);
				}
			} else {
				return this.getData().add(data);
			}
		} else if (!addInChildWhenPossible(data)) {
			return getData().add(data);
		} 
		return true;
	}
	
	private boolean addInChildWhenPossible(D data) {
		Shape2f<?> dataShape = data.getShape();
		QuadTreeNode<D> selectedChild = null;
		for (QuadTreeNode<D> child : this.children) {
			if (child.getBorders().intersects(dataShape)) {
				if (selectedChild != null) {
					// The object is intersecting two or more children
					return false;
				}
				selectedChild = child;
			}
		}
		if (selectedChild != null) {
			return selectedChild.addData(data);
		}
		// No intersection between the children and the data
		return false;
	}

	@Override
	public boolean removeData(D data) {
		boolean removed = true;
		if (isLeaf()) {
			removed = this.getData().remove(data);
		} else {
			if (!removeFromChildWhenPossible(data)) {
				removed = this.getData().remove(data);
			}
		}
		if (removed) {
			removeChildrenIfEmpty();
		}
		return removed;
	}
	
	private boolean removeFromChildWhenPossible(D data) {
		Shape2f<?> dataShape = data.getShape();
		QuadTreeNode<D> selectedChild = null;
		for (QuadTreeNode<D> child : this.children) {
			if (child.getBorders().intersects(dataShape)) {
				if (selectedChild != null) {
					// The object is intersecting two or more children
					return false;
				}
				selectedChild = child;
			}
		}
		if (selectedChild != null) {
			return selectedChild.removeData(data);
		}
		// No intersection between the children and the data
		return false;
	}
	
	private boolean removeChildrenIfEmpty() {
		if (this.children != null) {
			for (int i = 0; i < this.children.length; ++i) {
				if (this.children[i] != null
						&& !this.children[i].isEmpty()) {
					return false;
				}
			}
			for (int i = 0; i < this.children.length; ++i) {
				if (this.children[i] != null) {
					assert (this.children[i].getDataCount() == 0);
					this.children[i].setParentNode(null);
					this.children[i] = null;
				}
			}
			this.children = null;
			return true;
		}
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void createChildren() {
		if (this.children == null) {
			this.children = new QuadTreeNode[4];
		}
		if (this.children[0] == null) {
			Rectangle2f bounds = getBorders();
			assert (bounds != null);
			Point2f lower = bounds.getLower();
			Point2f center = bounds.getCenter();
			this.children[0] = new QuadTreeNode(new Rectangle2f(lower, center));
			this.children[0].setParentNode(this);
		}
		if (this.children[1] == null) {
			Rectangle2f bounds = getBorders();
			assert (bounds != null);
			Point2f lower = bounds.getLower();
			Point2f upper = bounds.getUpper();
			Point2f center = bounds.getCenter();
			this.children[1] = new QuadTreeNode(
					new Rectangle2f(
							lower.getX(), center.getY(),
							center.getX(), upper.getY()));
			this.children[1].setParentNode(this);
		}
		if (this.children[2] == null) {
			Rectangle2f bounds = getBorders();
			assert (bounds != null);
			Point2f lower = bounds.getLower();
			Point2f upper = bounds.getUpper();
			Point2f center = bounds.getCenter();
			this.children[2] = new QuadTreeNode(
					new Rectangle2f(
							center.getX(), lower.getY(),
							upper.getX(), center.getY()));
			this.children[2].setParentNode(this);
		}
		if (this.children[3] == null) {
			Rectangle2f bounds = getBorders();
			assert (bounds != null);
			Point2f upper = bounds.getUpper();
			Point2f center = bounds.getCenter();
			this.children[3] = new QuadTreeNode(new Rectangle2f(center, upper));
			this.children[3].setParentNode(this);
		}
		
	}

	@Override
	public void removeChildren() {
		if (this.children != null) {
			for (int i = 0; i < this.children.length; ++i) {
				if (this.children[i] != null) {
					this.children[i].setParentNode(null);
					this.children[i] = null;
				}
			}
			this.children = null;
		}
	}

	@Override
	public boolean isLeaf() {
		return this.children == null;
	}

	@Override
	public boolean isEmpty() {
		return isLeaf() && getDataCount() == 0;
	}

	@Override
	public int getDataCount() {
		if (this.getData() == null) {
			return 0;
		} else {
			return this.getData().size();
		}
	}
}
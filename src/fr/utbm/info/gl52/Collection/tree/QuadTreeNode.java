package fr.utbm.info.gl52.Collection.tree;

import java.awt.Rectangle;
import java.awt.Shape;

import fr.utbm.info.gl52.Collection.SpatialObject;

public class QuadTreeNode<D extends SpatialObject> extends AbstractTreeNode<D, QuadTreeNode<D>> {

	private final static int NW = 0;
	private final static int NE = 1;
	private final static int SW = 2;
	private final static int SE = 3;

	public static double delta = 1;
	private QuadTreeNode<D> parent;
	private Shape s;
	private QuadTreeNode<D>[] childrens;

	public QuadTreeNode(Shape r) {
		super();
		this.s = r;
		this.childrens = null;
	}

	public QuadTreeNode(Shape r, D data) {
		super(data);
		this.s = r;
		this.childrens = null;
	}

	@Override
	public void setParent(QuadTreeNode<D> parent) {
		this.parent = parent;
	}

	@Override
	public QuadTreeNode<D> getParent() {
		return this.parent;
	}

	@Override
	public QuadTreeNode<D>[] getChildren() {
		return this.childrens;
	}

	@Override
	public void insert(QuadTreeNode<D> child) {
		// Get the child's shape to determine where to put it.
throw new UnsupportedOperationException("ca arrive");
	}

	public boolean insert(D data) {
		// Get the quadrant in which the data will be inserted
		int quadrant = this.getQuandrant(this.s.getBounds(), data.getShape().getBounds());

		if (quadrant == -1) {
			// It's a special case where the data's position
			// is exactly on the Node's bounds.
			// Thus, it's not possible to determine
			// the quadrant in which to insert the Data
			this.data = data;
			return true;
		}
		if (this.childrens != null) {
			// get the right child in whcich to insert the data
			 return this.childrens[quadrant].insert(data);
			
		}
		if (this.getData() != null) {
			if(isSimilarData(data)){
				return false;
			}
			this.createChildrens();
			this.insert(this.data);
			this.data = null;
			 return this.childrens[quadrant].insert(data);
			
		}
		//There is no data and no need to create childrens, insert the data here
		this.data = data;
		return true;
	}

	public D getData(Shape s) {
		int quadrant = this.getQuandrant(this.s.getBounds(), s.getBounds());
		if (quadrant == -1 || this.childrens == null) {
			// Special case
			return this.data;
		}
		return this.childrens[quadrant].getData(s);
	}

	private boolean isSimilarData(D data) {
		if (this.data == null || data == null) {
			throw new RuntimeException("Data are null");
		}
		Rectangle r = new Rectangle(this.data.getShape().getBounds());
		r.x = (int) (r.x - this.delta);
		r.y = (int) (r.y + this.delta);
		r.width = (int) (r.width + this.delta);
		r.height = (int) (r.height + this.delta);

		if (r.contains(data.getShape().getBounds()))
			return true;

		return false;
	}

	private void createChildrens() {
		Rectangle p = this.s.getBounds();
		int h = p.height / 2;
		int w = p.width / 2;

		// NW
		Rectangle r = new Rectangle(p.x, p.y, w, h);
		this.childrens[NW] = new QuadTreeNode<>(r);
		// NE
		r = new Rectangle(p.x + w, p.y, w, h);
		this.childrens[NE] = new QuadTreeNode<>(r);
		// SW
		r = new Rectangle(p.x, p.y + h, w, h);
		this.childrens[SW] = new QuadTreeNode<>(r);
		// SE
		r = new Rectangle(p.x + w, p.y + h, w, h);
		this.childrens[SE] = new QuadTreeNode<>(r);

	}

	private static int getQuandrant(Rectangle nodeBounds, Rectangle dataBounds) {
		int mX = nodeBounds.x / 2 + nodeBounds.width;
		int mY = nodeBounds.y / 2 + nodeBounds.height;
		// TODO if dataBounds == mX || mY, it a special case;

		if (dataBounds.x == mX || dataBounds.y == mY) {
			// It's a special case
			return -1;
		}
		if (dataBounds.x < mX) {
			return dataBounds.y < mY ? NW : SW;
		}
		return dataBounds.y < mY ? NE : SE;
	}

	@Override
	public boolean remove(D data) {
		int quadrant = this.getQuandrant(this.s.getBounds(), data.getShape().getBounds());

		if (quadrant == -1 || this.childrens == null) {
			boolean result = false;
			if (this.data != null) {
				this.data = null;
				result = true;
			}
			this.parent.checkChildrens();
			return result;
		}
		return this.childrens[quadrant].remove(data);

	}

	private void checkChildrens() {
		if (this.data != null) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (this.childrens[i].childrens != null || this.childrens[i].data != null) {

			}
		}
	}

	@Override
	public boolean remove(QuadTreeNode<D> child) {
		throw new UnsupportedOperationException("ca arrive");
		//return false;
	}

}

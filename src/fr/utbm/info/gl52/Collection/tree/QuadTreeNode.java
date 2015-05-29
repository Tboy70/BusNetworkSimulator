package fr.utbm.info.gl52.Collection.tree;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.List;

import fr.utbm.info.gl52.Collection.SpatialObject;

public class QuadTreeNode<D extends SpatialObject> extends AbstractTreeNode<D, QuadTreeNode<D>> {

	private final static int NW = 0;
	private final static int NE = 1;
	private final static int SW = 2;
	private final static int SE = 3;

	public static double delta = 0.0000000018627D;// java.lang.Double.MAX_VALUE;
	private QuadTreeNode<D> parent;
	private Shape s;
	private List<QuadTreeNode<D>> childrens;

	public QuadTreeNode(Shape r) {
		super();
		this.s = r;
		this.childrens = new ArrayList<>(4);
	}

	public QuadTreeNode(Shape r, D data) {
		super(data);
		this.s = r;
		this.childrens = new ArrayList<>(4);
	}

	@Override
	public void setParent(QuadTreeNode<D> parent) {
		this.parent = parent;
	}

	@Override
	public QuadTreeNode<D> getParent() {
		return this.parent;
	}

	@SuppressWarnings("unchecked")
	@Override
	public QuadTreeNode<D>[] getChildren() {
		return (QuadTreeNode<D>[]) this.childrens.toArray();
	}

	@Override
	public void insert(QuadTreeNode<D> child) {
		// Get the child's shape to determine where to put it.
		throw new UnsupportedOperationException("ca arrive");
	}

	public boolean insert(D d) {
		// double x = data.getShape().getBounds2D().getX();
		// double y = data.getShape().getBounds2D().getY();
		// System.out.println("Insert " + data + " (" + x + ", " + y + ")");
		// Get the quadrant in which the data will be inserted
		int quadrant = QuadTreeNode.getQuandrant(this.s.getBounds2D(), d.getShape().getBounds2D());
		// System.out.println("quadrant :" + quadrant);
		if (quadrant == -1) {
			// System.out.println("Secial Case");
			// It's a special case where the data's position
			// is exactly on the Node's bounds.
			// Thus, it's not possible to determine
			// the quadrant in which to insert the Data
			this.data = d;
			return true;
		}
		if (!this.childrens.isEmpty()) {
			// System.out.println("Node has children : inserting into them");
			// get the right child in which to insert the data
			return this.childrens.get(quadrant).insert(d);
		}
		if (this.data != null) {
			// System.out.println("Data already set");
			if (isSimilarData(d)) {
				return false;
			}
			// System.out.println("creating children");
			this.createChildrens();
			// System.out.println("inserting the node's data into a child node");
			this.insert(this.data);
			this.data = null;
			// System.out.println("coucou");
			return this.childrens.get(quadrant).insert(d);

		}
		// There is no data and no need to create childrens, insert the data
		// here
		this.data = d;
		return true;
	}

	public D getData(Shape d) {
		int quadrant = QuadTreeNode.getQuandrant(this.s.getBounds(), d.getBounds());
		if (quadrant == -1 || this.childrens.isEmpty()) {
			// Special case
			return this.data;
		}
		return this.childrens.get(quadrant).getData(d);
	}

	private boolean isSimilarData(D d) {
		if (this.data == null || d == null) {
			throw new RuntimeException("Data are null");
		}
		Rectangle2D r = this.s.getBounds2D();
		if (r.getWidth() <= delta && r.getHeight() <= delta) {
			// System.out.println("similar data");
			return true;
		}
		return false;
	}

	private void createChildrens() {
		Rectangle2D.Double p = (Double) this.s.getBounds2D();
		double h = p.height / 2;
		double w = p.width / 2;

		// NW
		Rectangle2D.Double r = new Rectangle2D.Double(p.x, p.y, w, h);
		this.childrens.add(NW, new QuadTreeNode<D>(r));
		// NE
		r = new Rectangle2D.Double(p.x + w, p.y, w, h);
		this.childrens.add(NE, new QuadTreeNode<D>(r));
		// SW
		r = new Rectangle2D.Double(p.x, p.y + h, w, h);
		this.childrens.add(SW, new QuadTreeNode<D>(r));
		// SE
		r = new Rectangle2D.Double(p.x + w, p.y + h, w, h);
		this.childrens.add(SE, new QuadTreeNode<D>(r));
	}

	private static int getQuandrant(Rectangle2D node, Rectangle2D data) {
		double mX = node.getX() + node.getWidth() / 2;
		double mY = node.getY() + node.getHeight() / 2;
		// TODO if dataBounds == mX || mY, it a special case;

		if (data.getX() == mX || data.getY() == mY) {
			// It's a special case
			return -1;
		}
		if (data.getX() < mX) {
			return data.getY() < mY ? NW : SW;
		}
		return data.getY() < mY ? NE : SE;
	}

	@Override
	public boolean remove(D d) {
		int quadrant = QuadTreeNode.getQuandrant(this.s.getBounds(), d.getShape().getBounds());

		if (quadrant == -1 || this.childrens.isEmpty()) {
			boolean result = false;
			if (this.data != null) {
				this.data = null;
				result = true;
			}
			this.parent.checkChildrens();
			return result;
		}
		return this.childrens.get(quadrant).remove(d);

	}

	private void checkChildrens() {
		if (this.data != null) {
			return;
		}
		boolean[] childrenHaveData = new boolean[4];
		int childrenDataCount = 0;
		for (int i = 0; i < 4; i++) {
			if (this.childrens.get(i).data != null) {
				childrenHaveData[i] = true;
				childrenDataCount++;
			} else {
				childrenHaveData[i] = false;
			}
		}

		switch (childrenDataCount) {
		case 0:
			this.childrens.clear();
			break;
		case 1:
			for (int i = 0; i < 4; i++) {
				if (childrenHaveData[i]) {
					this.data = this.childrens.get(i).data;
					this.childrens.clear();
					break;
				}
			}
			break;
		default:
			break;
		}
	}

	@Override
	public boolean remove(QuadTreeNode<D> child) {
		throw new UnsupportedOperationException("ca arrive");
		// return false;
	}

}

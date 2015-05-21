package fr.utbm.info.gl52.Collection;

import java.util.*;

import fr.utbm.info.gl52.Utils.maths.Rectangle2f;
import fr.utbm.info.gl52.Utils.maths.Shape2f;
import fr.utbm.info.gl52.Utils.others.ShapedObject;

@SuppressWarnings("rawtypes")
public class QuadTree<D extends ShapedObject> extends AbstractTree {

	private static final long serialVersionUID = 1L;

	public QuadTree() {
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initialize(Rectangle2f worldSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle2f getBounds() {
		ITreeNode root = getRootNode();
		if (root == null) {
			return new Rectangle2f();
		}
		return root.getBorders();
	}

	@Override
	public Iterator<D> dataIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable getData() {
		return new Iterable<D>() {
			@SuppressWarnings("unchecked")
			@Override
			public Iterator<D> iterator() {
				return dataIterator();
			}
		};
	}

	@Override
	public Iterator dataIterator(Shape2f bounds) {
		// TODO Auto-generated method stub
		return null;
	}
}
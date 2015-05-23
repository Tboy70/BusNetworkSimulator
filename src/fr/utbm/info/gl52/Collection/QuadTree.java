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

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}
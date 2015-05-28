package fr.utbm.info.gl52.Utils.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import fr.utbm.info.gl52.Collection.ITreeNode;
import fr.utbm.info.gl52.Utils.others.ShapedObject;

public class DepthFirstObjectTreeIterator<D extends ShapedObject, N extends ITreeNode<D, N>> implements Iterator<D> {

		private final DepthFirstTreeIterator<N> iterator;
		private final LinkedList<D> nexts = new LinkedList<>();
		
		/**
		 * @param root - the root node.
		 */
		public DepthFirstObjectTreeIterator(N root) {
			this.iterator = new DepthFirstTreeIterator<>(root);
			searchNext();
		}
		
		private void searchNext() {
			if (this.nexts.isEmpty()) {
				while (this.iterator.hasNext() && this.nexts.isEmpty()) {
					N n = this.iterator.next();
					this.nexts.addAll(n.getData());
				}
			}
		}
		
		@Override
		public boolean hasNext() {
			return !this.nexts.isEmpty();
		}

		@Override
		public D next() {
			if (this.nexts.isEmpty()) {
				throw new NoSuchElementException();
			}
			D n = this.nexts.removeFirst();;
			searchNext();
			return n;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
}

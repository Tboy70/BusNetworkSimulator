package fr.utbm.info.gl52.Utils.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

import fr.utbm.info.gl52.Collection.ITreeNode;

public class DepthFirstTreeIterator<N extends ITreeNode<?, N>> implements Iterator<N> {

private final Stack<N> stack = new Stack<>();
	
	/**
	 * @param root - the root node.
	 */
	public DepthFirstTreeIterator(N root) {
		if (root != null) {
			this.stack.push(root);
		}
	}
	
	public boolean hasNext() {
		return !this.stack.isEmpty();
	}

	public N next() {
		if (this.stack.isEmpty()) {
			throw new NoSuchElementException();
		}
		N n = this.stack.pop();
		for (N c : n.getChildren()) {
			this.stack.push(c);
		}
		return n;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}

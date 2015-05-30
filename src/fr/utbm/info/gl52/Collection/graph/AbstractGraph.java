package fr.utbm.info.gl52.Collection.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * 
 */
public abstract class AbstractGraph<N extends INode<?>, E extends IEdge<?>>  implements IGraph<N, E> {

	
	protected List<E> listEdge;
	
	protected List<N> listNode;
	
	public AbstractGraph()
	{
		this.listEdge = new ArrayList<>();
		this.listNode = new ArrayList<>();
	}
	
	public void addEdge(E e)
	{
		this.listEdge.add(e);
		this.listNode.add((N) e.getNodeA());
		this.listNode.add((N) e.getNodeB());
	}
	
	public boolean removeEdge(E e)
	{
		e.getNodeA().removeEdge(e);
		if (e.getNodeA().getNumberEdge() == 0)
			this.listNode.remove(e.getNodeA());
		e.getNodeB().removeEdge(e);
		if (e.getNodeB().getNumberEdge() == 0)
			this.listNode.remove(e.getNodeB());
		return this.listEdge.remove(e);
	}

	@Override
	public void addNode(N n) {
		this.listNode.add(n);
		this.listEdge.addAll((Collection<? extends E>) n.getEdges());
	}

	@Override
	public boolean removeNode(N n) {
		if(n.getNumberEdge() > 0)
			this.listEdge.removeAll(n.getEdges());
		return this.listNode.remove(n);
	}

	@Override
	public void add(E e){
		this.listEdge.add(e);
	}
	
	@Override
	public void add(N n){
		this.listNode.add(n);
	}
	
	@Override
	public Iterator<IEdge<?>> iterator() {
		return new fifoIterator();
	}
	
	private class fifoIterator implements Iterator<IEdge<?>>
	{
		private int i = 0;
		
		public fifoIterator() {
		}

		@Override
		public boolean hasNext() {
			return (AbstractGraph.this.listEdge.size()>this.i);
		}

		@Override
		public IEdge<?> next() {
			IEdge<?> e = AbstractGraph.this.listEdge.get(this.i);
			++this.i;
			return e;
		}

		@Override
		public void remove() {
			AbstractGraph.this.listEdge.remove(this.i);
			--this.i;
		}	
	}
	
	@Override
	public String toString() {
		return "Graph [listEdge=" + this.listEdge + ", listNode=" + this.listNode + "]";
	}

}
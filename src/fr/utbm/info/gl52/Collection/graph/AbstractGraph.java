package fr.utbm.info.gl52.Collection.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 
 */
public abstract class AbstractGraph<N extends AbstractNode<?>, E extends AbstractEdge<?>>  implements IGraph<N, E> {

	
	protected List<E> listEdge;
	
	protected List<N> listNode;
	
	public AbstractGraph()
	{
		listEdge = new ArrayList<E>();
		listNode = new ArrayList<N>();
	}
	
	public void addEdge(E e)
	{
		//if (!listEdge.contains(e))
			listEdge.add(e);
		//if (!listNode.contains(e.getNodeA()))
			listNode.add((N) e.getNodeA());
		//if (!listNode.contains(e.getNodeB()))
			listNode.add((N) e.getNodeB());
	}
	
	public boolean removeEdge(E e)
	{
		e.getNodeA().removeEdge(e);
		if (e.getNodeA().getNumberEdge() == 0)
			listNode.remove(e.getNodeA());
		e.getNodeB().removeEdge(e);
		if (e.getNodeB().getNumberEdge() == 0)
			listNode.remove(e.getNodeB());
		return listEdge.remove(e);
	}
	
	@Override
	public Iterator<IEdge> iterator() {
		return new fifoIterator();
	}
	
	private class fifoIterator implements Iterator<IEdge>
	{
		private int i = 0;
		@Override
		public boolean hasNext() {
			return (listEdge.size()>i);
		}

		@Override
		public IEdge next() {
			IEdge e = listEdge.get(i);
			++i;
			return e;
		}

		@Override
		public void remove() {
			listEdge.remove(i);
			--i;
		}	
	}
	
	@Override
	public String toString() {
		return "Graph [listEdge=" + listEdge + ", listNode=" + listNode + "]";
	}

}
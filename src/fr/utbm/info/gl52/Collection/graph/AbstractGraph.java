package fr.utbm.info.gl52.Collection.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 
 */
//public interface IGraph<Dn, De, N extends INode<Dn,N>, E extends IEdge<De, E>> {
public abstract class AbstractGraph<N extends AbstractNode<?>, E extends AbstractEdge<?>>  implements IGraph<N, E> {

	private List<E> listEdge;
	private List<E> listNode;
	public AbstractGraph()
	{
		listEdge = new ArrayList<E>();
		listNode = new ArrayList<E>();
	}
	public void addEdge(E e)
	{
		if (!listEdge.contains(e))
			listEdge.add(e);
		if (!listNode.contains(e.getNodeA()))
			listNode.add((E) e.getNodeA());
		if (!listNode.contains(e.getNodeB()))
			listNode.add((E) e.getNodeB());
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

}
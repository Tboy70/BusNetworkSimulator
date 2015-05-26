package fr.utbm.info.gl52.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 
 */
//public interface IGraph<Dn, De, N extends INode<Dn,N>, E extends IEdge<De, E>> {
public abstract class AbstractGraph<N extends AbstractNode<?, N>, E extends AbstractEdge<?, E> >  implements IGraph<N, E> {

	private List<E> listEdge;
	public AbstractGraph()
	{
		listEdge = new ArrayList<E>();
	}
	public void addEdge(E e)
	{
		listEdge.add(e);
	}
	public boolean removeEdge(E e)
	{
		return listEdge.remove(e);
	}
	@Override
	public Iterator<E> iterator() {
		return new fifoIterator();
	}
	
	private class fifoIterator implements Iterator<E>
	{
		private int i = 0;
		@Override
		public boolean hasNext() {
			return (listEdge.size()>i);
		}

		@Override
		public E next() {
			E e = listEdge.get(i);
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
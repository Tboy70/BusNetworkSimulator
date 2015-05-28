package fr.utbm.info.gl52.Collection;


/**
 * 
 */
public abstract class AbstractGraph<D, N extends AbstractNode<D,N>> implements IGraph<D, N> {

    /**
     * 
     */
    public AbstractGraph() {
    }

    /**
     * @param Edge e
     */
    public void addEdge(IEdge<D, N> e) {
        // TODO implement here
    }

    /**
     * @param Edge e
     */
    public void removeEdge(IEdge<D, N> e) {
        // TODO implement here
    }

}
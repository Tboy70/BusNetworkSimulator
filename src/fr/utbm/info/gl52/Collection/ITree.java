package fr.utbm.info.gl52.Collection;


/**
 * 
 */
public interface ITree<D, N extends ITreeNode<D,N>> extends IGraph<D, N> {

    /**
     * @param Node n
     */
    public void addNode(Node n);

}
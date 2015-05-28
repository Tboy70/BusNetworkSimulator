package fr.utbm.info.gl52.Collection;

import java.util.Collection;


/**
 * 
 */
public interface ITree<D, N extends ITreeNode<D,N>> extends IGraph<D, N>, Collection {

    /**
     * @param Node n
     */
    public void addNode(Node n);

}
package fr.utbm.info.gl52.Collection;

import java.util.*;

/**
 * @param <Graph>
 * 
 */
public interface IGraphFactory<D, N> {

    /**
     * @return
     */
    public N create();

}
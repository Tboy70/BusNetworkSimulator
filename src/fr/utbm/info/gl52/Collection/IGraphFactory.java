package fr.utbm.info.gl52.Collection;

import java.util.*;

/**
 * @param <Graph>
 * 
 */
public interface IGraphFactory<Graph> {

    /**
     * @return
     */
    public Graph create();

}
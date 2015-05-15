package fr.utbm.info.gl52.Event;

import java.util.*;

/**
 * 
 */
public interface IFilter {

    /**
     * @param Event e 
     * @return
     */
    public boolean apply(Event e);

}
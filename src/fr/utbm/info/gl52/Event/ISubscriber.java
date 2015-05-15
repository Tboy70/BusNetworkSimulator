package fr.utbm.info.gl52.Event;

import java.util.*;

/**
 * 
 */
public interface ISubscriber {

    /**
     * @param Event e
     */
    public void inform (Event e);

}
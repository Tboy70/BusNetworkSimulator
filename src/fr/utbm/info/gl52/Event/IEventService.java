package fr.utbm.info.gl52.Event;

/**
 * 
 */
public interface IEventService {

    /**
     * @param Event e
     */
    public void publish(Event e);

    /**
     * @param Event e 
     * @param Subscriber s
     */
    public void subscribe(Event e, Subscriber s);

    /**
     * @param Event e 
     * @param Subscriber s
     */
    public void unsubscribe(Event e, Subscriber s);

}
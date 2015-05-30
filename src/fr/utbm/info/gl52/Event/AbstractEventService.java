package fr.utbm.info.gl52.Event;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public abstract class AbstractEventService implements IEventService {

    /**
     * 
     */
	private List<EventTuple> listTuples;
    protected AbstractEventService() {
    	this.listTuples = new ArrayList<>();
    }
    
    public void publish(IEvent e)
    {
    	for (EventTuple eTuple : this.listTuples)
    	{
    		if (eTuple.eventType == e.getClass())
    		{
    			if (eTuple.filter == null)
    			{
    				eTuple.subscriber.inform(e);
    			}
    			else if (eTuple.filter.apply(e))
    			{
    				eTuple.subscriber.inform(e);
    			}
    		}
    	}
    }

    /**
     * @param Event e 
     * @param Subscriber s
     */
    public void subscribe(Class<? extends IEvent> eT, IFilter f, ISubscriber s)
    {
    	this.listTuples.add(new EventTuple(eT, f, s));
    }

    /**
     * @param Event e 
     * @param Subscriber s
     */
    public void unsubscribe(Class<? extends IEvent> eT, IFilter f, ISubscriber s)
    {
    	this.listTuples.remove(new EventTuple(eT, f, s));
    }








}
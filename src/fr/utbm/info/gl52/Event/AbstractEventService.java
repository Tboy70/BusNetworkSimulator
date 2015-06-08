package fr.utbm.info.gl52.Event;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 */
public abstract class AbstractEventService implements IEventService, Runnable {

    /**
     * 
     */
	private List<EventTuple> listTuples;
	
	private List<IEvent> listEvent;
	
    protected AbstractEventService() {
    	this.listTuples = Collections.synchronizedList(new ArrayList<EventTuple>());
    	this.listEvent = Collections.synchronizedList(new LinkedList<IEvent>());
    }
    
	@Override
	public void run() {
		while(true){
			if(this.listEvent.size() > 0)
				this.launch(this.listEvent.remove(0));
		}
	}
    
    private synchronized void launch(IEvent e) {			
    	for (EventTuple eTuple : this.listTuples)
    	{
    		if (eTuple.eventType == e.getClass())
    		{
    			if (eTuple.filter == null)
    			{
    				this.lunchThread(eTuple, e);
    				break;
    			}
    			else if (eTuple.filter.apply(e))
    			{
    				this.lunchThread(eTuple, e);
    				break;
    			}
    		}
    	}
	}
    
    private void lunchThread(final EventTuple eTuple, final IEvent e){
    	Runnable run = new Runnable() {
			@Override
			public void run() {
				eTuple.subscriber.inform(e);
			}
		};
		Thread t = new Thread(run);
		t.start();
    }

	public synchronized void publish(IEvent e)
    {
    	this.listEvent.add(e);	
    }

    /**
     * @param Event e 
     * @param Subscriber s
     */
    public synchronized void subscribe(Class<? extends IEvent> eT, IFilter f, ISubscriber s)
    {
    	this.listTuples.add(new EventTuple(eT, f, s));
    }

    /**
     * @param Event e 
     * @param Subscriber s
     */
    public synchronized void unsubscribe(Class<? extends IEvent> eT, IFilter f, ISubscriber s)
    {
    	this.listTuples.remove(new EventTuple(eT, f, s));
    }

}
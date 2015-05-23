package fr.utbm.info.gl52.Event.tests;

import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Event.IEvent;
import fr.utbm.info.gl52.Event.ISubscriber;

public class SubscriberHello implements ISubscriber {

	public SubscriberHello()
	{
	}
	public void inform(IEvent e) {
		// TODO Auto-generated method stub
		if (e.getClass() == EventHello.class)
			System.out.println("Event receptionné : "+ ((EventHello) e).text);
	}

}

package fr.utbm.info.gl52.Event.tests;

import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Event.ISubscriber;

public class EventTestLaunch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PublisherHello p = new PublisherHello();
		ISubscriber s = new SubscriberHello();

		EventService.getInstance().subscribe(EventHello.class, new FilterHello(), s);
		EventService.getInstance().subscribe(EventHello.class, new FilterBite(), s);		
		p.test();
	}

}

package fr.utbm.info.gl52.Event.tests;

import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Event.IPublisher;

public class PublisherHello implements IPublisher {
	public PublisherHello()
	{

	}
	public void test()
	{
		EventService.getInstance().publish(new EventHello("test !"));
	}
}

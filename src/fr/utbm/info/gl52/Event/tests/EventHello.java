package fr.utbm.info.gl52.Event.tests;

import fr.utbm.info.gl52.Event.IEvent;

public class EventHello implements IEvent {
	public String text;
	public EventHello(String text)
	{
		this.text = text;
	}
}

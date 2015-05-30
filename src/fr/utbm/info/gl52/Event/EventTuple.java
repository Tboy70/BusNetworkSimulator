package fr.utbm.info.gl52.Event;

public class EventTuple {
	public Class<? extends IEvent> eventType;
	public IFilter filter;
	public ISubscriber subscriber;
	public EventTuple(Class<? extends IEvent> eT, IFilter f, ISubscriber s)
	{
		this.eventType = eT;
		this.filter = f;
		this.subscriber = s;
	}
}

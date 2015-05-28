package fr.utbm.info.gl52.Event;

public class EventTuple {
	public Class<? extends IEvent> eventType;
	public IFilter filter;
	public ISubscriber subscriber;
	public EventTuple(Class<? extends IEvent> eT, IFilter f, ISubscriber s)
	{
		eventType = eT;
		filter = f;
		subscriber = s;
	}
}

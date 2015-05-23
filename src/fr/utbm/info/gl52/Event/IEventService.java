package fr.utbm.info.gl52.Event;

public interface IEventService {
    public void publish(IEvent e);
    public void subscribe(Class<? extends IEvent> eT, IFilter f, ISubscriber s);
    public void unsubscribe(Class<? extends IEvent> eT, IFilter f, ISubscriber s);
}
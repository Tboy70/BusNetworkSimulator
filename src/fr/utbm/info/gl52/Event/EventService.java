package fr.utbm.info.gl52.Event;


/**
 * 
 */
public class EventService extends AbstractEventService {
	static private EventService singleton = null;
	private EventService() {
		super();
	}
	static public EventService getInstance() {
		if (singleton == null)
			singleton = new EventService();
		return singleton;
	}
}
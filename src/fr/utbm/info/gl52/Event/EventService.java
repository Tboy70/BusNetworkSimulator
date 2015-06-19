package fr.utbm.info.gl52.Event;


/**
 * 
 */
public class EventService extends AbstractEventService {
	static private EventService singleton = null;
	
	static private Thread tEvent;
	
	private EventService() {
		super();
	}
	static public EventService getInstance() {
		if (singleton == null){
			singleton = new EventService();
			tEvent = new Thread(singleton);
			tEvent.start();
		}
		return singleton;
	}
}

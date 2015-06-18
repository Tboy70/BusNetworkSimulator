package fr.utbm.info.gl52.Event;

import fr.utbm.info.gl52.Middle.Itineraire;
import fr.utbm.info.gl52.Middle.Segment;

public class AddItinerary implements IEvent {

	public Itineraire it = null;
	public Segment<?> seg = null;
	
	public AddItinerary(Itineraire i, Segment<?> s)
	{
		this.it = i;
		this.seg = s;
	}	
}
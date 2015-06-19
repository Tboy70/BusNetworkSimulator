package fr.utbm.info.gl52.Event;

import fr.utbm.info.gl52.Middle.Itineraire;

public class DisplayItEvent implements IEvent {
	public Itineraire message;
	public DisplayItEvent(Itineraire l)
	{
		this.message = l;
	}
}

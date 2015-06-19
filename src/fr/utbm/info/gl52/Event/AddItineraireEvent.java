package fr.utbm.info.gl52.Event;

import fr.utbm.info.gl52.Middle.Itineraire;

public class AddItineraireEvent implements IEvent {

	public Itineraire it = null;
	
	public AddItineraireEvent(Itineraire i)
	{
		this.it = i;
	}	
}
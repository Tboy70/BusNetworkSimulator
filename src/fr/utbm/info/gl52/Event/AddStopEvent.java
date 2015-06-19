package fr.utbm.info.gl52.Event;

import fr.utbm.info.gl52.Graphics.Itinerary.GraphicStop;

public class AddStopEvent implements IEvent {
	public GraphicStop message;
	public AddStopEvent(GraphicStop l)
	{
		this.message = l;
	}
}

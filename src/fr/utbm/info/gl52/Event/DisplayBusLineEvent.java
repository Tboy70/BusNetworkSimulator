package fr.utbm.info.gl52.Event;

import fr.utbm.info.gl52.Middle.BusLine;

public class DisplayBusLineEvent implements IEvent {
	public BusLine message;
	public DisplayBusLineEvent(BusLine l)
	{
		this.message = l;
	}
}

package fr.utbm.info.gl52.Event;

import fr.utbm.info.gl52.Middle.BusLine;

public class AddBusLineEvent implements IEvent {
	public BusLine message;
	public AddBusLineEvent(BusLine l)
	{
		this.message = l;
	}
}

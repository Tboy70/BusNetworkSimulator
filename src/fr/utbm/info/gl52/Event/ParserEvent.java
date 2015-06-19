package fr.utbm.info.gl52.Event;

public class ParserEvent implements IEvent {
	public String message;
	public ParserEvent(String msg)
	{
		this.message = msg;
	}
}

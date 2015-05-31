package fr.utbm.info.gl52.Event;

public class PopupEvent implements IEvent {
	public String message = "";
	public PopupEvent(String msg)
	{
		this.message = msg;
	}
}

package fr.utbm.info.gl52.Graphics;

import fr.utbm.info.gl52.Event.IEvent;
import fr.utbm.info.gl52.Event.ISubscriber;
import fr.utbm.info.gl52.Event.PopupEvent;
import fr.utbm.info.gl52.Graphics.Frame.PopupWindow;

public class Controller implements ISubscriber {

	public Controller() { }
	@Override
	public void inform(IEvent e) {
		if (e.getClass() == PopupEvent.class)
		{
			new PopupWindow(((PopupEvent)e).message);
		}
	}
	
}
package fr.utbm.info.gl52.Graphics;

import fr.utbm.info.gl52.Event.IEvent;
import fr.utbm.info.gl52.Event.ISubscriber;
import fr.utbm.info.gl52.Event.LeftClicEvent;

public class Controller implements ISubscriber {

	public Controller() { }
	@Override
	public void inform(IEvent e) {
		// TODO Auto-generated method stub
		if (e.getClass() == LeftClicEvent.class)
		{
			LeftClicEvent lce = (LeftClicEvent)e;
			System.out.println("LeftClicEvent:"+lce.x + ", "+ lce.y);
		}
	}
	
}
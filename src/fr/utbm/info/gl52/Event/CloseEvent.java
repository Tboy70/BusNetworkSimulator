package fr.utbm.info.gl52.Event;

import fr.utbm.info.gl52.Graphics.Frame.IFrame;

public class CloseEvent implements IEvent {
	public IFrame frame;
	public CloseEvent(IFrame f)
	{
		frame = f;
	}

}

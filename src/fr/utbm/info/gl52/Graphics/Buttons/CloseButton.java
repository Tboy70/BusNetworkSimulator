package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.event.ActionEvent;

import fr.utbm.info.gl52.Event.CloseEvent;
import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Graphics.Frame.IFrame;

public class CloseButton extends ButtonComponent {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IFrame f;
	public CloseButton(String text, int x, int y, int h, int w) {
		super(text, x, y, h, w);
		this.f = null;
	}
	public void setFrame(IFrame frame)
	{
		this.f = frame;
	}

	@Override
	public void action(ActionEvent evt) {
		EventService.getInstance().publish(new CloseEvent(this.f));
	}


}

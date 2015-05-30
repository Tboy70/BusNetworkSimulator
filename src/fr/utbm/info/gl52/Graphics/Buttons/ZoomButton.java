package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.event.ActionEvent;
import fr.utbm.info.gl52.Graphics.CardinalSystem;

public class ZoomButton extends ButtonComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2765495561532237764L;
	protected double zoomFactor;
	public ZoomButton(String text, int x, int y, int h, int w, double zoom) {
		super(text, x, y, h, w);
		this.zoomFactor = zoom;
		// TODO Auto-generated constructor stub
	}
	public ZoomButton(String text, int x, int y, int h, int w, CardinalSystem p, double zoom) {
		super(text, x, y, h, w, p);
		this.zoomFactor = zoom;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(ActionEvent evt) {
		// TODO Auto-generated method stub
		if (this.m != null)
		{
			this.m.zoom(this.zoomFactor);
			this.m.repaint();
		}
	}
}

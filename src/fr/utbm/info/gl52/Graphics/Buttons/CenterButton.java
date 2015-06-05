package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.event.ActionEvent;

import fr.utbm.info.gl52.Graphics.Layout.AbstractLayout;

public class CenterButton extends ButtonComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 384995750556236731L;

	public CenterButton(String text, int x, int y, int h, int w) {
		super(text, x, y, h, w);
	}

	@Override
	public void action(ActionEvent evt) {
		for (AbstractLayout<?> m : this.m)
			m.setLocation(0, 0);
	}

}

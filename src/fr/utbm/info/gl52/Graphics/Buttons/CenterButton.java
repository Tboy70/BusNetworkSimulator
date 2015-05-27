package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.event.ActionEvent;

public class CenterButton extends ButtonComponent {

	public CenterButton(String text, int x, int y, int h, int w) {
		super(text, x, y, h, w);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(ActionEvent evt) {
		// TODO Auto-generated method stub
		m.setLocation(0, 0);
	}

}

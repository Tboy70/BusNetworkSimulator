package fr.utbm.info.gl52.Graphics.Buttons;


import java.awt.event.ActionEvent;

import fr.utbm.info.gl52.Graphics.CardinalSystem;

/**
 * 
 */
public class AddBusButton extends ButtonComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8107668952988309579L;

	/**
	 * 
	 */
	public AddBusButton(String text, int x, int y, int h, int w, CardinalSystem p) {
		super(text, x, y, h, w, p);
	}

	@Override
	public void action(ActionEvent evt) {

		/*
		for (AbstractLayout<AbstractComponent> m : this.m)
		{
			AbstractComponent c =new YellowBus((int) (Math.random() * m.getHeight()),(int) (Math.random() * m.getWidth())) ; 
			m.addComponent(c);
			m.repaint();
		}*/
	}

}

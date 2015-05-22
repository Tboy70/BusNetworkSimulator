package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.event.ActionEvent;

import fr.utbm.info.gl52.Graphics.CardinalSystem;


/**
 * 
 */
public class AddStopButton extends ButtonComponent {

	public AddStopButton(String text, int x, int y, int h, int w, CardinalSystem p) {
		super(text, x, y, h, w, p);
		// TODO Auto-generated constructor stub
	}

	/**
     * 
     */
	public void action(ActionEvent evt) {
		System.out.println("add test");
	}
}
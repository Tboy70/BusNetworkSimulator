package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.event.ActionEvent;


/**
 * 
 */
public class AddStopButton extends ButtonComponent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddStopButton(String text, int x, int y, int h, int w) {
		super(text, x, y, h, w);
		// TODO Auto-generated constructor stub
	}

	/**
     * 
     */
	public void action(ActionEvent evt) {
		System.out.println("add test");
	}
}
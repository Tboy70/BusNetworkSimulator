package fr.utbm.info.gl52.Graphics.Buttons;


import java.awt.event.ActionEvent;

import fr.utbm.info.gl52.Event.AddBusLineEvent;
import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Middle.BusLine;
import fr.utbm.info.gl52.Middle.NameGenerator;

/**
 * 
 */
public class AddBusLineButton extends ButtonComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8107668952988309579L;

	/**
	 * 
	 */
	public AddBusLineButton(String text, int x, int y, int h, int w) {
		super(text, x, y, h, w);
	}

	@Override
	public void action(ActionEvent evt) {
		BusLine l = new BusLine();
		l.setName(NameGenerator.getRandomName());
		EventService.getInstance().publish(new AddBusLineEvent(l));
	}

}

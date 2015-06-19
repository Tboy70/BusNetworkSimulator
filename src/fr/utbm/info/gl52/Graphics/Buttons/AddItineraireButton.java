package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.event.ActionEvent;

import fr.utbm.info.gl52.Event.AddItineraireEvent;
import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Middle.Itineraire;
import fr.utbm.info.gl52.Middle.NameGenerator;

public class AddItineraireButton extends ButtonComponent {

	public AddItineraireButton(String text, int x, int y, int h, int w) {
		super(text, x, y, h, w);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(ActionEvent evt) {
		// TODO Auto-generated method stub
		String s = NameGenerator.getRandomName();
		Itineraire i = new Itineraire(s , NameGenerator.getColorName(s));
		EventService.getInstance().publish(new AddItineraireEvent(i));
	}

}

package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.event.ActionEvent;

public class ParseButton extends ButtonComponent {

	public ParseButton(String text, int x, int y, int h, int w) {
		super(text, x, y, h, w);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(ActionEvent evt) {
		this.parseDefaultFile();
	}
	
	private void parseDefaultFile(){
		// TODO
	}

}

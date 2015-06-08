package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.event.ActionEvent;

public class ModButton extends ButtonComponent {
	private static final long serialVersionUID = -8107668952988309579L;

	private ParseButton parse;

	public ModButton(String string, int i, int j, int k, int l, ParseButton parse) {
		super(string, i, j, k, l);
		this.parse = parse;
	}

	@Override
	public void action(ActionEvent evt) {
		// Not defined for now
	}

}

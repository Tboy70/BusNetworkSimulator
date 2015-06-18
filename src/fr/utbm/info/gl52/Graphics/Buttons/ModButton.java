package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.event.ActionEvent;

import fr.utbm.info.gl52.Graphics.Layout.MouseManager;

public class ModButton extends ButtonComponent {
	private static final long serialVersionUID = -8107668952988309579L;
	
	public ModButton(String string, int i, int j, int k, int l) {
		super(string, i, j, k, l);
	}

	@Override
	public void action(ActionEvent evt) {
		// Not defined for now
		this.button.click();
		MouseManager.bModify = !MouseManager.bModify;
	}

}

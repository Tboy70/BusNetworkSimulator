package fr.utbm.info.gl52.Graphics.GraphicComponent;

import javax.swing.JComponent;

import fr.utbm.info.gl52.Graphics.AbstractComponent;

public class LabelComponent  extends AbstractComponent {

	private LabelGraphic label;
	public LabelComponent(String message, int x, int y, int w, int h)
	{
		label = new LabelGraphic(message,x,y,w,h);
	}
	@Override
	public JComponent getSwingComponent() {
		return label;
	}

}

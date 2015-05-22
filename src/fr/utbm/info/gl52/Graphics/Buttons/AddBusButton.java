package fr.utbm.info.gl52.Graphics.Buttons;


import java.awt.event.ActionEvent;

import fr.utbm.info.gl52.Graphics.AbstractComponent;
import fr.utbm.info.gl52.Graphics.CardinalSystem;
import fr.utbm.info.gl52.Graphics.Bus.YellowBus;

/**
 * 
 */
public class AddBusButton extends ButtonComponent {

    /**
     * 
     */
    public AddBusButton(String text, int x, int y, int h, int w, CardinalSystem p) {
    	super(text, x, y, h, w, p);
    }
    
	@Override
	public void action(ActionEvent evt) {
		AbstractComponent c =new YellowBus((int) (Math.random() * m.getHeight()),(int) (Math.random() * m.getWidth())) ; 
		m.addComponent(c);
		m.repaint();
	}

}

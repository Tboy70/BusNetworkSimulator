package fr.utbm.info.gl52.Graphics;


import java.awt.Graphics;

import javax.swing.JComponent;

import fr.utbm.info.gl52.Event.Subscriber;

/**
 * 
 */
public abstract class AbstractGraphicElement extends AbstractComponent implements IGraphic {

    /**
     * 
     */

	protected int posX, posY;
    public AbstractGraphicElement() {
    }

	public abstract void draw(Graphics g);
}

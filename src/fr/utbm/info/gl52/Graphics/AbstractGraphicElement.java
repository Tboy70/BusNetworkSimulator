package fr.utbm.info.gl52.Graphics;


import java.awt.Graphics;

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

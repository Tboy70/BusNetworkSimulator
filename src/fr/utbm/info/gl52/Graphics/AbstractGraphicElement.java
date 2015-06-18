package fr.utbm.info.gl52.Graphics;


import java.awt.Graphics;

/**
 * 
 */
public abstract class AbstractGraphicElement extends AbstractComponent implements IGraphic {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8029785793479438477L;
	/**
     * 
     */
	protected boolean selected = false;
    public AbstractGraphicElement() {
    }

	public abstract void draw(Graphics g);
	public void select() { this.selected = true; }
	public void unselect() { this.selected = false; }
	public abstract void update();
}
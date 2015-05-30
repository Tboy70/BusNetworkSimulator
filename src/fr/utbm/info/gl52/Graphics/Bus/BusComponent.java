package fr.utbm.info.gl52.Graphics.Bus;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;



/**
 * 
 */
public abstract class BusComponent extends AbstractGraphicElement{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1599362302718521824L;
	/**
     * 
     */
	protected Rectangle bounds;
	protected ImageIcon image;
    public BusComponent(int x, int y) {
    	this.bounds = new Rectangle(x,y,16,16);
    }

	public void move(int x, int y) {
		this.bounds.setLocation(x, y);
	}
	public void draw(Graphics g)
	{
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.image.getImage(), this.bounds.x, this.bounds.y, null);
	}

	public JComponent getSwingComponent() {
		return null;
	}
}

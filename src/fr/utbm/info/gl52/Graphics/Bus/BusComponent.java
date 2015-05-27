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
	protected Rectangle bounds;
	protected ImageIcon image;
    public BusComponent(int x, int y) {
    	bounds = new Rectangle(x,y,16,16);
    }

	public void move(int x, int y) {
		// TODO Auto-generated method stub
		bounds.setLocation(x, y);
	}
	public void draw(Graphics g)
	{
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image.getImage(), bounds.x, bounds.y, null);
	}

	public JComponent getSwingComponent() {
		return null;
	}
}

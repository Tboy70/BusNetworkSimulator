package fr.utbm.info.gl52.Graphics.Bus;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;
import fr.utbm.info.gl52.Graphics.Itinerary.AbstractGraphicItinerary;



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
	protected AbstractGraphicItinerary iti =null;
	protected int position = 0;
	protected boolean b = false;
	protected static final float step = 1f;
	protected Rectangle bounds;
	protected ImageIcon image;
    public BusComponent(int x, int y) {
    	this.bounds = new Rectangle(x,y,16,16);
    }
    
    public void setItinerary(AbstractGraphicItinerary iki)
    {
    	this.iti = iki;
    	this.position = 100;
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
	public void update()
	{
		if (this.iti != null)
		{
			if (!this.b)
				this.position += step;
			else
				this.position -= step;
			Point newPos = this.iti.getPoint(this.position);
			this.bounds.setLocation(newPos.x, newPos.y);
			System.out.println("--->"+this.position/100 + " / "+ this.position);
			if (this.position <= 0 || (this.position/100) >= this.iti.getRoutesNumber())
				this.position = 0;
		}
	}
}

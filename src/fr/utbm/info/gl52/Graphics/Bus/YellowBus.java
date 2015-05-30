package fr.utbm.info.gl52.Graphics.Bus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.ImageIcon;

public class YellowBus extends BusComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2199204649330380611L;

	public YellowBus(int x, int y) {
		super(x, y);
		this.image = new ImageIcon("F:\\yellow.png");	
	}

	public void draw(Graphics g)
	{
        Graphics2D g2d = (Graphics2D) g;
       // g2d.drawImage(image.getImage(), bounds.x, bounds.y, null);

        // Pour le moment, on met des piti carrés jaunes.
        g2d.setColor(Color.YELLOW);
        //g2d.fillRect(bounds.x, bounds.y, 16, 16);
        g2d.fillOval(this.bounds.x-16/2, this.bounds.y-16/2, 16, 16);
        float dash1[] = {10.0f};
        g2d.setColor(Color.black);
        g2d.drawOval(this.bounds.x-16/2, this.bounds.y-16/2, 16, 16);   
	}

    public boolean intersect(Shape r)
    {
    	return this.bounds.intersects(r.getBounds2D()) || r.intersects(this.bounds) || this.bounds.contains(r.getBounds2D()) || r.contains(this.bounds);
    }
}

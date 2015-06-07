package fr.utbm.info.gl52.Graphics.Bus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Random;

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

        // Pour le moment, on met des piti carr�s jaunes.
        g2d.setColor(Color.YELLOW);
        //g2d.fillRect(bounds.x, bounds.y, 16, 16);
        g2d.fillOval(this.bounds.x-16/2, this.bounds.y-16/2, 16, 16);
       // float dash1[] = {10.0f};
        g2d.setColor(Color.black);
        g2d.drawOval(this.bounds.x-16/2, this.bounds.y-16/2, 16, 16);   
	}

    public boolean intersect(Shape r)
    {
    	return this.bounds.intersects(r.getBounds2D()) || r.intersects(this.bounds);
    }
	public synchronized void update()
	{
		Random rand = new Random();

		int x = rand.nextInt((1 - (-1)) + 1) + (-1);
		int y = rand.nextInt((1 - (-1)) + 1) + (-1);
		int newX = x + this.bounds.x;
		int newY = y + this.bounds.y;
		if (newX > 0 && newX < 800 && newY > 0 && newY < 800)
			this.bounds.setLocation(newX, newY);
	}
}

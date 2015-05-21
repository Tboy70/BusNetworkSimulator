package fr.utbm.info.gl52.Graphics.Bus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class YellowBus extends BusComponent {

	public YellowBus(int x, int y) {
		super(x, y);
		image = new ImageIcon("F:\\yellow.png");	
	}

	public void draw(Graphics g)
	{
        Graphics2D g2d = (Graphics2D) g;
       // g2d.drawImage(image.getImage(), bounds.x, bounds.y, null);

        // Pour le moment, on met des piti carrés jaunes.
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(bounds.x, bounds.y, 16, 16);
	}
}

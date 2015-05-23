package fr.utbm.info.gl52.Graphics.Road;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * 
 */
public class OneWayRoadComponent extends RoadComponent {

	public OneWayRoadComponent(int[] x, int[] y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g)
    {
    	Graphics2D g2d = (Graphics2D) g;
    	g2d.setColor(Color.black);
    	g2d.setStroke(new BasicStroke(3));
    	g2d.drawPolyline(Xpts, Ypts, Xpts.length);
    	
    	
    }

	@Override
	public JComponent getSwingComponent() {
		// TODO Auto-generated method stub
		return null;
	}
}

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

	/**
	 * 
	 */
	private static final long serialVersionUID = -7762570721764500437L;

	public OneWayRoadComponent(int[] x, int[] y) {
		super(x, y);
	}

	public void draw(Graphics g)
    {
    	Graphics2D g2d = (Graphics2D) g;
    	g2d.setColor(Color.black);
    	if (this.selected)
    		g2d.setStroke(new BasicStroke(3));
    	if (!this.selected)
    		g2d.setStroke(new BasicStroke(1));
    	g2d.drawPolyline(this.Xpts, this.Ypts, this.Xpts.length);
    	
    	g2d.setStroke(new BasicStroke(1));
    	
    }

	@Override
	public JComponent getSwingComponent() {
		return null;
	}
}

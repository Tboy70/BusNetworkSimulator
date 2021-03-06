package fr.utbm.info.gl52.Graphics.Road;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * 
 */
public class BicyclePathComponent extends RoadComponent {


	/**
	 * 
	 */
	private static final long serialVersionUID = -499548654865876L;
	public BicyclePathComponent(int[] x, int[] y) {
		super(x, y);
	}
	@Override
	public JComponent getSwingComponent() {
		return null;
	}
	public void draw(Graphics g)
    {
    	Graphics2D g2d = (Graphics2D) g;
    	g2d.setColor(new Color(137, 240, 132));
    	if (this.selected)
    		g2d.setStroke(new BasicStroke(5));
    	if (!this.selected)
    		g2d.setStroke(new BasicStroke(2));
    	g2d.drawPolyline(this.Xpts, this.Ypts, this.Xpts.length);
    	
    	g2d.setStroke(new BasicStroke(1));
    	g2d.setColor(new Color(51, 158, 46));
    	g2d.drawPolyline(this.Xpts, this.Ypts, this.Xpts.length);
    	
    }


}

package fr.utbm.info.gl52.Graphics.Road;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;


/**
 * 
 */
public class HighwayComponent extends RoadComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -858174210007613239L;
	public HighwayComponent(int[] x, int[] y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public JComponent getSwingComponent() {
		// TODO Auto-generated method stub
		return null;
	}
	public void draw(Graphics g)
    {
    	Graphics2D g2d = (Graphics2D) g;
    	g2d.setColor(new Color(184, 242, 239));
    	if (this.selected)
    		g2d.setStroke(new BasicStroke(5));
    	if (!this.selected)
    		g2d.setStroke(new BasicStroke(2));
    	g2d.drawPolyline(this.Xpts, this.Ypts, this.Xpts.length);
    	
    	g2d.setStroke(new BasicStroke(1));
    	g2d.setColor(new Color(93, 163, 160));
    	g2d.drawPolyline(this.Xpts, this.Ypts, this.Xpts.length);
    	
    }


}
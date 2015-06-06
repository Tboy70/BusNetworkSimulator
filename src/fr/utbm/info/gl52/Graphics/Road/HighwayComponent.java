package fr.utbm.info.gl52.Graphics.Road;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import fr.utbm.info.gl52.Middle.MapPolyline;


/**
 * 
 */
public class HighwayComponent extends RoadComponent {

	private static final long serialVersionUID = -858174210007613239L;
	public HighwayComponent(int[] x, int[] y) {
		super(x, y);
	}
	public HighwayComponent(int[] x, int[] y, SensRoad sens, MapPolyline mapPl) {
		super(x, y, sens, mapPl);
	}
	@Override
	public JComponent getSwingComponent() {
		return null;
	}
	public void draw(Graphics g)
    {
    	Graphics2D g2d = (Graphics2D) g;
    	//g2d.setColor(new Color(184, 242, 239));
    	g2d.setColor(new Color(13,13,13));
    	if (this.selected)
    		g2d.setStroke(new BasicStroke(3));
    	if (!this.selected)
    		g2d.setStroke(new BasicStroke(1));
    	this.drawArrowRoad(g2d);
    	g2d.drawPolyline(this.Xpts, this.Ypts, this.Xpts.length);
    	
    	g2d.setStroke(new BasicStroke(1));
    	//g2d.setColor(new Color(93, 163, 160));
    	g2d.drawPolyline(this.Xpts, this.Ypts, this.Xpts.length);	
    	this.drawArrowRoad(g2d);
    }


}
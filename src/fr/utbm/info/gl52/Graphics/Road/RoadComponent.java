package fr.utbm.info.gl52.Graphics.Road;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;

import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;
import fr.utbm.info.gl52.Middle.MapPolyline;


/**
 * 
 */
public abstract class RoadComponent extends AbstractGraphicElement {

	private static final long serialVersionUID = 2161929120384646945L;

	/**
	 * 
	 */
	protected int[] Xpts;
	protected int[] Ypts;
	protected SensRoad sens;
	protected MapPolyline mapPl;
	public RoadComponent(int[] x, int[] y) {
		this.Xpts = x;
		this.Ypts = y;
		this.sens = SensRoad.SANS;
	}
	public String getName()
	{
		return this.mapPl.getName();
	}
	public MapPolyline getPolyline()
	{
		return this.mapPl;
	}
	public RoadComponent(int[] x, int[] y, SensRoad sens, MapPolyline m) {
		this.Xpts = x;
		this.Ypts = y;
		this.sens = sens;
		this.mapPl = m;

	}
	
	public void move(int x, int y)
	{
		// Not used for now
	}
	public void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.red);
		g2d.setStroke(new BasicStroke(5));
		for (int i = 0; i < this.Xpts.length-1; ++i)
		{
			Line2D line = new Line2D.Double(this.Xpts[i], this.Ypts[i],this.Xpts[i+1], this.Ypts[i+1]);
			//System.out.println(line+"X1:"+Xpts[i]+"Y1:"+Ypts[i]+"X2:"+Xpts[i+1]+"Y2:"+Ypts[i+1]);
			g2d.draw(line);
			/*if (line.intersects(r))
    			return true;*/
		}
		/*g2d.drawPolyline(Xpts, Ypts, Xpts.length);
    	g2d.setStroke(new BasicStroke(1));*/
	}
	public boolean intersect(Shape r)
	{
		for (int i = 0; i < this.Xpts.length-1; ++i)
		{
			Line2D line = new Line2D.Double(this.Xpts[i], this.Ypts[i],this.Xpts[i+1], this.Ypts[i+1]);
			//System.out.println(line+"X1:"+this.Xpts[i]+"Y1:"+this.Ypts[i]+"X2:"+this.Xpts[i+1]+"Y2:"+this.Ypts[i+1]);
			if (line.intersects(r.getBounds2D()))
				return true;
		}
		return false;
	}
	protected void drawArrowRoad(Graphics2D g2d)
	{
    	if (this.sens == SensRoad.DROIT)
    	{
    		double theta = Math.atan2(this.Ypts[1] - this.Ypts[0], this.Xpts[1] - this.Xpts[0]);
            drawArrow(g2d, theta, this.Xpts[1], this.Ypts[1]);	
    	}
    	else if (this.sens == SensRoad.INVERSE)
    	{
    		double theta = Math.atan2(this.Ypts[0] - this.Ypts[1], this.Xpts[0] - this.Xpts[1]);
            drawArrow(g2d, theta, this.Xpts[0], this.Ypts[0]);
    	}
	}
    protected static void drawArrow(Graphics2D g2, double theta, double x0, double y0)
    {
        int barb = 5; // Taille de la flèche
        double phi = Math.PI/6; // Angle avec les deux branches de la flèche
        
        double x = x0 - barb * Math.cos(theta + phi);
        double y = y0 - barb * Math.sin(theta + phi);
        g2.draw(new Line2D.Double(x0, y0, x, y));
        x = x0 - barb * Math.cos(theta - phi);
        y = y0 - barb * Math.sin(theta - phi);
        g2.draw(new Line2D.Double(x0, y0, x, y));
    }
    public void update()
    {
    	// nothing ?
    }
}

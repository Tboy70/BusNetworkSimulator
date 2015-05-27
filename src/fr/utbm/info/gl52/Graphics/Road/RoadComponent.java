package fr.utbm.info.gl52.Graphics.Road;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;

import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;


/**
 * 
 */
public abstract class RoadComponent extends AbstractGraphicElement {

    /**
     */
	protected int[] Xpts;
	protected int[] Ypts;
    public RoadComponent(int[] x, int[] y) {
    	Xpts = x;
    	Ypts = y;
    }
    public void move(int x, int y)
    {
    	
    }
    public void draw(Graphics g)
    {
    	Graphics2D g2d = (Graphics2D) g;
    	g2d.setColor(Color.red);
    	g2d.setStroke(new BasicStroke(5));
    	for (int i = 0; i < Xpts.length-1; ++i)
    	{
    		Line2D line = new Line2D.Double(Xpts[i], Ypts[i],Xpts[i+1], Ypts[i+1]);
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
    	for (int i = 0; i < Xpts.length-1; ++i)
    	{
    		Line2D line = new Line2D.Double(Xpts[i], Ypts[i],Xpts[i+1], Ypts[i+1]);
    		System.out.println(line+"X1:"+Xpts[i]+"Y1:"+Ypts[i]+"X2:"+Xpts[i+1]+"Y2:"+Ypts[i+1]);
    		if (line.intersects(r.getBounds2D()))
    			return true;
    	}
    	return false;
    }
}
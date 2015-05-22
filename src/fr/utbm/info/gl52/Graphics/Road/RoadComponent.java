package fr.utbm.info.gl52.Graphics.Road;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
    	g2d.setStroke(new BasicStroke(10));
    	g2d.drawPolyline(Xpts, Ypts, Xpts.length);
    	g2d.setStroke(new BasicStroke(1));
    }

}
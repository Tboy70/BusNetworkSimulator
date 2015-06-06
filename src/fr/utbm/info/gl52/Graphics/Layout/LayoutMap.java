package fr.utbm.info.gl52.Graphics.Layout;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;

import fr.utbm.info.gl52.Graphics.Road.RoadComponent;
import fr.utbm.info.gl52.Middle.Connection;


/**
 * 
 */
public class LayoutMap<C extends AbstractGraphicElement> extends AbstractLayout<C>  {

	private static final long serialVersionUID = 1L;
	private static final int HIT_BOX_SIZE = 2;
	private AbstractGraphicElement selected = null;
	private Connection start = null;
	private Connection end = null;
	private int clicx=0, clicy=0;
	private int x, y;
	public LayoutMap(int h, int w) {
		super(h, w);
		listComponents = Collections.synchronizedList(new ArrayList());
	}
	public void addComponent(C c) {
		this.listComponents.add(c);
	}

	@Override
	public synchronized void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.scale(this.zoom/100, this.zoom/100);
		g2d.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, this.width, this.height);
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.setStroke(new BasicStroke(2));
		g2d.drawRect(0, 0, this.width-1, this.height-1);

		synchronized(listComponents) {
			Iterator i = listComponents.iterator(); 
			while (i.hasNext())
			{
				AbstractGraphicElement b = (AbstractGraphicElement) i.next();
				b.draw(g2d);
			}
		}

		g2d.scale(1,1);
		g2d.setColor(Color.red);
		g2d.draw(new Ellipse2D.Double(this.clicx, this.clicy, 8, 8));
		g2d.dispose();
	}
	public AbstractGraphicElement actionClick(int x, int y)
	{
		this.clicx = (int) ((100/zoom) * (x - this.getLocation().getX()));
		this.clicy = (int) ((100/zoom) * (y - this.getLocation().getY()));
		Shape ellipse = new Ellipse2D.Double(this.clicx , this.clicy, 8, 8);
		for(AbstractGraphicElement e: this.listComponents)
		{
			if (e.intersect(ellipse)) {
				if (this.selected != null)
					this.selected.unselect();
				e.select();
				this.selected = e;
				if (e.getClass().getSuperclass() == RoadComponent.class)
				{
					RoadComponent r = (RoadComponent) e;
					if (start == null)
					{
						start = (Connection)r.getPolyline().getListSegment().get(0).getNodeA();
					}
					else if (end == null)
					{
						end = (Connection)r.getPolyline().getListSegment().get(r.getPolyline().getListSegment().size()-1).getNodeB();
					}
					
					if (start != null && end != null)
					{
						System.out.println("Start:"+start.toString());
						System.out.println("End:"+end.toString());
					}
					System.out.println("Rue: "+r.getName());
				}
				return e;
			}		
		}
		if (this.selected != null)
			this.selected.unselect();
		this.selected = null;
		return null;
	}
}

package fr.utbm.info.gl52.Graphics.Layout;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;
import fr.utbm.info.gl52.Graphics.Bus.BusComponent;

/**
 * 
 */
public class LayoutNetwork<C extends BusComponent> extends AbstractLayout<C> implements Runnable {

	private static final long serialVersionUID = -8388992835805072885L;
	private Thread t;
	private int x, y;
	private AbstractGraphicElement selected = null;
	private int clicx=0, clicy=0;
	
	public LayoutNetwork(int h, int w) {
		super(h, w);
		listComponents = Collections.synchronizedList(new ArrayList());
		t = new Thread(this);
		//t.start();
	}

	@Override
	public void run() {
		while (true)
		{
			try {
				Thread.sleep(20);
				synchronized(listComponents) {
					Iterator i = listComponents.iterator(); 
					while (i.hasNext())
					{
						BusComponent b = (BusComponent) i.next();
						b.update();
					}
				}
				this.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.scale(this.zoom/100, this.zoom/100);
		g2d.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);

		//g2d.clearRect(0, 0, this.width, this.height);
		g2d.setColor(Color.green);
		g2d.drawRect(0, 0, this.width, this.height);
		for(C c: this.listComponents)
			c.draw(g);

		g2d.dispose();
		super.paintComponent(g);
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
				return e;
			}		
		}
		if (this.selected != null)
			this.selected.unselect();
		this.selected = null;
		return null;
	}
}

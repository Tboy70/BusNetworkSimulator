package fr.utbm.info.gl52.Graphics.Layout;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;

/**
 * 
 */
public class LayoutNetwork<C extends AbstractGraphicElement> extends AbstractLayout<C> implements Runnable {

	private static final long serialVersionUID = -8388992835805072885L;
	private Thread t;
	private int clicx=0, clicy=0;
	
	public LayoutNetwork(int h, int w) {
		super(h, w);
		this.listComponents = Collections.synchronizedList(new ArrayList<C>());
		this.t = new Thread(this);
		this.t.start();
	}

	@Override
	public void run() {
		while (true)
		{
			try {
				Thread.sleep(30);
				synchronized(this.listComponents) {
					Iterator<?> i = this.listComponents.iterator(); 
					while (i.hasNext())
					{
						
						AbstractGraphicElement b = (AbstractGraphicElement) i.next();
						b.update();
					}
				}
				this.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public synchronized void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.scale(this.zoom/100, this.zoom/100);
		for(C c: this.listComponents)
			c.draw(g);

		g2d.dispose();
		super.paintComponent(g);
	}
	public Collection<AbstractGraphicElement> actionClick(int x, int y)
	{
		this.clicx = (int) ((100/this.zoom) * (x - this.getLocation().getX()));
		this.clicy = (int) ((100/this.zoom) * (y - this.getLocation().getY()));
		Shape ellipse = new Ellipse2D.Double(this.clicx , this.clicy, 8, 8);
		//AbstractGraphicElement eTemp = null;
		Collection<AbstractGraphicElement> c = new ArrayList<>();
		for(AbstractGraphicElement e: this.listComponents)
		{
			if (e.intersect(ellipse)) {
				//if (this.selected != null)
				//	this.selected.unselect();
				//e.select();
				//this.selected = e;
				//eTemp =  e;
				c.add(e);
			}		
		}
		//if (this.selected != null)
		//	this.selected.unselect();
		//this.selected = null;
		return c;
	}
}

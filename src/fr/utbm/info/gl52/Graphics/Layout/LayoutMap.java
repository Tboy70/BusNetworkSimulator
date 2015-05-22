package fr.utbm.info.gl52.Graphics.Layout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;


/**
 * 
 */
public class LayoutMap<C extends AbstractGraphicElement> extends AbstractLayout<C> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int HIT_BOX_SIZE = 5;
	public LayoutMap(int h, int w) {
		super(h, w);
		// TODO Auto-generated constructor stub
	}
	public void addComponent(C c) {
		listComponents.add(c);
	}

	@Override
	public void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D)g;
		g2d.scale(zoom/100, zoom/100);
		g2d.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		for(C c: listComponents)
			c.draw(g);
		g2d.scale(1,1);
		g2d.dispose();
		//super.paintComponent(g);
	}
	public AbstractGraphicElement actionClick(int x, int y)
	{
		Shape ellipse = new Ellipse2D.Double(x, y, 8, 8);

		for(AbstractGraphicElement e: listComponents)
		{
			if (e.intersect(ellipse)) {
				return e;
			}		
		}
		return null;
	}

}

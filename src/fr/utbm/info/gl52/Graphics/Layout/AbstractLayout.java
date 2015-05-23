package fr.utbm.info.gl52.Graphics.Layout;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JPanel;

import fr.utbm.info.gl52.Graphics.AbstractComponent;
import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;

/**
 * 
 */
public abstract class AbstractLayout<C extends AbstractComponent> extends JPanel implements ILayout<C>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Collection<C> listComponents;
	protected int h, w;
	protected final int height, width;
	protected double zoom;
	/**
	 * 
	 */	
	public AbstractGraphicElement actionClick(int x, int y)
	{
		return null;
	}
	public double getZoom() { return zoom; }
	public AbstractLayout(int h, int w) {
		zoom = 50;
		listComponents = new ArrayList<C>();
		setOpaque(false);

		setLayout(null);
		setBounds(new Rectangle(0,0,h,w));
		this.h = h;
		this.w = w;
		height = h;
		width = h;
	}

	public void addComponent(C c) {
		listComponents.add(c);
		if (c.getSwingComponent() != null)
			add(c.getSwingComponent());
	}

	public void moveComponent(C c, int x, int y) {
		if (listComponents.contains(c))
		{
			listComponents.remove(c);
			c.move(x, y);
			listComponents.add(c);
		}
	}

	public void delete(C c) {
		listComponents.remove(c);
		this.remove(c.getSwingComponent());
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	        
	}
	public void zoom(double z)
	{	
		if (zoom+z >= 20)
		{
			zoom += z;
			w = (int) (width * (zoom/100));
			h = (int) (height * (zoom/100));	
			this.resize(new Dimension(w,h));
			
			System.out.println("Size:"+getWidth()+"/"+getHeight());
			System.out.println("XSize:"+w+"/"+h);
			
		}
		repaint();
	}
	public int getW() { return w; }
	public int getH() { return h; }
}

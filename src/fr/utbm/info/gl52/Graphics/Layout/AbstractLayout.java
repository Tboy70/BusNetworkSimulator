package fr.utbm.info.gl52.Graphics.Layout;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
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
	public void flush()
	{
		this.listComponents.removeAll(this.listComponents);
	}
	public void flush(Class<?> c)
	{
		Collection<C> temp = new ArrayList<>();
		for (C obj : this.listComponents)
		{
			if (obj.getClass().equals(c))
			{
				temp.add(obj);
			}
		}
		this.listComponents.removeAll(temp);
	}
	public Collection<AbstractGraphicElement> actionClick(int x, int y)
	{
		return null;
	}
	public double getZoom() { return this.zoom; }
	public AbstractLayout(int h, int w) {
		this.zoom = 68;
		this.listComponents = new ArrayList<>();
		setOpaque(false);

		setLayout(null);
		setBounds(new Rectangle(0,0,h,w));
		this.h = h;
		this.w = w;
		this.height = h;
		this.width = h;
	}

	public synchronized void addComponent(C c) {
		this.listComponents.add(c);
		if (c.getSwingComponent() != null)
			add(c.getSwingComponent());
	}

	public synchronized void moveComponent(C c, int x, int y) {
		if (this.listComponents.contains(c))
		{
			this.listComponents.remove(c);
			//c.move(x, y);
			this.listComponents.add(c);
		}
	}

	public synchronized void delete(C c) {
		this.listComponents.remove(c);
		this.remove(c.getSwingComponent());
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	        
	}
	public void zoom(double z)
	{	
		if (this.zoom+z >= 20)
		{
			this.zoom += z;
			this.w = (int) (this.width * (this.zoom/100));
			this.h = (int) (this.height * (this.zoom/100));	
			//this.resize(new Dimension(w,h));
			this.setSize(new Dimension(this.w,this.h));
			
		}
		repaint();
	}
	public int getW() { return this.w; }
	public int getH() { return this.h; }
}

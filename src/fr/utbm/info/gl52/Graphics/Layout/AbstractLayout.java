package fr.utbm.info.gl52.Graphics.Layout;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JPanel;

import fr.utbm.info.gl52.Graphics.AbstractComponent;

/**
 * 
 */
public abstract class AbstractLayout<C extends AbstractComponent> extends JPanel implements ILayout<C> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Collection<C> listComponents;
	protected int h, w;
	/**
     * 
     */
    public AbstractLayout(int h, int w) {
    	listComponents = new ArrayList<C>();
    	setOpaque(false);
    	setLayout(null);
    	setBounds(new Rectangle(0,0,h,w));
    	this.h = h;
    	this.w = w;
    }

	public void addComponent(C c) {
		listComponents.add(c);
		if (c.getSwingComponent() != null)
			add(c.getSwingComponent());
	}

	public void moveComponent(C c, int x, int y) {
		int t;
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


}

package fr.utbm.info.gl52.Graphics.Layout;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

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
	protected List<C> listComponents;
	/**
     * 
     */
    public AbstractLayout(int h, int w) {
    	listComponents = new ArrayList<C>();
    	setOpaque(false);
    	setLayout(null);
    	setBounds(new Rectangle(0,0,h,w));
    }

	public void addComponent(C c) {
		listComponents.add(c);
		if (c.getSwingComponent() != null)
			add(c.getSwingComponent());
	}

	public void moveComponent(C c, int x, int y) {
		int t;
		if ((t = listComponents.indexOf(c)) != -1)
		{
			listComponents.get(t).move(x, y);
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

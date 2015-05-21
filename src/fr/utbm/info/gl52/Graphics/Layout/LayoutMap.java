package fr.utbm.info.gl52.Graphics.Layout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;


/**
 * 
 */
public class LayoutMap<C extends AbstractGraphicElement> extends AbstractLayout<C> {

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LayoutMap(int h, int w) {
		super(h, w);
		// TODO Auto-generated constructor stub
	}
	public void addComponent(C c) {
    	listComponents.add(c);
    }
   @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, h, w);
        for(C c: listComponents)
        	c.draw(g);
    }

}

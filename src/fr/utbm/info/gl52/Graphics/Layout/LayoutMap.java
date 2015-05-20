package fr.utbm.info.gl52.Graphics.Layout;

import java.awt.Graphics;

import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;


/**
 * 
 */
public class LayoutMap<C extends AbstractGraphicElement> extends AbstractLayout<C> {

    
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
        for(C c: listComponents)
        	c.draw(g);
    }

}

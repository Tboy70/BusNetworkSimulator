package fr.utbm.info.gl52.Graphics.Frame;

import java.awt.Graphics;

import fr.utbm.info.gl52.Graphics.Layout.LayoutGUI;


/**
 * 
 */
public class Window extends AbstractFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    public Window() {
    	super();
    	listLayout.add(new LayoutGUI());
    }
}

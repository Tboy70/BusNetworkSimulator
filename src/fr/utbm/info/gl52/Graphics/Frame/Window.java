package fr.utbm.info.gl52.Graphics.Frame;

import java.awt.event.MouseWheelEvent;

import fr.utbm.info.gl52.Graphics.Layout.LayoutGUI;
import fr.utbm.info.gl52.Graphics.Layout.LayoutMap;



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
	public Window(String title, int h, int w) {
		super(title, h, w);
    	this.gui = new LayoutGUI<>(h, w);
      	gui.setDoubleBuffered(true);
    	this.map = new LayoutMap<>(1000, 1000);    
    	this.map.setLocation(100,100);
        jlp.add(this.map, new Integer(0));
        jlp.add(this.gui, new Integer(1));
        
    	this.setContentPane(jlp);
    	this.setResizable(false);
	}
}

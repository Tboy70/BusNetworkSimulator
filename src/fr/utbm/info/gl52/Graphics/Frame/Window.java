package fr.utbm.info.gl52.Graphics.Frame;

import fr.utbm.info.gl52.Graphics.Layout.LayoutGUI;
import fr.utbm.info.gl52.Graphics.Layout.LayoutMap;
import fr.utbm.info.gl52.Graphics.Layout.LayoutNetwork;



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
		int wx, wy;
		wx = 800;
		wy = 800;
		this.gui = new LayoutGUI<>(h, w);
      	this.gui.setDoubleBuffered(true);
    	this.map = new LayoutMap<>(wx, wy);
    	this.network = new LayoutNetwork<>(wx, wy);
    	

    	this.map.setLocation((int) ((wx - h) * this.map.getZoom()/100),(int) ((wy - w) * this.map.getZoom()/100));
    	this.network.setLocation((int) ((wx - h) * this.map.getZoom()/100),(int) ((wy - w) * this.map.getZoom()/100));
    	this.mouse.add(this.map);
    	this.mouse.add(this.network);
		
		this.jlp.addMouseListener(this.mouse);
		this.jlp.addMouseMotionListener(this.mouse);
		this.jlp.addMouseWheelListener(this.mouse);
    	this.jlp.add(this.map, new Integer(0));
        this.jlp.add(this.network, new Integer(1));

        this.jlp.add(this.gui, new Integer(2));
    	this.setContentPane(this.jlp);
    	this.setResizable(false);
	}
}

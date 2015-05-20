package fr.utbm.info.gl52.Graphics;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;


/**
 * 
 */
public abstract class AbstractFrame extends JFrame implements IFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
	protected List<ILayout> listLayout;
    public AbstractFrame() {
    	listLayout = new ArrayList<ILayout>();
    }
    

}
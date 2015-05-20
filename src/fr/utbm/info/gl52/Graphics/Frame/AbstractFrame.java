package fr.utbm.info.gl52.Graphics.Frame;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import fr.utbm.info.gl52.Graphics.Layout.ILayout;


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
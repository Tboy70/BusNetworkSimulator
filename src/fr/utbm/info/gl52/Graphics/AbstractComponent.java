package fr.utbm.info.gl52.Graphics;

import javax.swing.JComponent;


/**
 * 
 */
public abstract class AbstractComponent extends JComponent implements IComponent {

    /**
     * 
     */
	protected int posX, posY;
    public AbstractComponent() {
    }

    public abstract JComponent getSwingComponent();
}
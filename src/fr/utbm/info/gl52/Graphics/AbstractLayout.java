package fr.utbm.info.gl52.Graphics;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLayeredPane;

/**
 * 
 */
public abstract class AbstractLayout extends JLayeredPane implements ILayout {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected List<IComponent> listComponents;
	/**
     * 
     */
    public AbstractLayout() {
    	listComponents = new ArrayList<IComponent>();
    }

	public void addComponent(AbstractComponent c) {
		listComponents.add(c);
	}

	public void moveComponent(AbstractComponent c, int x, int y) {
		int t;
		if ((t = listComponents.indexOf(c)) != -1)
		{
			listComponents.get(t).move(x, y);
		}
	}

	public void delete(AbstractComponent c) {
		listComponents.remove(c);
	}


}

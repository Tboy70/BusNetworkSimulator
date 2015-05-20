package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

import fr.utbm.info.gl52.Graphics.AbstractComponent;
import fr.utbm.info.gl52.Graphics.IComponent;


/**
 * 
 */
public abstract class ButtonComponent extends AbstractComponent implements IComponent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 
     */
	protected Rectangle bounds;
	private JButton button;
	private void init() {
		button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		        action(evt);
		      }
		    });
	}
    public ButtonComponent(String text, int x, int y, int h, int w) {
    	button = new JButton(text);
    	button.setText(text);
    	bounds = new Rectangle(x, y, h, w);
    	button.setSize(w,h);
    	button.setBounds(bounds);
    	init();
    }
    public void move(int x, int y) {
		// TODO Auto-generated method stub
		bounds.setLocation(x, y);
		button.setBounds(bounds);
	}

    public JComponent getSwingComponent()
    {
    	return button;
    }
    public abstract void action(ActionEvent evt);

}
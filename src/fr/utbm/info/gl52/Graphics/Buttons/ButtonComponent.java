package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

import fr.utbm.info.gl52.Graphics.AbstractComponent;
import fr.utbm.info.gl52.Graphics.CardinalSystem;
import fr.utbm.info.gl52.Graphics.IComponent;
import fr.utbm.info.gl52.Graphics.Layout.AbstractLayout;


/**
 * 
 */
public abstract class ButtonComponent extends AbstractComponent implements IComponent {

	protected AbstractLayout m;
	protected Rectangle bounds;
	private JButton button;
	protected CardinalSystem placement;
	private void init() {
		button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		        action(evt);
		      }
		    });
	}
	public ButtonComponent(String text, int x, int y, int h, int w) {
		button = new GraphicButton(text);
    	button.setText(text);
    	bounds = new Rectangle(x, y, h, w);
    	button.setSize(w,h);
    	button.setBounds(bounds);
    	placement = CardinalSystem.NORTHEAST;
    	init();
    }
	    
	public ButtonComponent(String text, int x, int y, int h, int w, CardinalSystem p) {
    	button = new GraphicButton(text);
    	button.setText(text);
    	bounds = new Rectangle(x, y, h, w);
    	button.setSize(w,h);
    	button.setBounds(bounds);
    	placement = p;
    	init();
    }

	public void setLayout(AbstractLayout<?> l)
	{
		m = l;
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
package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

import fr.utbm.info.gl52.Graphics.AbstractComponent;
import fr.utbm.info.gl52.Graphics.CardinalSystem;
import fr.utbm.info.gl52.Graphics.Layout.AbstractLayout;


/**
 * 
 */
public abstract class ButtonComponent extends AbstractComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3341644248986327368L;
	protected AbstractLayout m;
	protected Rectangle bounds;
	private JButton button;
	protected CardinalSystem placement;
	private void init() {
		this.button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		        action(evt);
		      }
		    });
	}
	public ButtonComponent(String text, int x, int y, int h, int w) {
		this.button = new GraphicButton(text);
    	this.button.setText(text);
    	this.bounds = new Rectangle(x, y, h, w);
    	this.button.setSize(w,h);
    	this.button.setBounds(this.bounds);
    	this.placement = CardinalSystem.NORTHEAST;
    	init();
    }
	    
	public ButtonComponent(String text, int x, int y, int h, int w, CardinalSystem p) {
    	this.button = new GraphicButton(text);
    	this.button.setText(text);
    	this.bounds = new Rectangle(x, y, h, w);
    	this.button.setSize(w,h);
    	this.button.setBounds(this.bounds);
    	this.placement = p;
    	init();
    }

	public void setLayout(AbstractLayout<?> l)
	{
		this.m = l;
	}
    public void move(int x, int y) {
		this.bounds.setLocation(x, y);
		this.button.setBounds(this.bounds);
	}

    public JComponent getSwingComponent()
    {
    	return this.button;
    }
    public abstract void action(ActionEvent evt);

}
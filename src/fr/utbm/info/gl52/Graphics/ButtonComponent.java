package fr.utbm.info.gl52.Graphics;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


/**
 * 
 */
public abstract class ButtonComponent extends JButton implements IComponent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 
     */
	protected Rectangle bounds;
	private void init() {
		this.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		        action(evt);
		      }
		    });
	}
    public ButtonComponent(String text, int x, int y, int h, int w) {
    	super(text);
    	bounds = new Rectangle(0, 0, h, w);
    	this.setSize(w,h);
    	this.setBounds(bounds);
    	init();
    }
    public void move(int x, int y) {
		// TODO Auto-generated method stub
		bounds.setLocation(x, y);
		setBounds(bounds);
	}
    public abstract void action(ActionEvent evt);

}
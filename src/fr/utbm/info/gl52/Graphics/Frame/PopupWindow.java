package fr.utbm.info.gl52.Graphics.Frame;

import fr.utbm.info.gl52.Graphics.Buttons.CloseButton;
import fr.utbm.info.gl52.Graphics.GraphicComponent.LabelComponent;
import fr.utbm.info.gl52.Graphics.Layout.LayoutGUI;

public class PopupWindow extends AbstractFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7459389851855477807L;

	public PopupWindow(String message)
	{
		super("Popup", 400, 150);
		
		int h = 400;
		int w = 150;
    	this.gui = new LayoutGUI<>(h, w);
        this.jlp.add(this.gui, new Integer(1));
        
        CloseButton closebutt = new CloseButton("Fermer", 250, 80, 140, 40);
        LabelComponent label = new LabelComponent(message, 10, 10, 390, 70);
        
        closebutt.setFrame(this);
        
        this.addGUI(closebutt);
        this.addGUI(label);
        
    	this.setContentPane(this.jlp);
    	this.setResizable(false);    	repaint();
	}


}

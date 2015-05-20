package fr.utbm.info.gl52.Graphics.Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fr.utbm.info.gl52.Graphics.AbstractComponent;
import fr.utbm.info.gl52.Graphics.Bus.BusComponent;
import fr.utbm.info.gl52.Graphics.Bus.YellowBus;
import fr.utbm.info.gl52.Graphics.Buttons.AddBusButton;
import fr.utbm.info.gl52.Graphics.Layout.AbstractLayout;
import fr.utbm.info.gl52.Graphics.Layout.LayoutGUI;
import fr.utbm.info.gl52.Graphics.Layout.LayoutMap;


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
	protected AbstractLayout gui;
	protected AbstractLayout map;
	
	protected JPanel mainPanel;
    public AbstractFrame(String title, int h,  int w) {
    	super(title);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setSize(300,300);
        setVisible(true);
    	mainPanel = new JPanel();
    	
    	AbstractComponent test = new AddBusButton("test", 10, 0, 100, 50);
        BusComponent bus = new YellowBus(50, 50);
    	JLayeredPane jlp = new JLayeredPane();
                
    	gui = new LayoutGUI(h, w);
    	map = new LayoutMap(h, w);
    	
    	
    	jlp.setPreferredSize(new Dimension(h, w));
        
    	
        
        map.addComponent(bus);
        gui.addComponent(test);
    	        
        jlp.add(map, new Integer(1));
        jlp.add(gui, new Integer(0));
        
    	
    	this.add(jlp,BorderLayout.CENTER);

    	//    	this.setContentPane(mainPanel);
    }
    

}
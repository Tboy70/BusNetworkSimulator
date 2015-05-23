package fr.utbm.info.gl52.Graphics.Frame;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Event.LeftClicEvent;
import fr.utbm.info.gl52.Graphics.AbstractComponent;
import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;
import fr.utbm.info.gl52.Graphics.Layout.AbstractLayout;
import fr.utbm.info.gl52.Graphics.Layout.LayoutGUI;
import fr.utbm.info.gl52.Graphics.Layout.LayoutMap;


public abstract class AbstractFrame extends JFrame implements IFrame{
	private static final long serialVersionUID = 1L;
	protected AbstractLayout<AbstractComponent> gui;
	protected AbstractLayout<AbstractGraphicElement> map;
	
	protected JPanel mainPanel;
	private int x, y;
	private int locationX=0, locationY=0;
    public AbstractFrame(String title, int h,  int w) {
    	super(title);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(new Point(locationX,locationY));
        
        setSize(700,700);
        setVisible(true);
    	mainPanel = new JPanel();
    	JLayeredPane jlp = new JLayeredPane(); 
    	gui = new LayoutGUI<AbstractComponent>(450, 450);
    	map = new LayoutMap<AbstractGraphicElement>(1000, 1000);
    
    	map.setLocation(100,100);
 //   	jlp.setPreferredSize(new Dimension(h, w));
        jlp.add(map, new Integer(0));
        jlp.add(gui, new Integer(1));
        

      //  super.addMouseListener(this);
       // this.addMouseMotionListener(this);
    	this.setContentPane(jlp);
    }
    public AbstractLayout<AbstractGraphicElement> getMap()
    {
    	return map;
    }
    public AbstractLayout<AbstractComponent> getGUI()
    {
    	return gui;
    }
    public void addGraphicElement(AbstractGraphicElement c)
    {
    	map.addComponent(c);
    }
    public void addGUI(AbstractComponent c)
    {
    	gui.addComponent(c);
    }
}
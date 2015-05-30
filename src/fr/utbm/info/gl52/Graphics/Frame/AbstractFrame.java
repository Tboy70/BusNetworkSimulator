package fr.utbm.info.gl52.Graphics.Frame;

import java.awt.Point;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

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
        this.setLocation(new Point(this.locationX,this.locationY));
        setSize(700,700);
        setVisible(true);
    	this.mainPanel = new JPanel();
    	
    	JLayeredPane jlp = new JLayeredPane(); 
    	gui.setDoubleBuffered(true);
    	this.gui = new LayoutGUI<>(450, 450);
    	this.map = new LayoutMap<>(1000, 1000);
    
    	this.map.setLocation(100,100);
        jlp.add(this.map, new Integer(0));
        jlp.add(this.gui, new Integer(1));
        

    	this.setContentPane(jlp);
    }
    public AbstractLayout<AbstractGraphicElement> getMap()
    {
    	return this.map;
    }
    public AbstractLayout<AbstractComponent> getGUI()
    {
    	return this.gui;
    }
    public void addGraphicElement(AbstractGraphicElement c)
    {
    	this.map.addComponent(c);
    }
    public void addGUI(AbstractComponent c)
    {
    	this.gui.addComponent(c);
    }
}
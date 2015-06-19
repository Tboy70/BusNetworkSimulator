package fr.utbm.info.gl52.Graphics.Frame;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fr.utbm.info.gl52.Event.CloseEvent;
import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Event.IEvent;
import fr.utbm.info.gl52.Event.ISubscriber;
import fr.utbm.info.gl52.Graphics.AbstractComponent;
import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;
import fr.utbm.info.gl52.Graphics.Layout.AbstractLayout;
import fr.utbm.info.gl52.Graphics.Layout.LayoutNetwork;
import fr.utbm.info.gl52.Graphics.Layout.MouseManager;


public abstract class AbstractFrame extends JFrame implements IFrame, ISubscriber{
	private static final long serialVersionUID = 1L;
	protected AbstractLayout<AbstractComponent> gui;
	protected AbstractLayout<AbstractGraphicElement> map;
	protected LayoutNetwork<AbstractGraphicElement> network;
	protected JLayeredPane jlp;
	protected JPanel mainPanel;
	protected MouseManager mouse;
//	private int x, y;
	private int locationX=0, locationY=0;
	public AbstractFrame(String title, int h,  int w) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(new Point(this.locationX,this.locationY));
		setSize(h,w);
		setVisible(true);
		this.mainPanel = new JPanel();

		this.jlp = new JLayeredPane();
		this.mouse = new MouseManager(0,0);
		
		//Inscription à l'evenement pour fermer la fenetre.
		EventService.getInstance().subscribe(CloseEvent.class, null, this);
    	
		//Centrage de la frame
    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

	}
	public AbstractLayout<AbstractGraphicElement> getNetwork()
	{
		return this.network;
	}
	public AbstractLayout<AbstractGraphicElement> getMap()
	{
		return this.map;
	}
	public AbstractLayout<AbstractComponent> getGUI()
	{
		return this.gui;
	}
	public synchronized void addGraphicElement(AbstractGraphicElement c)
	{
		this.map.addComponent(c);
	}
	public synchronized void remGraphicElement(AbstractGraphicElement c)
	{
		//this.map.remove(c);
		this.map.flush(c.getClass());
		c.setVisible(false);
		this.map.repaint();
	}
	public void addNetworkElement(AbstractGraphicElement c)
	{
		this.network.addComponent(c);
	}
	public void addGUI(AbstractComponent c)
	{
		this.gui.addComponent(c);
	}
	@Override
	public void inform(IEvent e) {
		if (e.getClass() == CloseEvent.class)
		{
			if (((CloseEvent)e).frame == this)
			{
				this.setVisible(false);
				this.dispose();
			}
		}

	}
}
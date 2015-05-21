package fr.utbm.info.gl52.Graphics.Frame;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fr.utbm.info.gl52.Graphics.AbstractComponent;
import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;
import fr.utbm.info.gl52.Graphics.Bus.BusComponent;
import fr.utbm.info.gl52.Graphics.Bus.YellowBus;
import fr.utbm.info.gl52.Graphics.Buttons.AddBusButton;
import fr.utbm.info.gl52.Graphics.Layout.AbstractLayout;
import fr.utbm.info.gl52.Graphics.Layout.LayoutGUI;
import fr.utbm.info.gl52.Graphics.Layout.LayoutMap;


/**
 * 
 */
public abstract class AbstractFrame extends JFrame implements IFrame, MouseListener, MouseMotionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
	protected AbstractLayout<AbstractComponent> gui;
	protected AbstractLayout<AbstractGraphicElement> map;
	
	protected JPanel mainPanel;
	private int x, y;
	private int locationX=0, locationY=0;
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
                
    	gui = new LayoutGUI<AbstractComponent>(300, 300);
    	map = new LayoutMap<AbstractGraphicElement>(2000, 2000);
    	
    	
    	jlp.setPreferredSize(new Dimension(h, w));
        
    	for (int i = 0; i < 1000; i++)
    	{
    		int rx = (int)(Math.random()*3000);
    		int ry = (int)(Math.random()*3000);
    		map.addComponent(new YellowBus(rx, ry));
    	}
    		//        gui.addComponent(test);
    	        
        jlp.add(map, new Integer(0));
        jlp.add(gui, new Integer(1));
        

        super.addMouseListener(this);

        this.addMouseMotionListener(this);
    	this.setContentPane(jlp);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseDragged(MouseEvent e) {
		    int newX = map.getX() - (x-e.getX());
	        int newY = map.getY() - (y-e.getY());
	        newX = (newX > 0) ? 0 : newX;
	        newY = (newY > 0) ? 0 : newY;
	        if (Math.abs(newX)+this.getWidth() > map.getWidth())
	        	newX = this.getWidth()-map.getWidth();
	        if (Math.abs(newY)+this.getHeight() > map.getHeight())
	        	newY = this.getHeight()-map.getHeight();
	        
	        map.setLocation(newX, newY);
	        x = e.getX();
	        y = e.getY();
	}
	@Override
	public void mouseMoved(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    

}
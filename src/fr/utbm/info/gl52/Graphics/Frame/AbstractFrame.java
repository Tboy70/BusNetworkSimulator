package fr.utbm.info.gl52.Graphics.Frame;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fr.utbm.info.gl52.Graphics.AbstractComponent;
import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;
import fr.utbm.info.gl52.Graphics.Bus.YellowBus;
import fr.utbm.info.gl52.Graphics.Buttons.AddBusButton;
import fr.utbm.info.gl52.Graphics.Layout.AbstractLayout;
import fr.utbm.info.gl52.Graphics.Layout.LayoutGUI;
import fr.utbm.info.gl52.Graphics.Layout.LayoutMap;
import fr.utbm.info.gl52.Graphics.Road.BicyclePathComponent;
import fr.utbm.info.gl52.Graphics.Road.HighwayComponent;


public abstract class AbstractFrame extends JFrame implements IFrame, MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	protected AbstractLayout<AbstractComponent> gui;
	protected AbstractLayout<AbstractGraphicElement> map;
	
	protected JPanel mainPanel;
	private int x, y;
	private int locationX=0, locationY=0;
    public AbstractFrame(String title, int h,  int w) {
    	super(title);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(new Point(20,20));;
        
        setSize(700,700);
        setVisible(true);
    	mainPanel = new JPanel();
    	
    	AbstractComponent test = new AddBusButton("", 10, 0, 16, 16);
        JLayeredPane jlp = new JLayeredPane(); 
    	gui = new LayoutGUI<AbstractComponent>(300, 300);
    	map = new LayoutMap<AbstractGraphicElement>(2000, 2000);

        //gui.add(test.getSwingComponent());
        int[] px = {10, 50, 350};
        int[] py = {10, 50, 400};
        
        int[] bpx = {10, 100, 350};
        int[] bpy = {10, 50, 400};
        
        
    	map.addComponent(new HighwayComponent(px, py));
    	map.addComponent(new BicyclePathComponent(bpx, bpy));
    	
    	jlp.setPreferredSize(new Dimension(h, w));
        
    	map.addComponent(new YellowBus(10, 10));
    	map.addComponent(new YellowBus(50, 50));
    	map.addComponent(new YellowBus(350, 400));
    	
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
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
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
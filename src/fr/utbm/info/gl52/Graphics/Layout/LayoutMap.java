package fr.utbm.info.gl52.Graphics.Layout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Event.LeftClicEvent;
import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;


/**
 * 
 */
public class LayoutMap<C extends AbstractGraphicElement> extends AbstractLayout<C> implements MouseListener, MouseMotionListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int HIT_BOX_SIZE = 5;
	private int x, y;
	public LayoutMap(int h, int w) {
		super(h, w);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		// TODO Auto-generated constructor stub
	}
	public void addComponent(C c) {
		listComponents.add(c);
	}

	@Override
	public void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D)g;
		g2d.scale(zoom/100, zoom/100);
		g2d.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, width, height);
		for(C c: listComponents)
			c.draw(g);
		g2d.scale(1,1);
		g2d.dispose();
		//super.paintComponent(g);
	}
	public AbstractGraphicElement actionClick(int x, int y)
	{
		Shape ellipse = new Ellipse2D.Double(x, y, 8, 8);

		for(AbstractGraphicElement e: listComponents)
		{
			if (e.intersect(ellipse)) {
				return e;
			}		
		}
		return null;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
		x = e.getX();
		y = e.getY();

        int pX = (int) ((x) / (getZoom()/100));
        int pY = (int) ((y) / (getZoom()/100)) ;
        EventService.getInstance().publish(new LeftClicEvent(pX, pY));
        System.out.println("Source:"+actionClick(pX,pY));
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	    int newX = getX() - (x-e.getX());
        int newY = getY() - (y-e.getY());
        setLocation(newX, newY);
        repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}

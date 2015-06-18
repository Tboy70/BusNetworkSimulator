package fr.utbm.info.gl52.Graphics.Itinerary;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

import javax.swing.JComponent;

import fr.utbm.info.gl52.Collection.graph.INode;
import fr.utbm.info.gl52.Collection.graph.Node;
import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;
import fr.utbm.info.gl52.Middle.Itineraire;
import fr.utbm.info.gl52.Middle.Segment;
import fr.utbm.info.gl52.Middle.Stop;
import fr.utbm.info.gl52.Parser.util.ESRISpatialObject;
import fr.utbm.set.io.shape.ESRIBounds;

public abstract class AbstractGraphicItinerary extends AbstractGraphicElement{

	protected Itineraire it = null;
	protected Point offset = null;
	protected Color col = null;
	protected Point naturalOffset = null;
	public AbstractGraphicItinerary(Itineraire iti, Point off, Color c, ESRIBounds b)
	{
		this.it = iti;
		this.offset = off;
		this.col = c;
		this.naturalOffset = new Point();
		this.naturalOffset.setLocation(b.minx, b.miny);
	}
	@Override
	public boolean intersect(Shape r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int i = 0;
		for(Segment<?> seg : this.it.getlRoute())
		{
			++i;
			INode<ESRISpatialObject> A = (Node<ESRISpatialObject>)seg.getNodeA();
			INode<ESRISpatialObject> B = (Node<ESRISpatialObject>)seg.getNodeB();
			Point pt1 = new Point();
			pt1.setLocation(A.getData().x, A.getData().y);
			pt1.translate(-naturalOffset.x, -naturalOffset.y);
//			pt1.translate(offset.x, offset.y);
			
			Point pt2 = new Point();
			pt2.setLocation(B.getData().x, B.getData().y);
			pt2.translate(-naturalOffset.x, -naturalOffset.y);
//			pt2.translate(offset.x, offset.y);

			g2d.setStroke(new BasicStroke(1.5f));
			g2d.setColor(this.col);
//			System.out.println("Route "+ i + "Pt1:"+pt1.x+"/"+pt1.y+" | Pt2:"+pt2.x+"/"+pt2.y);
			g2d.drawLine(pt1.x, pt1.y, pt2.x, pt2.y);
		}/*
		Stop s;
		for (i = 0; i < this.it.getNbStop(); ++i)
		{
			s = this.it.getStop(i);
			Point pt = new Point();
			int x = (int) ((((100 - s.getPourcentage())/100 * ((Node<ESRISpatialObject>)s.getEdge().getNodeA()).getData().getX()))
					+ ((s.getPourcentage())/100 * ((Node<ESRISpatialObject>)s.getEdge().getNodeB()).getData().getX())) - naturalOffset.x;
			int y = (int) ((((100 - s.getPourcentage())/100 * ((Node<ESRISpatialObject>)s.getEdge().getNodeA()).getData().getY()))
					+ ((s.getPourcentage())/100 * ((Node<ESRISpatialObject>)s.getEdge().getNodeB()).getData().getY())) - naturalOffset.y;
			g2d.setColor(Color.blue);
			g2d.fillOval(x-4, y-4, 8, 8);
		}*/
		//System.out.println("Nombre de routes:"+i);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JComponent getSwingComponent() {
		// TODO Auto-generated method stub
		return null;
	}

}

package fr.utbm.info.gl52.Graphics.Itinerary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

import fr.utbm.info.gl52.Collection.graph.Node;
import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;
import fr.utbm.info.gl52.Middle.Stop;
import fr.utbm.info.gl52.Parser.util.ESRISpatialObject;

public class GraphicStop extends AbstractGraphicElement {
	private static final long serialVersionUID = -5870536476809951076L;
	private Stop s;
	private Point naturalOffset;
	private Shape shape;
	public GraphicStop(Stop ss, Point offset)
	{
		this.s = ss;
		this.naturalOffset = offset;
		
		new Point();
		int x = (int) ((((100 - this.s.getPourcentage())/100 * ((Node<ESRISpatialObject>)this.s.getEdge().getNodeA()).getData().getX()))
				+ ((this.s.getPourcentage())/100 * ((Node<ESRISpatialObject>)this.s.getEdge().getNodeB()).getData().getX())) - this.naturalOffset.x;
		int y = (int) ((((100 - this.s.getPourcentage())/100 * ((Node<ESRISpatialObject>)this.s.getEdge().getNodeA()).getData().getY()))
				+ ((this.s.getPourcentage())/100 * ((Node<ESRISpatialObject>)this.s.getEdge().getNodeB()).getData().getY())) - this.naturalOffset.y;
		//System.out.println("x:"+x+" y:"+y);
		this.shape = new Ellipse2D.Double(x-4, y-4, 8, 8);
	}
	
	public void setStop(Stop ss)
	{
		this.s = ss;
	}
	public Stop getStop()
	{
		return this.s;
	}
	
	@Override
	public boolean intersect(Shape r) {
		return r.intersects(this.shape.getBounds2D());
	}

	@Override
	public void draw(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.blue);
		g2d.fill(this.shape);
	}
	public static Point projection(Point A, Point B, Point P)
	{
		float xA = A.x;
		float yA = A.y;
		float xB = B.x;
		float yB = B.y;
		
		float a = (yB - yA) / (xB - xA);
		float b = yA - a * xA;
		System.out.println(a+"x + "+b);
		Point p = new Point();
		
		float xP = (P.x - a*b + a * P.y) / ( 1.0f + a * a );
		float yP = b + a * (P.x - a*b + a * P.y) / (1.0f + a * a);
		
		p.setLocation(xP, yP);
		
		return p;
	}
	public void dragAndDrop(Point p)
	{
		float xA = (float) (((Node<ESRISpatialObject>)this.s.getEdge().getNodeA()).getData().getX());
		float yA = (float) (((Node<ESRISpatialObject>)this.s.getEdge().getNodeA()).getData().getY());
		
		float xB = (float) (((Node<ESRISpatialObject>)this.s.getEdge().getNodeB()).getData().getX());
		float yB = (float) (((Node<ESRISpatialObject>)this.s.getEdge().getNodeB()).getData().getY());
		
		Point A = new Point();
		A.setLocation(xA, yA);
		A.translate(- this.naturalOffset.x, - this.naturalOffset.y);
		Point B = new Point();
		B.setLocation(xB, yB);
		B.translate(- this.naturalOffset.x, - this.naturalOffset.y);
		Point pFinal = projection(A, B, p);
		
		xA = A.x;
		xB = B.x;
		yA = A.y;
		yB = B.y;

		float xP = pFinal.x;
		float yP = pFinal.y;
		float distance = (xP - xA) * (xP - xA) + (yP - yA) * (yP - yA);
		distance = (float) Math.sqrt(distance);
		float fullDistance = (xB - xA) * (xB - xA) + (yB - yA) * (yB - yA);
		fullDistance = (float) Math.sqrt(fullDistance);
		int pourcentage = (int) ((100 * distance) / fullDistance);
		if (pourcentage <= 100 && pourcentage >= 0)
		{
			System.out.println(""+pourcentage+"%");
			this.s.setPourcentage(pourcentage);
			this.shape = new Ellipse2D.Double(pFinal.x-4, pFinal.y-4, 8, 8);
			this.revalidate();
		}
	}
	@Override
	public void update() {
		// Not used
	}

	@Override
	public JComponent getSwingComponent() {
		return null;
	}

}

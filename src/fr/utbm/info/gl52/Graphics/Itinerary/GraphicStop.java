package fr.utbm.info.gl52.Graphics.Itinerary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.Node;
import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;
import fr.utbm.info.gl52.Middle.Stop;
import fr.utbm.info.gl52.Parser.util.ESRISpatialObject;

public class GraphicStop extends AbstractGraphicElement {

	private Stop s;
	private Point naturalOffset;
	private Shape shape;
	public GraphicStop(Stop ss, Point offset)
	{
		this.s = ss;
		this.naturalOffset = offset;
		
		Point pt = new Point();
		int x = (int) ((((100 - s.getPourcentage())/100 * ((Node<ESRISpatialObject>)s.getEdge().getNodeA()).getData().getX()))
				+ ((s.getPourcentage())/100 * ((Node<ESRISpatialObject>)s.getEdge().getNodeB()).getData().getX())) - naturalOffset.x;
		int y = (int) ((((100 - s.getPourcentage())/100 * ((Node<ESRISpatialObject>)s.getEdge().getNodeA()).getData().getY()))
				+ ((s.getPourcentage())/100 * ((Node<ESRISpatialObject>)s.getEdge().getNodeB()).getData().getY())) - naturalOffset.y;
		//System.out.println("x:"+x+" y:"+y);
		this.shape = new Ellipse2D.Double(x-4, y-4, 8, 8);
	}
	
	public void setStop(Stop ss)
	{
		this.s = s;
	}
	public Stop getStop()
	{
		return s;
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
	public Point projection(Point A, Point B, Point P)
	{
		float xA = A.x;
		float yA = A.y;
		float xB = B.x;
		float yB = B.y;
		
		float a = (yB - yA) / (xB - xA);
		float b = yA - a * xA;
		Point p = new Point();
		
		float xP = (P.x - a*b + a * P.y) / ( 1.0f + a * a );
		float yP = b + a * (P.x - a*b + a * P.y) / (1.0f + a * a);
		
		p.setLocation(xP, yP);
		
		return p;
	}
	public Point projection(float xA, float yA, float xB, float yB, float xP, float yP)
	{
		Point A = new Point();
		A.setLocation(xA, yA);
		Point B = new Point();
		B.setLocation(xB, yB);
		Point P = new Point();
		P.setLocation(xP, yP);
		return this.projection(A,B,P);
	}
	public void dragAndDrop(Point p)
	{
		float xA = (float) (((Node<ESRISpatialObject>)s.getEdge().getNodeA()).getData().getX());
		float yA = (float) (((Node<ESRISpatialObject>)s.getEdge().getNodeA()).getData().getY());
		
		float xB = (float) (((Node<ESRISpatialObject>)s.getEdge().getNodeB()).getData().getX());
		float yB = (float) (((Node<ESRISpatialObject>)s.getEdge().getNodeB()).getData().getY());
		
		Point A = new Point();
		A.setLocation(xA, yA);
		A.translate(- naturalOffset.x, - naturalOffset.y);
		
		Point B = new Point();
		B.setLocation(xB, yB);
		B.translate(- naturalOffset.x, - naturalOffset.y);
		Point pFinal = projection(A, B, p);
		
		xA = A.x;
		xB = B.x;
		yA = A.y;
		yB = B.y;

		float xP = pFinal.x;
		float yP = pFinal.y;
		
		float     distance = (float) Point.distance(xA,  yA, xP,  yP);
		float    distanceB = (float) Point.distance(xB,  yB, xP,  yP);
		float fullDistance = (float) Point.distance(xA,  yA, xB,  yB);
		int    pourcentage = (int) ((100 * distance) / fullDistance);

		System.out.println("p:"+pourcentage);
		System.out.println("D:"+distance+" / Db:"+distanceB + " / fD:"+fullDistance);
		System.out.println("D+Db:"+(distance+distanceB));
		
		if (pourcentage >= 0 && (distance+distanceB) <= fullDistance + 0.01f)
		{
			this.s.setPourcentage(pourcentage);
			this.shape = new Ellipse2D.Double(pFinal.x-4, pFinal.y-4, 8, 8);
		}
		else if (pourcentage == 0)
		{
			float minDistance = 1000000000000000.0f;
			IEdge newEdge = null;
			for (IEdge e : ((Node<ESRISpatialObject>)s.getEdge().getNodeA()).getEdges())
			{
				//TODO Parcourir la liste et récupérer le segment le plus proche dans le noeud de fin est getNodeA()
				if (((Node<ESRISpatialObject>)s.getEdge().getNodeA()) == e.getNodeB())
				{
					float xC = (float) (((Node<ESRISpatialObject>)e.getNodeA()).getData().getX());
					float yC = (float) (((Node<ESRISpatialObject>)e.getNodeA()).getData().getY());
					
					Point C = new Point();
					C.setLocation(xC, yC);
					C.translate(- naturalOffset.x, - naturalOffset.y);
					
					Point D = this.projection(A,C,p);
					if (Point.distance(D.x, D.y, C.x, C.y) <= minDistance)
					{
						minDistance = (float) Point.distance(D.x, D.y, C.x, C.y);
						newEdge = e;
					}
				}
			}
			if (newEdge != null)
			{
				this.s.setEdge(newEdge);
				this.s.setPourcentage(100);
			}
		}
		else if ((distance+distanceB) > fullDistance + 0.01f)
		{
			for (IEdge e : ((Node<ESRISpatialObject>)s.getEdge().getNodeB()).getEdges())
			{
				//TODO Parcourir la liste et récupérer le segment le plus proche dans le noeud de debut est getNodeB()
			}			
		}
		
	}
	@Override
	public void update() {
	}

	@Override
	public JComponent getSwingComponent() {
		return null;
	}

}

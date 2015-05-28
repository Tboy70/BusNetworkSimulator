package fr.utbm.info.gl52.Parser.util;

import java.awt.Shape;
import java.awt.geom.Line2D;

import fr.utbm.info.gl52.Collection.SpatialObject;
import fr.utbm.set.io.shape.ESRIPoint;

public class ESRISpatialObject extends ESRIPoint implements SpatialObject{

	private static final long serialVersionUID = -2351678631182500955L;
	
	public ESRISpatialObject(ESRIPoint p) {
		super(p);
	}

	@Override
	public Shape getShape() {
		Shape s = new Line2D.Double(this.getX(), this.getY(),this.getX(),this.getY());
		return s;
	}

	@Override
	public void setShape(Shape s) {
		this.setX(s.getBounds().getX());
		this.setX(s.getBounds().getY());
	}

}

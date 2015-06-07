package fr.utbm.info.gl52.Graphics.Itinerary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

import javax.swing.JComponent;

import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;
import fr.utbm.info.gl52.Middle.Itineraire;
import fr.utbm.info.gl52.Middle.Segment;

public abstract class AbstractGraphicItinerary extends AbstractGraphicElement{

	protected Itineraire it = null;
	protected Point offset = null;
	protected Color col = null;
	public AbstractGraphicItinerary(Itineraire iti, Point off, Color c)
	{
		this.it = iti;
		this.offset = off;
		this.col = c;
	}
	@Override
	public boolean intersect(Shape r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		for(Segment seg : this.it.getlRoute())
		{

		}
		
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

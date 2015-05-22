package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ButtonModel;

import fr.utbm.info.gl52.Graphics.CardinalSystem;
import fr.utbm.info.gl52.Graphics.Layout.AbstractLayout;

public class ZoomButton extends ButtonComponent {

	protected double zoomFactor;
	public ZoomButton(String text, int x, int y, int h, int w, double zoom) {
		super(text, x, y, h, w);
		zoomFactor = zoom;
		// TODO Auto-generated constructor stub
	}
	public ZoomButton(String text, int x, int y, int h, int w, CardinalSystem p, double zoom) {
		super(text, x, y, h, w, p);
		zoomFactor = zoom;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(ActionEvent evt) {
		// TODO Auto-generated method stub
		if (m != null)
		{
			m.zoom(zoomFactor);
			m.repaint();
		}
	}
}

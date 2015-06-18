package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;

public class GraphicButton extends JButton  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2889193335246290667L;

	private boolean selected = false;
	public GraphicButton(String t)
	{
		super(t);
	}
	public void click() {
		selected = !selected;
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.clearRect(0, 0, getWidth(), getHeight());
		g2.setStroke(new BasicStroke(0));

		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f)); 

		g2.setColor(new Color(6, 113, 154));
		if (this.getModel().isRollover())
			g2.setColor(new Color(19, 43, 168));
		if(this.getModel().isPressed())
			g2.setColor(new Color(246, 175,0));
		if(this.getModel().isSelected() || selected)
			g2.setColor(new Color(246, 128, 0));
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.setColor(Color.white);
		// Finding size of text so can position in center. 
		FontRenderContext frc = new FontRenderContext(null, false, false);
		Rectangle2D r = getFont().getStringBounds(getText(), frc); 
		float xMargin = (float)(getWidth()-r.getWidth())/2;
		float yMargin = (float)(getHeight()-getFont().getSize())/2;
		// Draw the text in the center 
		g2.drawString(getText(), xMargin, getFont().getSize() + yMargin);
		g2.dispose();
		//super.paintComponent(g);
	}

	/**
	 * @param evt Not used here, changing just colors when entering 
	 */
	public void mouseEntered(java.awt.event.MouseEvent evt) {
		this.setBackground(Color.GREEN);
	}

	/**
	 * @param evt Not used here, changing just colors when exiting
	 */
	public void mouseExited(java.awt.event.MouseEvent evt) {
		this.setBackground(Color.cyan);
	}

}

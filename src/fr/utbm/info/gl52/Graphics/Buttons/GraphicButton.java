package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;

public class GraphicButton extends JButton {

	public GraphicButton(String t)
	{
		super(t);
	}


	  protected void paintComponent(Graphics g) {
	      Graphics2D g2 = (Graphics2D) g;
	      g2.clearRect(0, 0, getWidth(), getHeight());
	      g2.setStroke(new BasicStroke(0));

	       g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f)); 
	      if (this.getModel().isRollover())
	    	  g2.setColor(Color.cyan);
	      else if(this.getModel().isPressed())
	    	  g2.setColor(Color.red);
	      else if(this.getModel().isSelected())
	    	  g2.setColor(Color.green);
	      else
	    	  g2.setColor(Color.LIGHT_GRAY);
		   g2.fillRect(0, 0, getWidth(), getHeight());
		   g2.setColor(Color.white);
	      // Finding size of text so can position in center. 
	      FontRenderContext frc = new FontRenderContext(null, false, false);
	      Rectangle2D r = getFont().getStringBounds(getText(), frc); 
	      float xMargin = (float)(getWidth()-r.getWidth())/2;
	      float yMargin = (float)(getHeight()-getFont().getSize())/2;
	      // Draw the text in the center 
	      g2.drawString(getText(), xMargin, (float)getFont().getSize() + yMargin);
	      g2.dispose();
	      //super.paintComponent(g);
	   }
}

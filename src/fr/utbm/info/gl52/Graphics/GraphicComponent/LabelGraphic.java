package fr.utbm.info.gl52.Graphics.GraphicComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.swing.JPanel;

public class LabelGraphic extends JPanel {

	private String message;
	private int x, y, m_start, m_end;
	private AttributedCharacterIterator m_iterator;
	public LabelGraphic(String message,int x, int y, int h, int w)
	{
		super();
		this.setBounds(x,y,h,w);
		this.message = message;
		this.x = x;
		this.y = y;

        AttributedString styledText = new AttributedString(message);
        this.m_iterator = styledText.getIterator();
        this.m_start = this.m_iterator.getBeginIndex();
        this.m_end = this.m_iterator.getEndIndex();
	}
	protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        FontRenderContext frc = g2.getFontRenderContext();

		g2.setColor(new Color(6, 113, 154));
        LineBreakMeasurer measurer = new LineBreakMeasurer(this.m_iterator, frc);
        measurer.setPosition(this.m_start);

        float x1 = 0, y1 = 0;
        while (measurer.getPosition() < this.m_end)
        {
            TextLayout layout = measurer.nextLayout(this.getWidth());

            y1 += layout.getAscent();
            float dx = layout.isLeftToRight() ?
                    0 : this.getWidth() - layout.getAdvance();

            layout.draw(g2, x1 + dx, y1);
            y1 += layout.getDescent() + layout.getLeading();
        }
		}
	
}

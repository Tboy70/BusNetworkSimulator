package fr.utbm.info.gl52.Graphics.Layout;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.SwingUtilities;

import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;
import fr.utbm.info.gl52.Graphics.Itinerary.GraphicStop;

public class MouseManager implements MouseListener, MouseMotionListener,
		MouseWheelListener {
	private int x, y;
	private List<AbstractLayout<?>> l;
	public static boolean bModify = false;
	public GraphicStop selected;
	public MouseManager(int x, int y) {
		this.x = x;
		this.y = y;
		this.l = new ArrayList<>();
	}

	public void add(AbstractLayout<?> al) {
		this.l.add(al);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Not used for now
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.x = e.getX();
		this.y = e.getY();
		if (!bModify||SwingUtilities.isRightMouseButton(e)) {
			for (AbstractLayout<?> al : this.l)
				System.out.println("Source:" + al.actionClick(this.x, this.y));
		}
		else
		{
			Collection<AbstractGraphicElement> c = new ArrayList<>();
			for (AbstractLayout<?> al : this.l)
				c.addAll(al.actionClick(this.x, this.y));
			this.selected = null;
			for (AbstractGraphicElement age : c)
			{
				if (age instanceof GraphicStop)
				{
					this.selected = (GraphicStop) age;
					age.select();
					break;
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Not used for now
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Not used for now
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Not used for now
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int newX = (this.x - e.getX());
		int newY = (this.y - e.getY());

		if (!bModify||SwingUtilities.isRightMouseButton(e)) {
			for (AbstractLayout<?> al : this.l) {
				al.setLocation((int) al.getLocation().getX() - newX, (int) al
						.getLocation().getY() - newY);
				al.repaint();
			}
		}
		else
		{
			if (this.selected != null)
			{
				Point p = new Point();
				for (AbstractLayout<?> al : this.l) {
					if (al instanceof LayoutNetwork)
						p.setLocation((int) al.getLocation().getX() + e.getX(), (int) al.getLocation().getY() + e.getY());
					//al.repaint();
				}

				//Point p = new Point();
				//p.setLocation(e.getX(), e.getY());
				System.out.println("----x"+p);
				this.selected.dragAndDrop(p);
			}
		}
		this.x = e.getX();
		this.y = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
			for (AbstractLayout<?> al : this.l)
				al.zoom(e.getUnitsToScroll());

		}

	}

}

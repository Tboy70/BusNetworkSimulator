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

import fr.utbm.info.gl52.Event.AddStopEvent;
import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Graphics.AbstractGraphicElement;
import fr.utbm.info.gl52.Graphics.Controller;
import fr.utbm.info.gl52.Graphics.GraphicsLaunch;
import fr.utbm.info.gl52.Graphics.Itinerary.GraphicStop;
import fr.utbm.info.gl52.Graphics.Road.RoadComponent;
import fr.utbm.info.gl52.Middle.Segment;
import fr.utbm.info.gl52.Middle.Stop;

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
		if (!bModify || SwingUtilities.isRightMouseButton(e)) {
			for (AbstractLayout<?> al : this.l)
				System.out.println("Source:" + al.actionClick(this.x, this.y));
		} else {
			Collection<AbstractGraphicElement> c = new ArrayList<AbstractGraphicElement>();
			for (AbstractLayout<?> al : this.l)
				c.addAll(al.actionClick(this.x, this.y));
			selected = null;
			RoadComponent road = null;
			for (AbstractGraphicElement age : c) {
				if (age instanceof GraphicStop) {
					selected = (GraphicStop) age;
					age.select();
					//break;
				} else if (age instanceof RoadComponent) {
					road = (RoadComponent) age;
				}
			}
			if (e.isControlDown()) {
				if (road != null) {
					if (Controller.getInstance().getItineraire() != null) {
						if (Controller
								.getInstance()
								.getItineraire()
								.getlRoute()
								.containsAll(
										road.getPolyline().getListSegment())) {
							Controller
									.getInstance()
									.getItineraire()
									.getlRoute()
									.removeAll(
											road.getPolyline().getListSegment());
						} else {
							Controller
									.getInstance()
									.getItineraire()
									.getlRoute()
									.addAll(road.getPolyline().getListSegment());
						}
					}
				}
								}
			if (selected == null) {
				if (e.isShiftDown() && e.getClickCount() >= 2) {
					if (road != null) {
						if (Controller.getInstance().getItineraire() != null) {
							if (Controller
									.getInstance()
									.getItineraire()
									.getlRoute()
									.containsAll(
											road.getPolyline()
													.getListSegment())) {
								Point p = new Point();
								for (AbstractLayout<?> al : this.l) {
									if (al instanceof LayoutNetwork)
										p.setLocation((int) al.getLocation().getX() + e.getX(),
												(int) al.getLocation().getY() + e.getY());
								}
								Point pp = p;
								p.translate(GraphicsLaunch.offset.x, GraphicsLaunch.offset.y);
								for (Segment s : road
										.getPolyline().getListSegment())
								{
									if (true)
									{
										selected = new GraphicStop(new Stop(50,s), GraphicsLaunch.offset);
										selected.dragAndDrop(p);
										EventService.getInstance().publish(new AddStopEvent(selected));
										break;
									}
								}
							}
						}
					}
				}
			}
			else
			{
				if (e.getClickCount() >= 2)
				{
					c.remove(selected);
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

		if (!bModify || SwingUtilities.isRightMouseButton(e)) {
			for (AbstractLayout<?> al : this.l) {
				al.setLocation((int) al.getLocation().getX() - newX, (int) al
						.getLocation().getY() - newY);
				al.repaint();
			}
		} else {
			if (selected != null) {
				Point p = new Point();
				for (AbstractLayout<?> al : this.l) {
					if (al instanceof LayoutNetwork)
						p.setLocation((int) al.getLocation().getX() + e.getX(),
								(int) al.getLocation().getY() + e.getY());
				}

				selected.dragAndDrop(p);
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

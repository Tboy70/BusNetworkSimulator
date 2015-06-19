package fr.utbm.info.gl52.Graphics.Frame;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.utbm.info.gl52.Event.DisplayBusLineEvent;
import fr.utbm.info.gl52.Event.DisplayItEvent;
import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Graphics.GraphicsLaunch;
import fr.utbm.info.gl52.Middle.BusLine;
import fr.utbm.info.gl52.Middle.BusNetwork;
import fr.utbm.info.gl52.Middle.JTableBusLineModel;
import fr.utbm.info.gl52.Middle.JTableItModel;

public class DataWindow extends AbstractFrame {
	private static final long serialVersionUID = -8026439744221193590L;
	
	private JTable table;
	
	private JTableBusLineModel busLine;
	
	private JTableItModel it;
	
	private JScrollPane jscroll; // Panel
	
	private MouseAdapter mouseBusline = new MouseAdapter() {
		@Override
		public synchronized void mouseClicked(MouseEvent e){
			int row = DataWindow.this.table.rowAtPoint(e.getPoint());
			DataWindow.this.table.columnAtPoint(e.getPoint());
			if(e.getClickCount() >= 2){ // handle double click
				goToIt(row);
			}else{ // Single click
				DisplayBusLineEvent l = new DisplayBusLineEvent(busLine.getBusLineAt(row));
				EventService.getInstance().publish(l);
			}
		}
	};
	
	private MouseAdapter mouseIt = new MouseAdapter() {
		@Override
		public synchronized void mouseClicked(MouseEvent e){
			int row = DataWindow.this.table.rowAtPoint(e.getPoint());
			DataWindow.this.table.columnAtPoint(e.getPoint());
			if(e.getClickCount() >= 2){ // handle double click
				// ???
			}else{ // Single click
				DisplayItEvent l = new DisplayItEvent(it.getItAt(row));
				EventService.getInstance().publish(l);
			}
		}
	};

	
	
	public DataWindow(String title, int h, int w) {
		super(title, h, w);
		
		// New model
		this.busLine = new JTableBusLineModel(); 
		
		// Create new table
		this.table = new JTable(this.busLine);
		
		this.jscroll = new JScrollPane(this.table);
		
		// Add it to layout
		getContentPane().add(this.jscroll, BorderLayout.CENTER);
		
		this.table.addMouseListener(this.mouseBusline);
		
		// Define the minimum size of the window
		this.pack();
		this.setLocation(GraphicsLaunch.getPositionOffset());
	}

	private synchronized void goToIt(int row){		
		this.it = new JTableItModel(this.busLine.getBusLineAt(row));
		
		this.jscroll.remove(this.table);
		getContentPane().remove(this.jscroll);
		
		this.table = new JTable(this.it);
		this.table.addMouseListener(this.mouseIt);
		this.jscroll = new JScrollPane(this.table);
		getContentPane().add(this.jscroll, BorderLayout.CENTER);
		
		this.repaint();		
		this.pack();
	}
	
	public synchronized void setData(BusNetwork net){
		this.busLine.setNet(net);
	}
	
	public synchronized void addData(BusLine message) {
		this.busLine.addBusLine(message);
		this.repaint();
		this.revalidate();
	}
}

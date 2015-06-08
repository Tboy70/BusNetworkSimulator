package fr.utbm.info.gl52.Graphics.Frame;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.utbm.info.gl52.Middle.BusLine;
import fr.utbm.info.gl52.Middle.BusNetwork;
import fr.utbm.info.gl52.Middle.JTableBusLineModel;

public class DataWindow extends AbstractFrame {
	private static final long serialVersionUID = -8026439744221193590L;
	
	private JTable table;
	
	private JTableBusLineModel busLine;
	
	private MouseAdapter mouse = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e){
			int row = table.rowAtPoint(e.getPoint());
			int col = table.columnAtPoint(e.getPoint());
			if(e.getClickCount() >= 2){ // handle double click
				// Go to itineraire
			}else{ // Single click
				// TODO display traffic
			}
		}
	};
	
	public DataWindow(String title, int h, int w) {
		super(title, h, w);
		
		// New model
		this.busLine = new JTableBusLineModel(); 
		
		// Create new table
		this.table = new JTable(this.busLine);
		
		// Add it to layout
		getContentPane().add(new JScrollPane(this.table), BorderLayout.CENTER);
		
		this.table.addMouseListener(mouse);
		
		// Define the minimum size of the window
		this.pack();
	}

	public void setData(BusNetwork net){
		this.busLine.setNet(net);
	}
	
	public void addData(BusLine message) {
		this.busLine.addBusLine(message);
		this.repaint();
		this.revalidate();
	}
	
	

}

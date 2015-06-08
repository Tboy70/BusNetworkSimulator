package fr.utbm.info.gl52.Graphics.Frame;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.utbm.info.gl52.Middle.BusLine;
import fr.utbm.info.gl52.Middle.BusNetwork;
import fr.utbm.info.gl52.Middle.JTableBusLineModel;

public class DataWindow extends AbstractFrame {
	private static final long serialVersionUID = -8026439744221193590L;
	
	private JTable table;
	
	private JTableBusLineModel busLine;
	
	public DataWindow(String title, int h, int w) {
		super(title, h, w);
		
		this.busLine = new JTableBusLineModel(); 
		
		// Create new table
		this.table = new JTable(this.busLine);
		
		// Add it to layout
		getContentPane().add(new JScrollPane(this.table), BorderLayout.CENTER);
		
		// Define the minimum size
		this.pack();
	}

	public void setData(BusNetwork net){
		this.busLine.setNet(net);
	}
	
	public void addData(BusLine message) {
		this.busLine.addBusLine(message);
	}
	
	

}

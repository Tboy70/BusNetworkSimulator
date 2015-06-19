package fr.utbm.info.gl52.Graphics.Frame;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.utbm.info.gl52.Graphics.GraphicsLaunch;
import fr.utbm.info.gl52.Middle.JTableTimeTableModel;
import fr.utbm.info.gl52.Middle.TimeTable;

public class TimeTableWindow extends AbstractFrame {
	private static final long serialVersionUID = -8026439744221193590L;
	
	private JTable table;
	
	private JScrollPane jscroll; // Panel
	
	private JTableTimeTableModel ttModel;
	
	public TimeTableWindow(String title, int h, int w) {
		super(title, h, w);
		
		this.ttModel = new JTableTimeTableModel(new TimeTable());
		this.table = new JTable(this.ttModel);
		this.jscroll = new JScrollPane(this.table);
		
		
		
		// Add it to layout
		getContentPane().add(this.jscroll, BorderLayout.CENTER);
		
		// Define the minimum size of the window
		this.pack();
		this.setLocation(GraphicsLaunch.getPositionOffsetTT());
	}
}

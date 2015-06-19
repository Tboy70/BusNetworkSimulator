package fr.utbm.info.gl52.Graphics.Frame;

import java.awt.BorderLayout;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.utbm.info.gl52.Collection.graph.Edge;
import fr.utbm.info.gl52.Graphics.GraphicsLaunch;
import fr.utbm.info.gl52.Middle.JTableTimeTableModel;
import fr.utbm.info.gl52.Middle.Stop;
import fr.utbm.info.gl52.Middle.TimeTable;

public class TimeTableWindow extends AbstractFrame {
	private static final long serialVersionUID = -8026439744221193590L;
	
	private JTable table;
	
	private JScrollPane jscroll; // Panel
	
	private JTableTimeTableModel ttModel;
	
	private TimeTable tt;
	
	public TimeTableWindow(String title, int h, int w) {
		super(title, h, w);
		
		this.tt = new TimeTable();
		
		
		List<Stop> ls = new LinkedList<>();

		List<Date> ld = new LinkedList<>();
		Stop s1 = new Stop(0, new Edge<Integer>(0));
		ld.add(new Date(2015, 06, 19, 8, 15));
		ld.add(new Date(2015, 06, 19, 8, 25));
		ld.add(new Date(2015, 06, 19, 8, 35));
		ld.add(new Date(2015, 06, 19, 8, 45));
		ld.add(new Date(2015, 06, 19, 8, 55));
		ld.add(new Date(2015, 06, 19, 8, 05));
		s1.setlTime(ld);
		s1.setName("Stop0");
		
		ld = new LinkedList<>();
		Stop s2 = new Stop(0, new Edge<Integer>(0));
		ld.add(new Date(2015, 06, 19, 8, 17));
		ld.add(new Date(2015, 06, 19, 8, 27));
		ld.add(new Date(2015, 06, 19, 8, 37));
		ld.add(new Date(2015, 06, 19, 8, 47));
		ld.add(new Date(2015, 06, 19, 8, 57));
		ld.add(new Date(2015, 06, 19, 8, 07));
		s2.setlTime(ld);
		s2.setName("Stop1");
		
		ld = new LinkedList<>();
		Stop s3 = new Stop(0, new Edge<Integer>(0));
		ld.add(new Date(2015, 06, 19, 8, 19));
		ld.add(new Date(2015, 06, 19, 8, 29));
		ld.add(new Date(2015, 06, 19, 8, 39));
		ld.add(new Date(2015, 06, 19, 8, 49));
		ld.add(new Date(2015, 06, 19, 8, 59));
		ld.add(new Date(2015, 06, 19, 8, 9));
		s3.setlTime(ld);
		s3.setName("Stop2");
		
		ls.add(s1);
		ls.add(s2);
		ls.add(s3);
		
		this.tt.setlStop(ls);
		this.ttModel = new JTableTimeTableModel(this.tt);
		this.table = new JTable(this.ttModel);
		this.jscroll = new JScrollPane(this.table);

		// Add it to layout
		getContentPane().add(this.jscroll, BorderLayout.CENTER);
		
		// Define the minimum size of the window
		this.pack();
		this.setLocation(GraphicsLaunch.getPositionOffsetTT());
	}
}

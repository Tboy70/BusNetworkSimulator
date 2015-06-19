package fr.utbm.info.gl52.Graphics.Frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import fr.utbm.info.gl52.Event.AddItineraireEvent;
import fr.utbm.info.gl52.Event.DisplayBusLineEvent;
import fr.utbm.info.gl52.Event.DisplayItEvent;
import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Graphics.GraphicsLaunch;
import fr.utbm.info.gl52.Middle.BusLine;
import fr.utbm.info.gl52.Middle.BusNetwork;
import fr.utbm.info.gl52.Middle.JTableBusLineModel;
import fr.utbm.info.gl52.Middle.JTableItModel;

public class DataWindow extends AbstractFrame{
	private static final long serialVersionUID = -8026439744221193590L;
	
	private JTable table;
	
	private JTableBusLineModel busLine;
	
	private JTableItModel it;

	private JScrollPane jscroll; // Panel

	private BusLine currentLine = null;	
	
	private MouseAdapter mouseBusline = new MouseAdapter() {
		@Override
		public synchronized void mouseClicked(MouseEvent e){
			int row = DataWindow.this.table.rowAtPoint(e.getPoint());
			int col = DataWindow.this.table.columnAtPoint(e.getPoint());
			if(e.getClickCount() >= 2){ // handle double click
				goToIt(row);
			}else{ // Single click
				DisplayBusLineEvent l = new DisplayBusLineEvent(busLine.getBusLineAt(row));
				EventService.getInstance().publish(l);
			}
		}
	};
	
	private KeyListener keyListener = new KeyListener()
	{

		@Override
		public void keyPressed(KeyEvent arg0) {
			if (arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				init();
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
		
	};
	
	private MouseAdapter mouseIt = new MouseAdapter() {
		@Override
		public synchronized void mouseClicked(MouseEvent e){
			int row = DataWindow.this.table.rowAtPoint(e.getPoint());
			int col = DataWindow.this.table.columnAtPoint(e.getPoint());
			if(e.getClickCount() >= 2){ // handle double click

			}else{ // Single click
				DisplayItEvent l = new DisplayItEvent(it.getItAt(row));
				EventService.getInstance().publish(l);
			}
		}
	};

	
	public void init()
	{
		if (busLine == null)
			this.busLine = new JTableBusLineModel(); 
		this.table = new JTable(this.busLine);
		this.jscroll = new JScrollPane(this.table);
		getContentPane().removeAll();
		this.it = null;
		
		// Add it to layout
		getContentPane().add(this.jscroll, BorderLayout.CENTER);
		
		this.table.addMouseListener(this.mouseBusline);
		// Define the minimum size of the window
		this.pack();
		currentLine = null;
				
	}
	public DataWindow(String title, int h, int w) {
		super(title, h, w);
		init();
		EventService.getInstance().subscribe(AddItineraireEvent.class, null, this);
		this.setLocation(GraphicsLaunch.getPositionOffset());
	}
	private synchronized void setTable(BusLine c)
	{
		this.it = new JTableItModel(c);
		
		this.jscroll.remove(this.table);
		getContentPane().remove(this.jscroll);
		
		this.table = new JTable(this.it);
		this.table.addMouseListener(this.mouseIt);
		

		 table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer () {
	            
			  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			        c.setBackground(it.getColor(row));
			        return c;
			    }
	        });
		
		this.jscroll = new JScrollPane(this.table);
		getContentPane().add(this.jscroll, BorderLayout.CENTER);
		
		this.repaint();		
		this.pack();

	}
	private synchronized void goToIt(int row){		
		currentLine = this.busLine.getBusLineAt(row);
		this.setTable(currentLine);
	}
	
	public synchronized void setData(BusNetwork net){
		this.busLine.setNet(net);
	}
	
	public synchronized void addData(BusLine message) {
		this.busLine.addBusLine(message);
		this.repaint();
		this.revalidate();
	}
	public void refresh()
	{
		this.table.revalidate();
		this.table.repaint();
		
		this.repaint();
		this.revalidate();
		this.pack();
	}
}

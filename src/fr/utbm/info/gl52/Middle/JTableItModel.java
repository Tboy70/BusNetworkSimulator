package fr.utbm.info.gl52.Middle;

import java.awt.Color;

import javax.swing.table.AbstractTableModel;

/**
 * [MODEL] Model used in jtable for displaying itinerary
 * @author Alexandre
 *
 */
public class JTableItModel extends AbstractTableModel {

	private static final long serialVersionUID = 4995801468434965215L;

	/**
	 * Header of the itinerary
	 */
	private final String[] entetes = {"Nom", "Nombre d'arrêt"};
	
	/**
	 * Buslines to display
	 */
	private BusLine line;

	/**
	 * Default constructor which set busline into this new object
	 * @param b
	 */
	public JTableItModel(BusLine b) {
		this.line = b;
	}
	
	@Override
	public synchronized int getColumnCount() {
		return 2; // Name ; nb of stop
	}

	@Override
	public synchronized int getRowCount() {
		return this.line.getlIti().size();
	}

	public synchronized Color getColor(int arg0)
	{
		if (arg0 >=0 && this.line.getlIti().size() > arg0)
			return this.line.getlIti().get(arg0).getColor();
		
		return Color.white;
	}
	@Override
	public synchronized Object getValueAt(int arg0, int arg1) {
		if(arg1 == 0)
			return this.line.getlIti().get(arg0).getName();
		if(arg1 == 1)
			return this.line.getlIti().get(arg0).getNbStop();
		return 0;
	}
	
	@Override
	public synchronized String getColumnName(int columnIndex) {
        return this.entetes[columnIndex];
    }
	
	/**
	 * Get itinerary at row
	 * @param row Row which is selected
	 * @return The itinerary selected
	 */
	public synchronized Itineraire getItAt(int row){
		return this.line.getlIti().get(row);
	}
	
	/**
	 * Get the bus line
	 * @return Bus line to get
	 */
	public synchronized BusLine getBus() {
		return this.line;
	}

	/**
	 * Set new busline
	 * @param l new busline to set
	 */
	public synchronized void setNet(BusLine l) {
		this.line = l;
	}

	/**
	 * Add itinerary
	 * @param message Add an itinerary to the bus line
	 */
	public synchronized void addBusLine(Itineraire message) {
		this.line.getlIti().add(message);
		this.fireTableDataChanged();
	}
}

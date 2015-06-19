package fr.utbm.info.gl52.Middle;

import javax.swing.table.AbstractTableModel;

/**
 * [Model] Used as model in jtable.
 * @author Alexandre
 *
 */
public class JTableBusLineModel extends AbstractTableModel {

	private static final long serialVersionUID = 4506575801197239466L;

	/**
	 * Header of the jtable 
	 */
	private final String[] entetes = {"N°", "Nom"};
	
	/**
	 * Network to display
	 */
	private BusNetwork net;

	/**
	 * Default constructor
	 */
	public JTableBusLineModel() {
		this.net = new BusNetwork();
	}
	
	@Override
	public synchronized int getColumnCount() {
		return 2; // N� of line ; name
	}

	@Override
	public int getRowCount() {
		return this.net.getlBusLine().size();
	}

	@Override
	public synchronized Object getValueAt(int arg0, int arg1) {
		if(arg1 == 0)
			return arg0;
		if(arg1 == 1)
			return this.net.getlBusLine().get(arg0).getName();
		return 0;
	}
	
	public synchronized BusLine getBusLineAt(int row){
		return this.net.getlBusLine().get(row);
	}
	
	@Override
	public synchronized String getColumnName(int columnIndex) {
        return this.entetes[columnIndex];
    }
	
	public synchronized BusNetwork getNet() {
		return this.net;
	}

	/**
	 * Set bus network
	 * @param net Bus network to set
	 */
	public synchronized void setNet(BusNetwork net) {
		this.net = net;
	}

	/**
	 * Add busline to network
	 * @param message Busline to add to network
	 */
	public synchronized void addBusLine(BusLine message) {
		this.net.getlBusLine().add(message);
		this.fireTableDataChanged();
	}

}

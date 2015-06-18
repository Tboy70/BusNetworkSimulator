package fr.utbm.info.gl52.Middle;

import javax.swing.table.AbstractTableModel;

public class JTableBusLineModel extends AbstractTableModel {

	private static final long serialVersionUID = 4506575801197239466L;

	private final String[] entetes = {"N°", "Nom"};
	
	private BusNetwork net;

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
			return this.net.getlBusLine().get(arg0).getNum();
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

	public synchronized void setNet(BusNetwork net) {
		this.net = net;
	}

	public synchronized void addBusLine(BusLine message) {
		this.net.getlBusLine().add(message);
		this.fireTableDataChanged();
	}

}

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
	public int getColumnCount() {
		return 2; // N° of line ; name
	}

	@Override
	public int getRowCount() {
		return this.net.getlBusLine().size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		if(arg1 == 0)
			return this.net.getlBusLine().get(arg0).getNum();
		if(arg1 == 1)
			return this.net.getlBusLine().get(arg0).getName();
		return 0;
	}
	
	public BusLine getBusLineAt(int row){
		return this.net.getlBusLine().get(row);
	}
	
	@Override
	public String getColumnName(int columnIndex) {
        return this.entetes[columnIndex];
    }
	
	public BusNetwork getNet() {
		return this.net;
	}

	public void setNet(BusNetwork net) {
		this.net = net;
	}

	public void addBusLine(BusLine message) {
		this.net.getlBusLine().add(message);
		this.fireTableDataChanged();
	}

}

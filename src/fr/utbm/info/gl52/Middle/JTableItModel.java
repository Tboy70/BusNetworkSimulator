package fr.utbm.info.gl52.Middle;

import javax.swing.table.AbstractTableModel;

public class JTableItModel extends AbstractTableModel {

	private static final long serialVersionUID = 4995801468434965215L;

	private final String[] entetes = {"Nom", "Nombre d'arrêt"};
	
	private BusLine line;

	public JTableItModel(BusLine b) {
		this.line = b;
	}
	
	@Override
	public int getColumnCount() {
		return 2; // Name ; nb of stop
	}

	@Override
	public int getRowCount() {
		return this.line.getlIti().size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		if(arg1 == 0)
			return this.line.getlIti().get(arg0).getName();
		if(arg1 == 1)
			return this.line.getlIti().get(arg0).getNbStop();
		return 0;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
        return this.entetes[columnIndex];
    }
	
	public BusLine getBus() {
		return this.line;
	}

	public void setNet(BusLine l) {
		this.line = l;
	}

	public void addBusLine(Itineraire message) {
		this.line.getlIti().add(message);
		this.fireTableDataChanged();
	}
}

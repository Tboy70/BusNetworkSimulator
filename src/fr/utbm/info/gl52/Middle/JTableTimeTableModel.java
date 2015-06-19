package fr.utbm.info.gl52.Middle;

import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * [MODEL] Model used in jtable for displaying itinerary
 * @author Alexandre
 *
 */
public class JTableTimeTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 4995801468434965215L;
	
	private TimeTable tt;

	/**
	 * Default constructor which set busline into this new object
	 * @param b
	 */
	public JTableTimeTableModel(TimeTable s) {
		this.tt = s;
	}
	
	@Override
	public synchronized int getColumnCount() {
		return this.tt.getlStop().size() - 1;
	}

	@Override
	public synchronized int getRowCount() {
		List<Stop> s = this.tt.getlStop();
		if(!this.tt.getlStop().isEmpty())
		{
			int max = s.get(0).getlTime().size();
			for(int i = 1 ; i < s.size(); ++i)
				if(max < s.get(i).getlTime().size())
					max = s.get(i).getlTime().size();
			return max;
		}
		return 0;
	}
	
	@Override
	public synchronized String getColumnName(int columnIndex) {
        return this.tt.getlStop().get(columnIndex).getName();
    }
	
	/**
	 * @return the tt
	 */
	public TimeTable getTt() {
		return this.tt;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}
}

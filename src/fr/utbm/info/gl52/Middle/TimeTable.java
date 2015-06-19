/**
 * 
 */
package fr.utbm.info.gl52.Middle;

import java.util.LinkedList;
import java.util.List;

/**
 * Defines a timetable for bus lines
 * @author Alexandre
 *
 */
public class TimeTable {

	private List<Stop> lStop;

	/**
	 * 
	 */
	public TimeTable() {
		super();
		this.lStop = new LinkedList<>();
	}

	/**
	 * @return the lStop
	 */
	public List<Stop> getlStop() {
		return this.lStop;
	}

	/**
	 * @param lStop the lStop to set
	 */
	public void setlStop(List<Stop> lStop) {
		this.lStop = lStop;
	}
	
	
	
}

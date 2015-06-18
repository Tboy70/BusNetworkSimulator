package fr.utbm.info.gl52.Middle;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


/**
 * [MODEL] This class define bus network of a city
 * @author Alexandre
 *
 */
public class BusNetwork implements Serializable{

	private static final long serialVersionUID = -6094149499508306454L;
	
	/**
	 * List of bus line currently in the city
	 */
	private List<BusLine> lBusLine;
	
    /**
     * Default constructor. Initialize this class 
     */
    public BusNetwork() {
    	this.lBusLine = new LinkedList<>();
    }

    /**
     * Get the bus lines
     * @return List of bus line
     */
	public List<BusLine> getlBusLine() {
		return this.lBusLine;
	}

	/**
	 * The bus lines to set
	 * @param lBusLine List of bus line
	 */
	public void setlBusLine(List<BusLine> lBusLine) {
		this.lBusLine = lBusLine;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.lBusLine == null) ? 0 : this.lBusLine.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BusNetwork))
			return false;
		BusNetwork other = (BusNetwork) obj;
		if (this.lBusLine == null) {
			if (other.lBusLine != null)
				return false;
		} else if (!this.lBusLine.equals(other.lBusLine))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BusNetwork [lBusLine=" + this.lBusLine + "]";
	}
}
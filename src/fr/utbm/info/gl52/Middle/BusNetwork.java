package fr.utbm.info.gl52.Middle;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


/**
 * 
 */
public class BusNetwork implements Serializable{

	private List<BusLine> lBusLine;
	
    /**
     * 
     */
    public BusNetwork() {
    	this.lBusLine = new LinkedList<>();
    }

	public List<BusLine> getlBusLine() {
		return lBusLine;
	}

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
				+ ((lBusLine == null) ? 0 : lBusLine.hashCode());
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
		if (lBusLine == null) {
			if (other.lBusLine != null)
				return false;
		} else if (!lBusLine.equals(other.lBusLine))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BusNetwork [lBusLine=" + lBusLine + "]";
	}
}
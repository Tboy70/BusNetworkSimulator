package fr.utbm.info.gl52.Middle;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


/**
 * 
 */
public class BusLine implements Serializable{

	private static final long serialVersionUID = -52237704604085616L;

	private String name; 
	
	private List<Itineraire> lIti;
	
    /**
     * 
     */
    public BusLine() {
    	this.lIti = new LinkedList<>();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Itineraire> getlIti() {
		return lIti;
	}

	public void setlIti(List<Itineraire> lIti) {
		this.lIti = lIti;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lIti == null) ? 0 : lIti.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof BusLine))
			return false;
		BusLine other = (BusLine) obj;
		if (lIti == null) {
			if (other.lIti != null)
				return false;
		} else if (!lIti.equals(other.lIti))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BusLine [name=" + name + ", lIti=" + lIti + "]";
	}
}
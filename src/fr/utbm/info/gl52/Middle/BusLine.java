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
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Itineraire> getlIti() {
		return this.lIti;
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
		result = prime * result + ((this.lIti == null) ? 0 : this.lIti.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
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
		if (this.lIti == null) {
			if (other.lIti != null)
				return false;
		} else if (!this.lIti.equals(other.lIti))
			return false;
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BusLine [name=" + this.name + ", lIti=" + this.lIti + "]";
	}
}
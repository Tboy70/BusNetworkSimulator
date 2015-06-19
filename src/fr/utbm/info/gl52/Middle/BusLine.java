package fr.utbm.info.gl52.Middle;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


/**
 * [MODEL] Define a bus line. This one is composed by itineraries, name, and number
 * @author Alexandre
 *
 */
public class BusLine implements Serializable{

	private static final long serialVersionUID = -52237704604085616L;

	/**
	 * Name of the bus line
	 */
	private String name; 
	
	/**
	 * Number of this line 
	 */
	private int num;

	/**
	 * Itineraries in this bus line
	 */
	private List<Itineraire> lIti;
	
    /**
     * Default constructor. Initialize a new empty busline.
     */
    public BusLine() {
    	this.lIti = new LinkedList<>();
    }
    
    public void addItineraire(Itineraire l)
    {
    	this.lIti.add(l);
    }

	/**
	 * Get the name of the bus line
	 * @return THe name of the bus line
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the name of the bus line
	 * @param name The name to set to the bus line
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get itineraries under list form present in bus line
	 * @return
	 */
	public List<Itineraire> getlIti() {
		return this.lIti;
	}

	/**
	 * Set itineraries under list form in the bus line
	 * @param lIti The list to set as itineraries
	 */
	public void setlIti(List<Itineraire> lIti) {
		this.lIti = lIti;
	}
	
	/**
	 * Get the number of the line
	 * @return THe number of the line
	 */
	public int getNum() {
		return this.num;
	}

	/**
	 * Set the number of the line
	 * @param num THe number of the line to set
	 */
	public void setNum(int num) {
		this.num = num;
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

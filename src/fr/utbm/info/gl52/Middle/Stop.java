package fr.utbm.info.gl52.Middle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import fr.utbm.info.gl52.Collection.graph.IEdge;


/**
 * Define a stop in itinerary
 * @author Alexandre
 *
 */
public class Stop implements Serializable{

	private static final long serialVersionUID = -2833791493638864569L;
	/**
	 * Percentage of the segment the stop is
	 */
	private Integer pourcentage;
	
	/**
	 * List of date representing stop date of the bus
	 */
	private List<Date> lTime;
	
	/**
	 * Segment where is located the stop
	 */
	private IEdge<?> edge;
	
	/**
	 * Name of the stop
	 */
	private String name;

	/**
	 * Default constructor which defines completely the stop
	 * @param pourcentage Percentage of the segment the stop is 
	 * @param e Segment where is located the stop
	 */
	public Stop(Integer pourcentage, IEdge<?> e) {
    	this.setPourcentage(pourcentage);
    	this.setEdge(e);
    }

	/**
	 * @return the lTime
	 */
	public List<Date> getlTime() {
		return this.lTime;
	}

	/**
	 * @param lTime the lTime to set
	 */
	public void setlTime(List<Date> lTime) {
		this.lTime = lTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * GEt the edge of the stop
	 * @return The edge to get
	 */
    public IEdge<?> getEdge() {
		return this.edge;
	}

    /**
     * Set the edge of the stop
     * @param edge The edge to set
     */
	public void setEdge(IEdge<?> edge) {
		this.edge = edge;
	}

	/**
	 * Get the percentage of the stop
	 * @return Return the percentage
	 */
	public Integer getPourcentage() {
		return this.pourcentage;
	}

	/**
	 * Set the percentage
	 * @param pourcentage Percentage to set
	 */
	public void setPourcentage(Integer pourcentage) {
		this.pourcentage = pourcentage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.edge == null) ? 0 : this.edge.hashCode());
		result = prime * result
				+ ((this.pourcentage == null) ? 0 : this.pourcentage.hashCode());
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
		if (!(obj instanceof Stop))
			return false;
		Stop other = (Stop) obj;
		if (this.edge == null) {
			if (other.edge != null)
				return false;
		} else if (!this.edge.equals(other.edge))
			return false;
		if (this.pourcentage == null) {
			if (other.pourcentage != null)
				return false;
		} else if (!this.pourcentage.equals(other.pourcentage))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stop [pourcentage=" + this.pourcentage + ", edge=" + this.edge + "]";
	}

}
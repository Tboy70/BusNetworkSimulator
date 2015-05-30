package fr.utbm.info.gl52.Middle;

import java.io.Serializable;

import fr.utbm.info.gl52.Collection.graph.IEdge;


/**
 * 
 */
public class Stop implements Serializable{

	private static final long serialVersionUID = -2833791493638864569L;
	private Integer pourcentage;
	private IEdge<?> edge;

	public Stop(Integer pourcentage, IEdge<?> e) {
    	this.setPourcentage(pourcentage);
    	this.setEdge(e);
    }

    public IEdge<?> getEdge() {
		return this.edge;
	}

	public void setEdge(IEdge<?> edge) {
		this.edge = edge;
	}

	public Integer getPourcentage() {
		return this.pourcentage;
	}

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
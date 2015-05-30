package fr.utbm.info.gl52.Middle;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


/**
 * 
 */
public class Itineraire implements Serializable{

	private static final long serialVersionUID = -3207601505766469834L;

	private String name;
    
    private List<Segment<?>> lRoute;
    
    private List<Stop> lStop;

	/**
     * 
     */
    public Itineraire(String name) {
    	this.setName(name);
    	this.lRoute = new LinkedList<>();
    	this.lStop = new LinkedList<>();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lRoute == null) ? 0 : lRoute.hashCode());
		result = prime * result + ((lStop == null) ? 0 : lStop.hashCode());
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
		if (!(obj instanceof Itineraire))
			return false;
		Itineraire other = (Itineraire) obj;
		if (lRoute == null) {
			if (other.lRoute != null)
				return false;
		} else if (!lRoute.equals(other.lRoute))
			return false;
		if (lStop == null) {
			if (other.lStop != null)
				return false;
		} else if (!lStop.equals(other.lStop))
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
		return "Itineraire [name=" + name + ", lRoute=" + lRoute + ", lStop="
				+ lStop + "]";
	}	
}
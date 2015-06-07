package fr.utbm.info.gl52.Middle;

import java.io.Serializable;
import java.util.Collection;
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
		return this.name;
	}
	
	

	public void setName(String name) {
		this.name = name;
	}
	
    public boolean addSeg(Segment<?> arg0) {
		return this.lRoute.add(arg0);
	}

	public boolean addAllSeg(Collection<? extends Segment<?>> arg0) {
		return this.lRoute.addAll(arg0);
	}

	public boolean removeSeg(Object arg0) {
		return this.lRoute.remove(arg0);
	}

	public boolean removeAllSeg(Collection<?> arg0) {
		return this.lRoute.removeAll(arg0);
	}
	
	public boolean addStop(Stop e) {
		return this.lStop.add(e);
	}

	public boolean addAllStop(Collection<? extends Stop> c) {
		return this.lStop.addAll(c);
	}

	public boolean removeStop(Object o) {
		return this.lStop.remove(o);
	}

	public boolean removeAllStop(Collection<?> c) {
		return this.lStop.removeAll(c);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.lRoute == null) ? 0 : this.lRoute.hashCode());
		result = prime * result + ((this.lStop == null) ? 0 : this.lStop.hashCode());
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
		if (!(obj instanceof Itineraire))
			return false;
		Itineraire other = (Itineraire) obj;
		if (this.lRoute == null) {
			if (other.lRoute != null)
				return false;
		} else if (!this.lRoute.equals(other.lRoute))
			return false;
		if (this.lStop == null) {
			if (other.lStop != null)
				return false;
		} else if (!this.lStop.equals(other.lStop))
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
		return "Itineraire [name=" + this.name + ", lRoute=" + this.lRoute + ", lStop="
				+ this.lStop + "]";
	}	
}
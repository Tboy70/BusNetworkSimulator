/**
 * 
 */
package fr.utbm.info.gl52.Middle;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alexandre
 *
 */
public class MapPolyline implements Serializable{

	private static final long serialVersionUID = -1734745846851382158L;

	private String name;
	
	private List<Segment<?>> lseg;

	public MapPolyline(){
		this.lseg = new LinkedList<>();
	}

	
	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(Segment<?> arg0) {
		return this.lseg.add(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @return
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int arg0, Collection<? extends Segment<?>> arg1) {
		return this.lseg.addAll(arg0, arg1);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#remove(int)
	 */
	public Segment<?> remove(int arg0) {
		return this.lseg.remove(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection<?> arg0) {
		return this.lseg.removeAll(arg0);
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Segment<?>> getListSegment() {
		return this.lseg;
	}

	public void setListSegment(List<Segment<?>> lseg) {
		this.lseg = lseg;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.lseg == null) ? 0 : this.lseg.hashCode());
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
		if (!(obj instanceof MapPolyline))
			return false;
		MapPolyline other = (MapPolyline) obj;
		if (this.lseg == null) {
			if (other.lseg != null)
				return false;
		} else if (!this.lseg.equals(other.lseg))
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
		return "MapPolyline [name=" + this.name + ", lseg=" + this.lseg + "]";
	}
	
}

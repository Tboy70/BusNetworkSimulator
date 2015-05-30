package fr.utbm.info.gl52.Middle;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import fr.utbm.info.gl52.Collection.graph.Graph;


/**
 * 
 */
public class MapGraph<Dn,De> extends Graph<Dn,De> implements Serializable{

	private static final long serialVersionUID = 7723868339903190574L;
	private List<MapPolyline> lMapPolyline;

	/**
     * 
     */
    public MapGraph() {
    	this.lMapPolyline = new LinkedList<>();
    }

	/**
	 * @param element
	 * @see java.util.List#add(java.lang.Object)
	 */
	public void addMapPolyline(MapPolyline element) {
		this.lMapPolyline.add(element);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.lMapPolyline == null) ? 0 : this.lMapPolyline.hashCode());
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
		if (!(obj instanceof MapGraph))
			return false;
		MapGraph<?, ?> other = (MapGraph<?, ?>) obj;
		if (this.lMapPolyline == null) {
			if (other.lMapPolyline != null)
				return false;
		} else if (!this.lMapPolyline.equals(other.lMapPolyline))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MapGraph [lMapPolyline=" + this.lMapPolyline + ";" + super.toString() + "]";
	}
}
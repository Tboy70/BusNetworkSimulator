package fr.utbm.info.gl52.Middle;

import java.awt.Color;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


/**
 * [MODEL] Itinerary used as model.
 * @author Alexandre
 *
 */
public class Itineraire implements Serializable{

	private static final long serialVersionUID = -3207601505766469834L;

	/**
	 * Name of the itinerary
	 */
	private String name;
	
	private Color color;
    
	/**
	 * List of segment composed by the itinerary
	 */
    private List<Segment<?>> lRoute;
    
    /**
     * Number of stop this itinerary has
     */
	private List<Stop> lStop;

	/**
     * Default constructor. Initialize the class with a name
     */
    public Itineraire(String name, Color c) {
    	this.setName(name);
    	this.color = c;
    	this.lRoute = new LinkedList<>();
    	this.lStop = new LinkedList<>();
    }
    
    public Color getColor()
    {
    	return this.color;
    }
    public void setColor(Color c)
    {
    	this.color = c;
    }

    /**
     * Get the name of this itinerary
     * @return The string name of the itinerary
     */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Set the name of this itinerary
	 * @param name Name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Add segment to this itinerary
	 * @param arg0 The segment to add
	 * @return true if succeeded insertion, false otherwise
	 */
    public boolean addSeg(Segment<?> arg0) {
		return this.lRoute.add(arg0);
	}

    /**
	 * Add segments to this itinerary
	 * @param arg0 Segments to add
	 * @return true if succeeded insertion, false otherwise
	 */
	public boolean addAllSeg(Collection<? extends Segment<?>> arg0) {
		return this.lRoute.addAll(arg0);
	}

	/**
	 * Remove segment to this itinerary
	 * @param arg0 The segment to remove
	 * @return true if succeeded deletion, false otherwise
	 */
	public boolean removeSeg(Object arg0) {
		return this.lRoute.remove(arg0);
	}

	/**
	 * Remove segments to this itinerary
	 * @param arg0 Segments to remove
	 * @return true if succeeded deletion, false otherwise
	 */
	public boolean removeAllSeg(Collection<?> arg0) {
		return this.lRoute.removeAll(arg0);
	}
	
	/**
	 * Add stop in this itinerary
	 * @param e The stop to add
	 * @return true if succeeded insertion, false otherwise
	 */
	public boolean addStop(Stop e) {
		return this.lStop.add(e);
	}

	/**
	 * Add stops in this itinerary
	 * @param e Stops to add
	 * @return true if succeeded insertion, false otherwise
	 */
	public boolean addAllStop(Collection<? extends Stop> c) {
		return this.lStop.addAll(c);
	}

	/**
	 * Remove stop in this itinerary
	 * @param e The stop to remove
	 * @return true if succeeded deletion, false otherwise
	 */
	public boolean removeStop(Object o) {
		return this.lStop.remove(o);
	}

	/**
	 * Remove stops in this itinerary
	 * @param e Stop to remove
	 * @return true if succeeded deletion, false otherwise
	 */
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

	/**
	 * @param arg0
	 * @param arg1
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	public void add(int arg0, Segment<?> arg1) {
		this.lRoute.add(arg0, arg1);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(Segment<?> arg0) {
		return this.lRoute.add(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends Segment<?>> arg0) {
		return this.lRoute.addAll(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @return
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int arg0, Collection<? extends Segment<?>> arg1) {
		return this.lRoute.addAll(arg0, arg1);
	}

	/**
	 * 
	 * @see java.util.List#clear()
	 */
	public void clear() {
		this.lRoute.clear();
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#contains(java.lang.Object)
	 */
	public boolean contains(Object arg0) {
		return this.lRoute.contains(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection<?> arg0) {
		return this.lRoute.containsAll(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#get(int)
	 */
	public Segment<?> get(int arg0) {
		return this.lRoute.get(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	public int indexOf(Object arg0) {
		return this.lRoute.indexOf(arg0);
	}

	/**
	 * @return
	 * @see java.util.List#isEmpty()
	 */
	public boolean isEmpty() {
		return this.lRoute.isEmpty();
	}

	/**
	 * @return
	 * @see java.util.List#iterator()
	 */
	public Iterator<Segment<?>> iterator() {
		return this.lRoute.iterator();
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#lastIndexOf(java.lang.Object)
	 */
	public int lastIndexOf(Object arg0) {
		return this.lRoute.lastIndexOf(arg0);
	}

	/**
	 * @return
	 * @see java.util.List#listIterator()
	 */
	public ListIterator<Segment<?>> listIterator() {
		return this.lRoute.listIterator();
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#listIterator(int)
	 */
	public ListIterator<Segment<?>> listIterator(int arg0) {
		return this.lRoute.listIterator(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#remove(int)
	 */
	public Segment<?> remove(int arg0) {
		return this.lRoute.remove(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean remove(Object arg0) {
		return this.lRoute.remove(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection<?> arg0) {
		return this.lRoute.removeAll(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection<?> arg0) {
		return this.lRoute.retainAll(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @return
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	public Segment<?> set(int arg0, Segment<?> arg1) {
		return this.lRoute.set(arg0, arg1);
	}

	/**
	 * @return
	 * @see java.util.List#size()
	 */
	public int size() {
		return this.lRoute.size();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @return
	 * @see java.util.List#subList(int, int)
	 */
	public List<Segment<?>> subList(int arg0, int arg1) {
		return this.lRoute.subList(arg0, arg1);
	}

	/**
	 * @return
	 * @see java.util.List#toArray()
	 */
	public Object[] toArray() {
		return this.lRoute.toArray();
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#toArray(java.lang.Object[])
	 */
	public <T> T[] toArray(T[] arg0) {
		return this.lRoute.toArray(arg0);
	}
    /**
     * Return the list of segment 
	 * @return the route
	 */
	public List<Segment<?>> getlRoute() {
		return this.lRoute;
	}
	
	
	public void add(int index, Stop element) {
		this.lStop.add(index, element);
	}

	public boolean add(Stop e) {
		return this.lStop.add(e);
	}

	public Stop getStop(int index) {
		return this.lStop.get(index);
	}
	
	public int getNbStop(){
		return this.lStop.size();
	}

	public Stop removeStop(int index) {
		return this.lStop.remove(index);
	}

}

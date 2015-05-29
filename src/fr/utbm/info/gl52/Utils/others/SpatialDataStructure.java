package fr.utbm.info.gl52.Utils.others;

import java.io.Serializable;
import java.util.Iterator;

import fr.utbm.info.gl52.Utils.maths.Rectangle2f;
import fr.utbm.info.gl52.Utils.maths.Shape2f;

public interface SpatialDataStructure<D extends ShapedObject> extends Serializable {

	/** Initialize the data-structure that is covering the given area.
	 *
	 * @param worldSize the size of the world.
	 */
	void initialize(Rectangle2f worldSize);
	
	/** Replies the bounds covered by the tree nodes.
	 *
	 * @return the bounds covered by the tree.
	 */
	Rectangle2f getBounds();
	
	/** Change the data associated to the node.
	 *
	 * @param data - the data.
	 * @return <code>true</code> if the data was added.
	 */
	boolean addData(D data);

	/** Change the data associated to the node.
	 *
	 * @param data - the data.
	 * @return <code>true</code> if the data was removed.
	 */
	boolean removeData(D data);
	
	/** Replies an iterator on the data.
	 *
	 * @return the iterator on the data.
	 */
	Iterator<D> dataIterator();

	/** Replies an iterable on the data.
	 *
	 * @return the iterable on the data.
	 */
	Iterable<D> getData();

	/** Replies an iterator on the data elements that are intersecting the given bounds.
	 *
	 * @param bounds - the selection bounds.
	 * @return the iterator.
	 */
	Iterator<D> dataIterator(Shape2f<?> bounds);
}
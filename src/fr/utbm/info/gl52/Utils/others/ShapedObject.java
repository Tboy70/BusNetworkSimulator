package fr.utbm.info.gl52.Utils.others;

import fr.utbm.info.gl52.Utils.maths.Shape2f;

/**
 * Object on the environment.
 * 
 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
 * @version $Name$ $Revision$ $Date$
 */
public interface ShapedObject {

	/** Replies the 2D shape that is representing the object.
	 * The coordinates of the replied shape depends on the current
	 * position of the object.
	 * 
	 * @return the shape of this object.
	 */
	Shape2f<?> getShape();
	
}
package fr.utbm.info.gl52.Event;


/**
 * 
 */
public class RightClicEvent implements IEvent {

    /**
     * 
     */
	public int x, y;
    public RightClicEvent(int px, int py) {
    	this.x = px;
    	this.y = py;
    }


}

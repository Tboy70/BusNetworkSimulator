package fr.utbm.info.gl52.Event;


public class LeftClicEvent implements IEvent {
	public int x, y;
    public LeftClicEvent(int px, int py) {
    	this.x = px;
    	this.y = py;
    }
}

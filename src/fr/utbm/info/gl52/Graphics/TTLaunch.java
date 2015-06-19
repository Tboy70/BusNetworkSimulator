package fr.utbm.info.gl52.Graphics;

import fr.utbm.info.gl52.Graphics.Frame.TimeTableWindow;

public class TTLaunch {
	
	private TimeTableWindow dataW;
	
	public TTLaunch(){
		this.dataW = null;
	}
	
	public synchronized void init(){
		this.dataW = new TimeTableWindow("TimeTable", 700, 700);
		this.dataW.setVisible(true);
	}
	
}

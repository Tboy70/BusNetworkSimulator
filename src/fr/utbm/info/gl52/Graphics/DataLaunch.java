package fr.utbm.info.gl52.Graphics;

import fr.utbm.info.gl52.Graphics.Frame.DataWindow;

public class DataLaunch {
	
	private DataWindow dataW;
	
	public DataLaunch(){
		this.dataW = null;
	}
	
	public void init(){
		this.dataW = new DataWindow("Data", 700, 700);
		this.dataW.setVisible(true);
	}
	
}

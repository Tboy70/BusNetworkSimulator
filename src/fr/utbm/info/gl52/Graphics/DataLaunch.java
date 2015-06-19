package fr.utbm.info.gl52.Graphics;

import fr.utbm.info.gl52.Graphics.Frame.DataWindow;
import fr.utbm.info.gl52.Middle.BusLine;
import fr.utbm.info.gl52.Middle.BusNetwork;

public class DataLaunch {
	
	private DataWindow dataW;
	
	public DataLaunch(){
		this.dataW = null;
	}
	
	public synchronized void init(){
		this.dataW = new DataWindow("Data", 700, 700);
		this.dataW.setVisible(true);
	}

	public synchronized void setNetwork(BusNetwork net){
		this.setNetwork(net);
	}
	
	public synchronized void add(BusLine message) {
		this.dataW.addData(message);
	}
	
}

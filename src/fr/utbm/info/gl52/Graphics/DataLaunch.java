package fr.utbm.info.gl52.Graphics;

import fr.utbm.info.gl52.Event.AddBusLineEvent;
import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Graphics.Frame.DataWindow;
import fr.utbm.info.gl52.Middle.BusLine;
import fr.utbm.info.gl52.Middle.BusNetwork;

public class DataLaunch {
	
	private DataWindow dataW;
	
	private Controller controller;
	
	public DataLaunch(Controller c){
		this.dataW = null;
		this.controller = c;
		this.initController();
	}
	
	private void initController(){
		EventService.getInstance().subscribe(AddBusLineEvent.class, null, this.controller);
	}
	
	public void init(){
		this.dataW = new DataWindow("Data", 700, 700);
		this.dataW.setVisible(true);
	}

	public void setNetwork(BusNetwork net){
		this.setNetwork(net);
	}
	
	public void add(BusLine message) {
		try {
			Thread.sleep(300);
			this.dataW.addData(message);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}

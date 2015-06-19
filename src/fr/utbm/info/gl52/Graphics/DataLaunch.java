package fr.utbm.info.gl52.Graphics;

import fr.utbm.info.gl52.Event.AddBusLineEvent;
import fr.utbm.info.gl52.Event.AddItineraireEvent;
import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Graphics.Frame.DataWindow;
import fr.utbm.info.gl52.Middle.BusLine;
import fr.utbm.info.gl52.Middle.BusNetwork;
import fr.utbm.info.gl52.Middle.Itineraire;

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
	
	public synchronized void init(){
		this.dataW = new DataWindow("Data", 700, 700);
		this.dataW.setVisible(true);
		EventService.getInstance().subscribe(AddItineraireEvent.class, null, this.dataW);
	}

	public synchronized void setNetwork(BusNetwork net){
		this.setNetwork(net);
	}
	
	public synchronized void add(BusLine message) {
		this.dataW.addData(message);
	}
	public synchronized void redraw()
	{
		this.dataW.refresh();
	}
}

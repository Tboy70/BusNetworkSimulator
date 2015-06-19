package fr.utbm.info.gl52.Graphics;

import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;
import fr.utbm.info.gl52.Event.AddBusLineEvent;
import fr.utbm.info.gl52.Event.AddGraphEvent;
import fr.utbm.info.gl52.Event.AddItineraireEvent;
import fr.utbm.info.gl52.Event.AddStopEvent;
import fr.utbm.info.gl52.Event.DisplayBusLineEvent;
import fr.utbm.info.gl52.Event.DisplayItEvent;
import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Event.IEvent;
import fr.utbm.info.gl52.Event.ISubscriber;
import fr.utbm.info.gl52.Event.PopupEvent;
import fr.utbm.info.gl52.Graphics.Frame.PopupWindow;
import fr.utbm.info.gl52.Middle.BusLine;
import fr.utbm.info.gl52.Middle.Itineraire;
import fr.utbm.set.attr.AttributeContainer;
import fr.utbm.set.io.shape.ESRIPoint;

@SuppressWarnings("deprecation")
public class Controller implements ISubscriber {

	private IGraph<INode<ESRIPoint>,IEdge<AttributeContainer>> model;
	private Itineraire iti = null;
	private BusLine currentLine = null;
	private GraphicsLaunch viewMap;
	private static Controller instance = null;
	private DataLaunch viewData;
	public static Controller getInstance()
	{
		if (instance == null)
			instance = new Controller();
		return instance;
	}
	private Controller() { 
		this.model = null;
		this.viewData = null;	
		
		this.viewMap = new GraphicsLaunch(this);
		this.viewData = new DataLaunch(this);
		
		EventService.getInstance().subscribe(DisplayBusLineEvent.class, null, this);
		EventService.getInstance().subscribe(DisplayItEvent.class, null, this);
		EventService.getInstance().subscribe(AddStopEvent.class, null, this);
		EventService.getInstance().subscribe(AddItineraireEvent.class, null, this);
	}
	
	public Itineraire getItineraire()
	{
		return this.iti;
	}
	public BusLine getBusLine()
	{
		return this.currentLine;
	}
	@Override
	public void inform(IEvent e) {
		if (e.getClass() == PopupEvent.class)
			new PopupWindow(((PopupEvent)e).message);
		else if(e.getClass() == AddGraphEvent.class){
			this.viewData.init(); // To do fisrt
			this.model = ((AddGraphEvent)e).message;
			this.viewMap.addGraph(this.model);
		}
		else if(e.getClass() == AddBusLineEvent.class){
			this.viewData.add(((AddBusLineEvent)e).message);
		}
		else if(e.getClass() == DisplayBusLineEvent.class){
			this.viewMap.removeAllIt();
			this.currentLine = ((DisplayBusLineEvent)e).message;
			this.viewMap.addGraphicBusLine(((DisplayBusLineEvent)e).message);
		}
		else if(e.getClass() == DisplayItEvent.class){
			this.viewMap.removeAllIt();
			this.iti = ((DisplayItEvent)e).message;
			this.viewMap.addGraphicIt(((DisplayItEvent)e).message);
		}
		else if(e.getClass() == AddStopEvent.class){
			this.viewMap.addGraphicStop(((AddStopEvent)e).message);
			this.viewData.redraw();
		}
		else if(e.getClass() == AddItineraireEvent.class){
			if (this.currentLine  != null)
			{
				this.currentLine.addItineraire(((AddItineraireEvent)e).it);
				this.viewData.redraw();
			}
		}
	}
	
	public void start() {
		this.viewMap.init();
	}
	
}
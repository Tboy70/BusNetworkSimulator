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
import fr.utbm.info.gl52.Event.LeftClicEvent;
import fr.utbm.info.gl52.Event.PopupEvent;
import fr.utbm.info.gl52.Graphics.Frame.PopupWindow;
import fr.utbm.info.gl52.Middle.BusLine;
import fr.utbm.info.gl52.Middle.Itineraire;
import fr.utbm.set.attr.AttributeContainer;
import fr.utbm.set.io.shape.ESRIPoint;

/**
 * Main controller of the application. This one launch views at starts and responds to main events. 
 * @author Alexandre
 *
 */
@SuppressWarnings("deprecation")
public class Controller implements ISubscriber {

	/**
	 * [MODEL] Model of the application. Used to store map
	 */
	private IGraph<INode<ESRIPoint>,IEdge<AttributeContainer>> model;
	
	/**
	 * [VIEW] Main window with map and bus network
	 */
	private Itineraire iti = null;
	private BusLine currentLine = null;
	private GraphicsLaunch viewMap;
	
	/**
	 * [VIEW] Timetable, bus line, itinerary used (uses part of the model) 
	 */
	private static Controller instance = null;

	private DataLaunch viewData;
	
	public static Controller getInstance()
	{
		if (instance == null)
			instance = new Controller();
		return instance;
	}
	
	/**
	 * Initialize the main controller.
	 */
	private Controller() {
		this.viewMap = new GraphicsLaunch();
		this.viewData = new DataLaunch();
		
		// Mapview
		EventService.getInstance().subscribe(LeftClicEvent.class, null, this);
    	EventService.getInstance().subscribe(PopupEvent.class, null, this);
    	EventService.getInstance().subscribe(AddGraphEvent.class, null, this);
		
    	// Data launch
    	EventService.getInstance().subscribe(AddBusLineEvent.class, null, this);
    	
		EventService.getInstance().subscribe(DisplayBusLineEvent.class, null, this);
		EventService.getInstance().subscribe(DisplayItEvent.class, null, this);
		EventService.getInstance().subscribe(AddStopEvent.class, null, this);
		EventService.getInstance().subscribe(AddItineraireEvent.class, null, this);
	}
	
	/**
	 * This methods is called by the event service. It responds all main events of the application and redistributes its
	 */
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
		}
		else if(e.getClass() == AddItineraireEvent.class){

			System.out.println("Ajout de l'itinéraire");
			if (this.currentLine  != null)
			{
				this.currentLine.addItineraire(((AddItineraireEvent)e).it);
			}
		}
	}
	
	/**
	 * Start the main view
	 */
	public void start() {
		this.viewMap.init();
	}
}

package fr.utbm.info.gl52.Graphics;

import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;
import fr.utbm.info.gl52.Event.AddBusLineEvent;
import fr.utbm.info.gl52.Event.AddGraphEvent;
import fr.utbm.info.gl52.Event.DisplayBusLineEvent;
import fr.utbm.info.gl52.Event.DisplayItEvent;
import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Event.IEvent;
import fr.utbm.info.gl52.Event.ISubscriber;
import fr.utbm.info.gl52.Event.PopupEvent;
import fr.utbm.info.gl52.Graphics.Frame.PopupWindow;
import fr.utbm.set.attr.AttributeContainer;
import fr.utbm.set.io.shape.ESRIPoint;

@SuppressWarnings("deprecation")
public class Controller implements ISubscriber {

	private IGraph<INode<ESRIPoint>,IEdge<AttributeContainer>> model;
	
	private GraphicsLaunch viewMap;
	
	private DataLaunch viewData;
	
	public Controller() { 
		this.model = null;
		this.viewData = null;	
		
		this.viewMap = new GraphicsLaunch(this);
		this.viewData = new DataLaunch(this);
		
		EventService.getInstance().subscribe(DisplayBusLineEvent.class, null, this);
		EventService.getInstance().subscribe(DisplayItEvent.class, null, this);
	}
	
	@Override
	public void inform(IEvent e) {
		if (e.getClass() == PopupEvent.class)
			new PopupWindow(((PopupEvent)e).message);
		else if(e.getClass() == AddGraphEvent.class){
			this.viewData.init(); // To do fisrt
			
			this.model = ((AddGraphEvent)e).message;
			this.viewMap.addGraph(this.model);
		}else if(e.getClass() == AddBusLineEvent.class){
			this.viewData.add(((AddBusLineEvent)e).message);
		}else if(e.getClass() == DisplayBusLineEvent.class){
			this.viewMap.removeAllIt();
			this.viewMap.addGraphicBusLine(((DisplayBusLineEvent)e).message);
		}else if(e.getClass() == DisplayItEvent.class){
			this.viewMap.removeAllIt();
			this.viewMap.addGraphicIt(((DisplayItEvent)e).message);
		}
	}
	
	public void start() {
		this.viewMap.init();
	}
	
}
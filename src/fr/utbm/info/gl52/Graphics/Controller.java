package fr.utbm.info.gl52.Graphics;

import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;
import fr.utbm.info.gl52.Event.AddGraphEvent;
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
		this.viewMap = null;
		this.viewData = null;
	}
	
	@Override
	public void inform(IEvent e) {
		if (e.getClass() == PopupEvent.class)
			new PopupWindow(((PopupEvent)e).message);
		if(e.getClass() == AddGraphEvent.class){
			this.model = ((AddGraphEvent)e).message;
			this.viewMap.addGraph(((AddGraphEvent)e).message);
			this.viewData = new DataLaunch();
			this.viewData.init();
		}
	}
	
	public void start() {
		this.viewMap = new GraphicsLaunch(this);
		this.viewMap.init();
	}
	
}
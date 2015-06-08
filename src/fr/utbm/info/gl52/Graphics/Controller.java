package fr.utbm.info.gl52.Graphics;

import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;
import fr.utbm.info.gl52.Event.AddGraphEvent;
import fr.utbm.info.gl52.Event.IEvent;
import fr.utbm.info.gl52.Event.ISubscriber;
import fr.utbm.info.gl52.Event.PopupEvent;
import fr.utbm.info.gl52.Graphics.Frame.PopupWindow;
import fr.utbm.info.gl52.Middle.MapGraph;
import fr.utbm.set.attr.AttributeContainer;
import fr.utbm.set.io.shape.ESRIPoint;

public class Controller implements ISubscriber {

	private IGraph<INode<ESRIPoint>,IEdge<AttributeContainer>> modele;
	
	private GraphicsLaunch view;
	
	public Controller() { 
		this.modele = null;
		view = null;
	}
	
	@Override
	public void inform(IEvent e) {
		if (e.getClass() == PopupEvent.class)
			new PopupWindow(((PopupEvent)e).message);
		if(e.getClass() == AddGraphEvent.class)
			view.addGraph(((AddGraphEvent)e).message);
	}
	
	public void start() {
		this.view = new GraphicsLaunch(this);
		this.view.init();
	}
	
}
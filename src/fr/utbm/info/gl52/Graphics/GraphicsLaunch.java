package fr.utbm.info.gl52.Graphics;


import fr.utbm.info.gl52.Collection.graph.Edge;
import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;
import fr.utbm.info.gl52.Collection.graph.Node;
import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Event.LeftClicEvent;
import fr.utbm.info.gl52.Graphics.Buttons.AddBusButton;
import fr.utbm.info.gl52.Graphics.Buttons.CenterButton;
import fr.utbm.info.gl52.Graphics.Buttons.ParseButton;
import fr.utbm.info.gl52.Graphics.Buttons.ZoomButton;
import fr.utbm.info.gl52.Graphics.Frame.Window;
import fr.utbm.info.gl52.Graphics.Road.OneWayRoadComponent;
import fr.utbm.info.gl52.Middle.MapGraph;
import fr.utbm.info.gl52.Parser.util.ESRISpatialObject;
import fr.utbm.set.attr.AttributeContainer;
import fr.utbm.set.io.shape.ESRIBounds;
import fr.utbm.set.io.shape.ESRIPoint;

@SuppressWarnings("deprecation")
public class GraphicsLaunch {

	public static Window w;

	public static void main(String[] args) {
		w = new Window("Test", 600,600);
		w.setVisible(true);
		
		ZoomButton zplus = new ZoomButton("+", 0, 200, 40, 40, 10);
    	ZoomButton zminus = new ZoomButton("-", 0, 240, 40, 40, -10);
    	AddBusButton busButt = new AddBusButton("A", 0, 280, 40, 40, CardinalSystem.NORTHEAST);
    	CenterButton center = new CenterButton("C",0, 320, 40, 40);
    	ParseButton parse = new ParseButton("P",0, 360, 40, 40);
        
    	zplus.setLayout(w.getMap());
    	zminus.setLayout(w.getMap());
    	busButt.setLayout(w.getMap());
    	center.setLayout(w.getMap());
    	parse.setLayout(w.getMap());

    	EventService.getInstance().subscribe(LeftClicEvent.class, null, new Controller());
    	
    	w.addGUI(zplus);
    	w.addGUI(zminus);
    	w.addGUI(busButt);
    	w.addGUI(center);
    	w.addGUI(parse);
    	
    	w.repaint();

	}
	
	public static void addGraph(IGraph<INode<ESRIPoint>,IEdge<AttributeContainer>> g){
		ESRIBounds b = ((MapGraph)g).getMapBounds();
		for(IEdge<?> e: g)
    	{
			if(e != null){
				IEdge<AttributeContainer> eT = (Edge<AttributeContainer>)e;
				INode<ESRISpatialObject> A = (Node<ESRISpatialObject>)eT.getNodeA();
				INode<ESRISpatialObject> B = (Node<ESRISpatialObject>)eT.getNodeB();
				int px[] = {(int)A.getData().x - (int)b.minx,(int)B.getData().x - (int)b.minx};
				int py[] = {(int)A.getData().y - (int)b.miny,(int)B.getData().y - (int)b.miny};
				w.addGraphicElement(new OneWayRoadComponent(px, py));
			}
    	}
		w.repaint();
	}
}

package fr.utbm.info.gl52.Graphics;


import fr.utbm.info.gl52.Collection.graph.Edge;
import fr.utbm.info.gl52.Collection.graph.Graph;
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
import fr.utbm.info.gl52.Graphics.Road.BicyclePathComponent;
import fr.utbm.info.gl52.Graphics.Road.HighwayComponent;
import fr.utbm.info.gl52.Graphics.Road.OneWayRoadComponent;
import fr.utbm.info.gl52.Middle.Position;
import fr.utbm.info.gl52.Parser.util.ESRISpatialObject;
import fr.utbm.set.attr.AttributeContainer;
import fr.utbm.set.io.shape.ESRIPoint;

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
        
    	Graph<Position, String> graph = new Graph<Position, String>();
    	Node<Position> n1 = new Node<Position>(new Position(100, 100));
    	Node<Position> n2 = new Node<Position>(new Position(100, 150));
    	Node<Position> n3 = new Node<Position>(new Position(300, 150));
    	Node<Position> n4 = new Node<Position>(new Position(100, 50));
    	
    	Edge<String> e1 = new Edge<String>("highway", n1, n2);
    	Edge<String> e2 = new Edge<String>("bike", n2, n3);
    	Edge<String> e3 = new Edge<String>("oneway", n3, n4);
    	
    	graph.addEdge(e1);
    	graph.addEdge(e2);
    	graph.addEdge(e3);
    	
    	
    	
    	w.addGUI(zplus);
    	w.addGUI(zminus);
    	w.addGUI(busButt);
    	w.addGUI(center);
    	w.addGUI(parse);
    	
    	w.repaint();

	}
	
	public static void addGraph(IGraph<INode<ESRIPoint>,IEdge<AttributeContainer>> g){
		for(IEdge<?> e: g)
    	{
			if(e != null){
				IEdge<AttributeContainer> eT = (Edge<AttributeContainer>)e;
				INode<ESRISpatialObject> A = (Node<ESRISpatialObject>)eT.getNodeA();
				INode<ESRISpatialObject> B = (Node<ESRISpatialObject>)eT.getNodeB();
				System.out.println((A.getData().x - 940045 +400)+","+(A.getData().y - 2302902+400));
				int px[] = {(int)A.getData().x -  940045 +500,(int)B.getData().x - 940045 +500};
				int py[] = {(int)A.getData().y - 2302902+400,(int)B.getData().y - 2302902+400};
				w.addGraphicElement(new OneWayRoadComponent(px, py));
			}
    	}
		w.repaint();
	}
}

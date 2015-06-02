package fr.utbm.info.gl52.Graphics;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import fr.utbm.info.gl52.Collection.graph.Edge;
import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;
import fr.utbm.info.gl52.Collection.graph.Node;
import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Event.LeftClicEvent;
import fr.utbm.info.gl52.Event.PopupEvent;
import fr.utbm.info.gl52.Graphics.Bus.YellowBus;
import fr.utbm.info.gl52.Graphics.Buttons.AddBusButton;
import fr.utbm.info.gl52.Graphics.Buttons.CenterButton;
import fr.utbm.info.gl52.Graphics.Buttons.ParseButton;
import fr.utbm.info.gl52.Graphics.Buttons.ZoomButton;
import fr.utbm.info.gl52.Graphics.Frame.Window;
import fr.utbm.info.gl52.Graphics.Road.HighwayComponent;
import fr.utbm.info.gl52.Graphics.Road.SensRoad;
import fr.utbm.info.gl52.Middle.MapGraph;
import fr.utbm.info.gl52.Parser.util.ESRISpatialObject;
import fr.utbm.set.attr.AttributeContainer;
import fr.utbm.set.io.shape.ESRIBounds;
import fr.utbm.set.io.shape.ESRIPoint;

@SuppressWarnings("deprecation")
public class GraphicsLaunch {

	public static Window w;

	public static void main(String[] args) {
		w = new Window("BusNetwork",700,700);
		w.setVisible(true);
		ZoomButton zplus = new ZoomButton("+", 0, 200, 40, 40, 10);
    	ZoomButton zminus = new ZoomButton("-", 0, 240, 40, 40, -10);
    	AddBusButton busButt = new AddBusButton("A", 0, 280, 40, 40, CardinalSystem.NORTHEAST);
    	CenterButton center = new CenterButton("C",0, 320, 40, 40);
    	ParseButton parse = new ParseButton("P",0, 360, 40, 40);

    	for (int i = 0; i < 100; i++)
    	{
    		Random rand = new Random();

    		int x = rand.nextInt((1000 - 0) + 1) + 0;
    		int y = rand.nextInt((1000 - 0) + 1) + 0;
    		w.addNetworkElement(new YellowBus(x,y) );
    	}
    	
    	zplus.setLayout(w.getMap());
    	zminus.setLayout(w.getMap());
    	
    	zplus.setLayout(w.getNetwork());
    	zminus.setLayout(w.getNetwork());
    	
    	busButt.setLayout(w.getMap());
    	center.setLayout(w.getMap());
    	parse.setLayout(w.getMap());

    	Controller c = new Controller();
    	EventService.getInstance().subscribe(LeftClicEvent.class, null, c);
    	EventService.getInstance().subscribe(PopupEvent.class, null, c);
    	
    	w.addGUI(zplus);
    	w.addGUI(zminus);
    	w.addGUI(busButt);
    	w.addGUI(center);
    	w.addGUI(parse);
    	w.repaint();

	}
	
	public static void addGraph(IGraph<INode<ESRIPoint>,IEdge<AttributeContainer>> g){
		ESRIBounds b = ((MapGraph)g).getMapBounds();
		w.getMap().flush();
		Set<String> cl_fonc = new HashSet<String>();
		Set<String> cl_physiq = new HashSet<String>();
		for(IEdge<?> e: g)
    	{
			if(e != null){
				IEdge<AttributeContainer> eT = (Edge<AttributeContainer>)e;
				INode<ESRISpatialObject> A = (Node<ESRISpatialObject>)eT.getNodeA();
				INode<ESRISpatialObject> B = (Node<ESRISpatialObject>)eT.getNodeB();
				cl_fonc.add(eT.getData().getAttribute("CL_FONC").toString());
				cl_physiq.add(eT.getData().getAttribute("CL_PHYSIQ").toString());
				int px[] = {(int)A.getData().x - (int)b.minx,(int)B.getData().x - (int)b.minx};
				int py[] = {(int)A.getData().y - (int)b.miny,(int)B.getData().y - (int)b.miny};
				SensRoad sens = eT.getData().getAttribute("SENS").equals("Double sens") ? SensRoad.SANS : SensRoad.DROIT;
				
				w.addGraphicElement(new HighwayComponent(px, py, sens));
				
				
			}
    	}
		System.out.println("CL_FONC:");
		for (String s : cl_fonc)
		{
			System.out.println(""+s);
		}
		System.out.println("CL_PHYSIQ:");
		for (String s : cl_physiq)
		{
			System.out.println(""+s);
		}
		
		w.repaint();
	}
}

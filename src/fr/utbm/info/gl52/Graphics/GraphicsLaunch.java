package fr.utbm.info.gl52.Graphics;



import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;
import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Event.LeftClicEvent;
import fr.utbm.info.gl52.Event.PopupEvent;
import fr.utbm.info.gl52.Graphics.Bus.YellowBus;
import fr.utbm.info.gl52.Graphics.Buttons.SaveButton;
import fr.utbm.info.gl52.Graphics.Buttons.CenterButton;
import fr.utbm.info.gl52.Graphics.Buttons.ModButton;
import fr.utbm.info.gl52.Graphics.Buttons.ParseButton;
import fr.utbm.info.gl52.Graphics.Buttons.ZoomButton;
import fr.utbm.info.gl52.Graphics.Frame.Window;
import fr.utbm.info.gl52.Graphics.Itinerary.GraphicItinerary;
import fr.utbm.info.gl52.Graphics.Road.HighwayComponent;
import fr.utbm.info.gl52.Graphics.Road.SensRoad;
import fr.utbm.info.gl52.Middle.Itineraire;
import fr.utbm.info.gl52.Middle.MapGraph;
import fr.utbm.info.gl52.Middle.MapPolyline;
import fr.utbm.info.gl52.Middle.Segment;
import fr.utbm.info.gl52.Middle.Stop;
import fr.utbm.info.gl52.Parser.util.ESRISpatialObject;
import fr.utbm.set.attr.AttributeContainer;
import fr.utbm.set.io.shape.ESRIBounds;
import fr.utbm.set.io.shape.ESRIPoint;

@SuppressWarnings("deprecation")
public class GraphicsLaunch {

	public static Window w;
	public static IGraph<INode<ESRIPoint>,IEdge<AttributeContainer>> graph;

	public static void main(String[] args) {
		w = new Window("BusNetwork",700,700);
		w.setVisible(true);
		ZoomButton zplus = new ZoomButton("+", 0, 0, 40, 40, 10);
    	ZoomButton zminus = new ZoomButton("-", 0, 40, 40, 40, -10);
    	CenterButton center = new CenterButton("C",0, 80, 40, 40);
    	
    	ParseButton parse = new ParseButton("Load",0, 280, 50, 40);
    	ModButton mod = new ModButton("Modifier",0, 320, 50, 40, parse);
    	SaveButton save = new SaveButton("Save", 0, 360, 50, 40);
    	
    	for (int i = 0; i < 10; i++)
    	{
    		Random rand = new Random();
    		int x = rand.nextInt((800 - 0) + 1) + 0;
    		int y = rand.nextInt((800 - 0) + 1) + 0;
    		w.addNetworkElement(new YellowBus(x,y) );
    	}
    	
    	zplus.setLayout(w.getMap());
    	zminus.setLayout(w.getMap());
    	center.setLayout(w.getMap());
    	
    	zplus.setLayout(w.getNetwork());
    	zminus.setLayout(w.getNetwork());
    	center.setLayout(w.getNetwork());
    	
    	save.setLayout(w.getMap());
    	parse.setLayout(w.getMap());
    	mod.setLayout(w.getMap());

    	Controller c = new Controller();
    	EventService.getInstance().subscribe(LeftClicEvent.class, null, c);
    	EventService.getInstance().subscribe(PopupEvent.class, null, c);
    	
    	w.addGUI(zplus);
    	w.addGUI(zminus);
    	w.addGUI(center);
    	w.addGUI(parse);
    	w.addGUI(mod);
    	w.addGUI(save);
    	
    	w.repaint();
	}
	
	public static void addGraph(IGraph<INode<ESRIPoint>,IEdge<AttributeContainer>> g){
		ESRIBounds b = ((MapGraph)g).getMapBounds();
		graph = g;
		w.getMap().flush();
		List<MapPolyline> lMap = ((MapGraph)g).getlMapPolyline();  
		for (MapPolyline p :  lMap)
		{
			boolean bFirstPoint = false;
			ArrayList<Integer> px = new ArrayList<>();
			ArrayList<Integer> py = new ArrayList<>();
			SensRoad sens = SensRoad.SANS;
			for (Segment s : p.getListSegment())
			{
				
				AttributeContainer attrs = (AttributeContainer) s.getData();
				INode<ESRISpatialObject> A = s.getNodeA();
				INode<ESRISpatialObject> B = s.getNodeB();
				if (!bFirstPoint)
				{
					bFirstPoint = true;
					px.add((int)A.getData().x - (int)b.minx);
					py.add((int)A.getData().y - (int)b.miny);
					sens = attrs.getAttribute("SENS").equals("Double sens") ? SensRoad.SANS : SensRoad.DROIT;
				}
				px.add((int)B.getData().x - (int)b.minx);
				py.add((int)B.getData().y - (int)b.miny);
				
			}
			
			w.addGraphicElement(new HighwayComponent(toPrimitive(px.toArray(new Integer[px.size()])), toPrimitive(py.toArray(new Integer[py.size()])), sens, p));
		}
		
		/*for(IEdge<?> e: g)
    	{
			if(e != null){
				IEdge<AttributeContainer> eT = (Edge<AttributeContainer>)e;
				INode<ESRISpatialObject> A = (Node<ESRISpatialObject>)eT.getNodeA();
				INode<ESRISpatialObject> B = (Node<ESRISpatialObject>)eT.getNodeB();
				int px[] = {(int)A.getData().x - (int)b.minx,(int)B.getData().x - (int)b.minx};
				int py[] = {(int)A.getData().y - (int)b.miny,(int)B.getData().y - (int)b.miny};
				SensRoad sens = eT.getData().getAttribute("SENS").equals("Double sens") ? SensRoad.SANS : SensRoad.DROIT;
				w.addGraphicElement(new HighwayComponent(px, py, sens));
			}
    	}	*/
		
		// Add itiniraire		
		Segment<AttributeContainer> seg1 = (Segment<AttributeContainer>)g.iterator().next();
		Stop s1 = new Stop(100, seg1);
		Segment<AttributeContainer> seg2 = (Segment<AttributeContainer>)g.iterator().next();
		Stop s2 = new Stop(0, seg2);
		Segment<AttributeContainer> seg3 = (Segment<AttributeContainer>)g.iterator().next();
		Stop s3 = new Stop(0, seg3);
		Segment<AttributeContainer> seg4 = (Segment<AttributeContainer>)g.iterator().next();
		Stop s4 = new Stop(0, seg4);
		Segment<AttributeContainer> seg5 = (Segment<AttributeContainer>)g.iterator().next();
		Stop s5 = new Stop(0, seg5);
		Segment<AttributeContainer> seg6 = (Segment<AttributeContainer>)g.iterator().next();
		Stop s6 = new Stop(100, seg6);
		
		
		Itineraire i1 = new Itineraire("Test1");
		i1.addStop(s1);
		i1.addStop(s2);
		i1.addStop(s3);
		i1.addStop(s4);
		i1.addStop(s5);
		i1.addStop(s6);
		i1.addSeg(seg1);
		i1.addSeg(seg2);
		i1.addSeg(seg3);
		i1.addSeg(seg4);
		i1.addSeg(seg5);
		i1.addSeg(seg6);
		
		Itineraire i2 = new Itineraire("Test1-2");
		i2.addStop(s6);
		i2.addStop(s5);
		i2.addStop(s4);
		i2.addStop(s3);
		i2.addStop(s2);
		i2.addStop(s1);
		i2.addSeg(seg6);
		i2.addSeg(seg5);
		i2.addSeg(seg4);
		i2.addSeg(seg3);
		i2.addSeg(seg2);
		i2.addSeg(seg1);
		Point offset = new Point();
		offset.setLocation(5,5);
		w.addGraphicElement(new GraphicItinerary(i1, offset , Color.red, b));
		offset.setLocation(-5,5);
		//w.addGraphicElement(new GraphicItinerary(i2, offset , Color.blue, b));
		
		/*List<Itineraire> li = new LinkedList<>();
		li.add(i1);
		li.add(i2);
		
		BusLine busline = new BusLine();
		busline.setlIti(li);
		
		List<BusLine> lb = new LinkedList<>();
		lb.add(busline);
		
		BusNetwork net = new BusNetwork();
		net.setlBusLine(lb);*/
		
		w.repaint();
	}
	public static int[] toPrimitive(Integer[] IntegerArray) {
		 
		int[] result = new int[IntegerArray.length];
		for (int i = 0; i < IntegerArray.length; i++) {
			result[i] = IntegerArray[i].intValue();
		}
		return result;
	}
}

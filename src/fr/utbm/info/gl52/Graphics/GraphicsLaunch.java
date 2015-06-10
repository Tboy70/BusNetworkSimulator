package fr.utbm.info.gl52.Graphics;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;
import fr.utbm.info.gl52.Event.AddBusLineEvent;
import fr.utbm.info.gl52.Event.AddGraphEvent;
import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Event.LeftClicEvent;
import fr.utbm.info.gl52.Event.PopupEvent;
import fr.utbm.info.gl52.Graphics.Bus.YellowBus;
import fr.utbm.info.gl52.Graphics.Buttons.CenterButton;
import fr.utbm.info.gl52.Graphics.Buttons.ModButton;
import fr.utbm.info.gl52.Graphics.Buttons.ParseButton;
import fr.utbm.info.gl52.Graphics.Buttons.SaveButton;
import fr.utbm.info.gl52.Graphics.Buttons.ZoomButton;
import fr.utbm.info.gl52.Graphics.Frame.Window;
import fr.utbm.info.gl52.Graphics.Itinerary.GraphicItinerary;
import fr.utbm.info.gl52.Graphics.Road.HighwayComponent;
import fr.utbm.info.gl52.Graphics.Road.SensRoad;
import fr.utbm.info.gl52.Middle.BusLine;
import fr.utbm.info.gl52.Middle.BusNetwork;
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

	private Window mapWindow;
	private IGraph<INode<ESRIPoint>,IEdge<AttributeContainer>> graph;
	private Controller controller;
	
	public GraphicsLaunch(Controller c){
		this.controller = c;
		this.initController();
	}
	
	public void init(){
		this.initWindow();
		this.initGUI();
	}
	
	private void initWindow(){
		this.mapWindow = new Window("BusNetwork",700,700);
		this.mapWindow.setVisible(true);
	}
	
	private void initController(){
    	EventService.getInstance().subscribe(LeftClicEvent.class, null, this.controller);
    	EventService.getInstance().subscribe(PopupEvent.class, null, this.controller);
    	EventService.getInstance().subscribe(AddGraphEvent.class, null, this.controller);
	}
	
	private void initGUI(){
		ZoomButton zplus = new ZoomButton("+", 0, 0, 40, 40, 10);
    	ZoomButton zminus = new ZoomButton("-", 0, 40, 40, 40, -10);
    	CenterButton center = new CenterButton("C",0, 80, 40, 40);
    	
    	ParseButton parse = new ParseButton("Load",0, 280, 50, 40);
    	ModButton mod = new ModButton("Modifier",0, 320, 50, 40);
    	SaveButton save = new SaveButton("Save", 0, 360, 50, 40);
    	
    	for (int i = 0; i < 10; i++)
    	{
    		Random rand = new Random();
    		int x = rand.nextInt((800 - 0) + 1) + 0;
    		int y = rand.nextInt((800 - 0) + 1) + 0;
    		this.mapWindow.addNetworkElement(new YellowBus(x,y) );
    	}
    	
    	zplus.setLayout(this.mapWindow.getMap());
    	zminus.setLayout(this.mapWindow.getMap());
    	center.setLayout(this.mapWindow.getMap());
    	
    	zplus.setLayout(this.mapWindow.getNetwork());
    	zminus.setLayout(this.mapWindow.getNetwork());
    	center.setLayout(this.mapWindow.getNetwork());
    	
    	save.setLayout(this.mapWindow.getMap());
    	parse.setLayout(this.mapWindow.getMap());
    	mod.setLayout(this.mapWindow.getMap());

    	this.mapWindow.addGUI(zplus);
    	this.mapWindow.addGUI(zminus);
    	this.mapWindow.addGUI(center);
    	this.mapWindow.addGUI(parse);
    	this.mapWindow.addGUI(mod);
    	this.mapWindow.addGUI(save);
    	
    	this.mapWindow.repaint();
	}
	
	public void addGraph(IGraph<INode<ESRIPoint>,IEdge<AttributeContainer>> g){
		ESRIBounds b = ((MapGraph)g).getMapBounds();
		this.graph = g;
		this.mapWindow.getMap().flush();
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
			
			this.mapWindow.addGraphicElement(new HighwayComponent(toPrimitive(px.toArray(new Integer[px.size()])), toPrimitive(py.toArray(new Integer[py.size()])), sens, p));
		}
		
		// Add itiniraire
		Iterator<IEdge<?>> i = g.iterator();
		Segment<AttributeContainer> seg1 = (Segment<AttributeContainer>)i.next();
		Stop s1 = new Stop(100, seg1);
		Segment<AttributeContainer> seg2 = (Segment<AttributeContainer>)i.next();
		Stop s2 = new Stop(0, seg2);
		Segment<AttributeContainer> seg3 = (Segment<AttributeContainer>)i.next();
		Stop s3 = new Stop(0, seg3);
		Segment<AttributeContainer> seg4 = (Segment<AttributeContainer>)i.next();
		Stop s4 = new Stop(0, seg4);
		Segment<AttributeContainer> seg5 = (Segment<AttributeContainer>)i.next();
		Stop s5 = new Stop(0, seg5);
		Segment<AttributeContainer> seg6 = (Segment<AttributeContainer>)i.next();
		Stop s6 = new Stop(100, seg6);
		Segment<AttributeContainer> seg7 = (Segment<AttributeContainer>)i.next();
		Stop s7 = new Stop(100, seg1);
		Segment<AttributeContainer> seg8 = (Segment<AttributeContainer>)i.next();
		Stop s8 = new Stop(0, seg2);
		Segment<AttributeContainer> seg9 = (Segment<AttributeContainer>)i.next();
		Stop s9 = new Stop(0, seg3);
		Segment<AttributeContainer> seg10 = (Segment<AttributeContainer>)i.next();
		Stop s10 = new Stop(0, seg4);
		Segment<AttributeContainer> seg11 = (Segment<AttributeContainer>)i.next();
		Stop s11 = new Stop(0, seg5);
		Segment<AttributeContainer> seg12 = (Segment<AttributeContainer>)i.next();
		Stop s12 = new Stop(100, seg6);
		
		
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
		i2.addStop(s7);
		i2.addStop(s8);
		i2.addStop(s9);
		i2.addStop(s10);
		i2.addStop(s11);
		i2.addStop(s12);
		i2.addSeg(seg7);
		i2.addSeg(seg8);
		i2.addSeg(seg9);
		i2.addSeg(seg10);
		i2.addSeg(seg11);
		i2.addSeg(seg12);
		
		//this.addGraphicIt(i1);
		//this.addGraphicIt(i2);
		
		List<Itineraire> li = new LinkedList<>();
		li.add(i1);
		li.add(i2);
		
		BusLine busline = new BusLine();
		busline.setlIti(li);
		busline.setName("testCoco");
		busline.setNum(1);
		
		/*List<BusLine> lb = new LinkedList<>();
		lb.add(busline);
		
		BusNetwork net = new BusNetwork();
		net.setlBusLine(lb);*/
		
		EventService.getInstance().publish(new AddBusLineEvent(busline));
		EventService.getInstance().publish(new AddBusLineEvent(busline));

		this.mapWindow.repaint();
	}
	
	public void addGraphicBusLine(BusLine l) {
		for(Itineraire i : l.getlIti()){
			this.addGraphicIt(i);
		}
	}
	
	public void addGraphicIt(Itineraire i){
		Point offset = new Point();
		offset.setLocation(5,5);
		this.mapWindow.addGraphicElement(new GraphicItinerary(i, offset, Color.RED, ((MapGraph)this.graph).getMapBounds()));
		offset.setLocation(-5,5);
		this.mapWindow.repaint();
	}
	
	public static int[] toPrimitive(Integer[] IntegerArray) {
		int[] result = new int[IntegerArray.length];
		for (int i = 0; i < IntegerArray.length; i++) {
			result[i] = IntegerArray[i].intValue();
		}
		return result;
	}
}

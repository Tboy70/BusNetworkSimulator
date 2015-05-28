package fr.utbm.info.gl52.Graphics;


import java.io.IOException;

import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Event.LeftClicEvent;
import fr.utbm.info.gl52.Graphics.Bus.YellowBus;
import fr.utbm.info.gl52.Graphics.Buttons.AddBusButton;
import fr.utbm.info.gl52.Graphics.Buttons.CenterButton;
import fr.utbm.info.gl52.Graphics.Buttons.ZoomButton;
import fr.utbm.info.gl52.Graphics.Frame.Window;
import fr.utbm.info.gl52.Graphics.Road.BicyclePathComponent;
import fr.utbm.info.gl52.Graphics.Road.HighwayComponent;
import fr.utbm.info.gl52.Graphics.Road.OneWayRoadComponent;

public class GraphicsLaunch {


	public static void main(String[] args) throws IOException {
		Window w = new Window("Test", 600,600);
		w.setVisible(true);
		
		ZoomButton zplus = new ZoomButton("+", 0, 200, 40, 40, 10);
    	ZoomButton zminus = new ZoomButton("-", 0, 240, 40, 40, -10);
    	AddBusButton busButt = new AddBusButton("A", 0, 280, 40, 40, CardinalSystem.NORTHEAST);
    	CenterButton center = new CenterButton("C",0, 320, 40, 40);
        
    	zplus.setLayout(w.getMap());
    	zminus.setLayout(w.getMap());
    	busButt.setLayout(w.getMap());
    	center.setLayout(w.getMap());

    	int[] px = {10, 50, 350};
        int[] py = {10, 50, 400};
        
        int[] owx = {50, 300, 420};
        int[] owy = {230, 421, 321};
        
        int[] bpx = {10, 100, 580};
        int[] bpy = {10, 50, 400};
        
        EventService.getInstance().subscribe(LeftClicEvent.class, null, new Controller());
        
    	w.addGraphicElement(new HighwayComponent(px, py));
    	w.addGraphicElement(new BicyclePathComponent(bpx, bpy));
    	w.addGraphicElement(new OneWayRoadComponent(owx, owy));      
    	
    	w.addGraphicElement(new YellowBus(10, 10));
    	
    	w.addGUI(zplus);
    	w.addGUI(zminus);
    	w.addGUI(busButt);
    	w.addGUI(center);
    	
    	w.repaint();

	}
}

package fr.utbm.info.gl52.Parser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import fr.utbm.info.gl52.Collection.graph.Edge;
import fr.utbm.info.gl52.Collection.graph.Node;
import fr.utbm.set.io.shape.ESRIPoint;
import fr.utbm.set.io.shape.ShapeFileIndexReader;
import fr.utbm.set.io.shape.ShapeFileReader;

/**
 * 
 */
public final class ParserShapeFile<Dn,De> extends AbstractParser<Node<ESRIPoint>,Edge<String>> {
	
	private URL shpResource;
	private URL shxResource;
	
	public ParserShapeFile(String shp, String shx) {
		super(shp);
		try {
//			this.shpResource = new URL("file:///home/petrol/Documents/Workspace/BusNetworkSimulator/"+shp);
//			this.shxResource= new URL("file:///home/petrol/Documents/Workspace/BusNetworkSimulator/"+shx);
			this.shpResource = new URL("file:///C:/Users/Alexandre/Desktop/gitEclipse/BusNetworkSimulator/"+ shp);
			this.shxResource = new URL("file:///C:/Users/Alexandre/Desktop/gitEclipse/BusNetworkSimulator/"+ shx);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		try {
			ShapeFileIndexReader shxReader = new ShapeFileIndexReader(this.shxResource);
			ShapeFileGraphFactory<Dn> factShape = new ShapeFileGraphFactory<>(this.callback, this);
			ShapeFileReader<Dn> reader = new ShapeFileReader<>(this.shpResource, null, shxReader, factShape);
			factShape.setBounds(reader.getBoundsFromHeader());
			
			Iterator<Dn> i = reader.iterator(); 
			while(i.hasNext()) // Read
				i.next();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
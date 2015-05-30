package fr.utbm.info.gl52.Parser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;
import fr.utbm.set.io.shape.ShapeFileIndexReader;
import fr.utbm.set.io.shape.ShapeFileReader;

/**
 * 
 */
public final class ParserShapeFile<Dn,De> extends AbstractParser<IGraph<INode<Dn>,IEdge<De>>> {
	
	private URL shpResource = null;
	private URL shxResource = null;
	
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
	
	public ParserShapeFile(String shp) {
		super(shp);
		try {
//			this.shpResource = new URL("file:///home/petrol/Documents/Workspace/BusNetworkSimulator/"+shp);
//			this.shxResource= new URL("file:///home/petrol/Documents/Workspace/BusNetworkSimulator/"+shx);
			this.shpResource = new URL("file:///C:/Users/Alexandre/Desktop/gitEclipse/BusNetworkSimulator/"+ shp);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		try {
			ShapeFileIndexReader shxReader = null;
			ShapeFileReader<Dn> reader = null;
			ShapeFileGraphFactory<Dn> factShape = new ShapeFileGraphFactory<>(this.callback, this);
			
			if(this.shxResource != null)
				shxReader = new ShapeFileIndexReader(this.shxResource);
			if(this.shxResource != null){
				reader = new ShapeFileReader<>(this.shpResource, null, shxReader, factShape);
			}else{
				reader = new ShapeFileReader<>(this.shpResource, factShape);
			}
			
			factShape.setBounds(reader.getBoundsFromHeader());
			
			Iterator<Dn> i = reader.iterator(); 
			while(i.hasNext()) // Read
				i.next();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
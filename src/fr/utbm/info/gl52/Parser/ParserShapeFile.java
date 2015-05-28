package fr.utbm.info.gl52.Parser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import fr.utbm.info.gl52.Collection.graph.Edge;
import fr.utbm.info.gl52.Collection.graph.Graph;
import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.Node;
import fr.utbm.set.attr.AttributeProvider;
import fr.utbm.set.io.shape.AbstractElementFactory;
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
			this.shpResource = new URL("file:///C:/Users/Alexandre/Desktop/gitEclipse/BusNetworkSimulator/"+ shp);
			this.shxResource = new URL("file:///C:/Users/Alexandre/Desktop/gitEclipse/BusNetworkSimulator/"+ shx);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		try {
			ShapeFileIndexReader shxReader = new ShapeFileIndexReader(this.shxResource);
			ShapeFileReader<Dn> reader = new ShapeFileReader<Dn>(this.shpResource, null, shxReader, new DisplayShapeFileFactory(this.callback));
			
			Iterator<Dn> i = reader.iterator(); 
			while(i.hasNext()) // Read
				i.next();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public synchronized void setGraph(IGraph<Node<ESRIPoint>, Edge<String>> graph){
		this.graph = graph;		
	}
	
	public class DisplayShapeFileFactory extends AbstractElementFactory<Dn> {
		
		private FinishedParsingCallcack c;
		
		IGraph<Node<ESRIPoint>, Edge<String>> graph = new Graph<>();
		
		public DisplayShapeFileFactory(FinishedParsingCallcack c) {
			this.c = c;
		}

		public Dn createPolyline(AttributeProvider provider, int shapeIndex, int[] parts, ESRIPoint[] points, boolean hasZ) {
			/*System.out.print("createPolyline : " + provider.toString() + ", shapeIndex : " + shapeIndex + ", parts : [");
			for(int i = 0 ; i < parts.length ; ++i)
				System.out.print(parts[i]+", ");
			System.out.print("], points : [");
			for(int i = 0 ; i < points.length ; ++i)
				System.out.print(points[i]+", ");
			System.out.println("], hasZ : "+ hasZ);*/
			
			///
			
			Node<ESRIPoint> n = new Node<ESRIPoint>(points[0]);
			IEdge<String> e;
			
			for(int i = 1 ; i < points.length ; ++i){
				Node<ESRIPoint> m = new Node<ESRIPoint>(points[i]);
				e = new Edge<String>("coucou", n, m);
				this.graph.addEdge((Edge<String>) e);
			}
			
			if(shapeIndex % 1000 == 0)
				System.out.println(shapeIndex);
			
			return null;
		}
		
		public void postReadingStage(boolean success){
			setGraph(this.graph);
			if(success)
				c.finishedSuccess();
			else
				c.finishedFailed();
		}
	}
}
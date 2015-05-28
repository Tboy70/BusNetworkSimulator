/**
 * 
 */
package fr.utbm.info.gl52.Parser;

import java.awt.Rectangle;

import fr.utbm.info.gl52.Collection.graph.Edge;
import fr.utbm.info.gl52.Collection.graph.Graph;
import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.Node;
import fr.utbm.info.gl52.Collection.tree.QuadTree;
import fr.utbm.info.gl52.Parser.util.ESRISpatialObject;
import fr.utbm.set.attr.AttributeProvider;
import fr.utbm.set.io.shape.AbstractElementFactory;
import fr.utbm.set.io.shape.ESRIPoint;

/**
 * @author Alexandre
 *
 */
public class ShapeFileGraphFactory<Dn> extends AbstractElementFactory<Dn> {
	
	private FinishedParsingCallcack c;
	
	private IParser parser;
	
	IGraph<Node<ESRIPoint>, Edge<String>> graph;
	
	QuadTree<ESRISpatialObject> qtree;
	
	public ShapeFileGraphFactory(FinishedParsingCallcack c, IParser parser) {
		this.graph = new Graph<>();
		this.qtree = new QuadTree<>(new Rectangle(Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		this.c = c;
		this.parser = parser;
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
		
		Node<ESRISpatialObject> n = new Node<ESRISpatialObject>(new ESRISpatialObject(points[0]));
		IEdge<String> e;
		
		this.qtree.insert(n.getData());
		
		for(int i = 1 ; i < points.length ; ++i){
			Node<ESRISpatialObject> m = new Node<ESRISpatialObject>(new ESRISpatialObject(points[i]));
			e = new Edge<String>("coucou", n, m);
			
			this.graph.addEdge((Edge<String>) e);
			this.qtree.insert(m.getData());
			
			n = m;
		}
		
		if(shapeIndex % 1000 == 0)
			System.out.println(shapeIndex);
		
		return null;
	}
	
	public void postReadingStage(boolean success){
		this.parser.setGraph(this.graph);
		if(success)
			c.finishedSuccess();
		else
			c.finishedFailed();
	}
}

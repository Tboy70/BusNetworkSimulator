/**
 * 
 */
package fr.utbm.info.gl52.Parser;

import java.awt.geom.Rectangle2D;

import fr.utbm.info.gl52.Collection.graph.Edge;
import fr.utbm.info.gl52.Collection.graph.Graph;
import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.Node;
import fr.utbm.info.gl52.Collection.tree.QuadTree;
import fr.utbm.info.gl52.Parser.util.ESRISpatialObject;
import fr.utbm.set.attr.AttributeContainer;
import fr.utbm.set.attr.AttributeProvider;
import fr.utbm.set.io.shape.AbstractElementFactory;
import fr.utbm.set.io.shape.ESRIBounds;
import fr.utbm.set.io.shape.ESRIPoint;

/**
 * @author Alexandre
 *
 */
@SuppressWarnings("deprecation")
public class ShapeFileGraphFactory<Dn,De> extends AbstractElementFactory<Dn> {
	
	private FinishedParsingCallcack c;
	
	private IParser parser;
	
	private IGraph<Node<Dn>, Edge<De>> graph;
	
	private QuadTree<ESRISpatialObject> qtree = null;

	private ESRIBounds bounds;

	private ParserDBase<Dn, De> dbase;
	
	public ShapeFileGraphFactory(FinishedParsingCallcack c, IParser parser, ParserDBase<Dn,De> dbase) {
		this.graph = new Graph<>();
		
		this.c = c;
		this.parser = parser;
		this.dbase = dbase;
	}
	
	public void setBounds(ESRIBounds b){
		this.bounds = b;
		this.qtree = new QuadTree<>(new Rectangle2D.Double(this.bounds.minx, this.bounds.miny, this.bounds.maxx, this.bounds.maxy));
	}

	public Dn createPolyline(AttributeProvider provider, int shapeIndex, int[] parts, ESRIPoint[] points, boolean hasZ) {
		assert(this.bounds != null);
		if(this.bounds == null)
			throw new RuntimeException("No bounds have been set");
		
		/*System.out.print("createPolyline : " + provider.toString() + ", shapeIndex : " + shapeIndex + ", parts : [");
		for(int i = 0 ; i < parts.length ; ++i)
			System.out.print(parts[i]+", ");
		System.out.print("], points : [");
		for(int i = 0 ; i < points.length ; ++i)
			System.out.print(points[i]+", ");
		System.out.println("], hasZ : "+ hasZ);*/
		
		///
		
		/*Node<ESRISpatialObject> n = new Node<>(new ESRISpatialObject(points[0]));
		IEdge<String> e;
		
		this.qtree.insert(n.getData());
		
		for(int i = 1 ; i < points.length ; ++i){
			Node<ESRISpatialObject> m = new Node<>(new ESRISpatialObject(points[i]));
			e = new Edge<>("coucou", n, m);
			
			if(this.qtree.insert(m.getData()))
				this.graph.addEdge((Edge<De>) e);
			
			n = m;
		}*/
		
		///
		
		Node<ESRISpatialObject> n = new Node<>(new ESRISpatialObject(points[0]));
		IEdge<AttributeContainer> e;
		AttributeContainer attr;
		
		this.qtree.insert(n.getData());
		
		for(int i = 1 ; i < points.length ; ++i){
			Node<ESRISpatialObject> m = new Node<>(new ESRISpatialObject(points[i]));
			
			attr = this.dbase.next();
			e = new Edge<>(attr, n, m);
			
			if(this.qtree.insert(m.getData()))
				this.graph.addEdge((Edge<De>) e);
			
			n = m;
		}
		
		if(shapeIndex % 1000 == 0)
			System.out.println(shapeIndex);
		
		return null;
	}
	
	public void postReadingStage(boolean success){
		this.parser.setGraph(this.graph);
		if(success)
			this.c.finishedSuccess();
		else
			this.c.finishedFailed();
	}
}

package fr.utbm.info.gl52.Parser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import fr.utbm.info.gl52.TestShapeFileParser.DisplayShapeFileFactory;
import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.INode;
import fr.utbm.set.attr.AttributeProvider;
import fr.utbm.set.attr.AttributeValue;
import fr.utbm.set.attr.HeapAttributeProvider;
import fr.utbm.set.io.shape.AbstractElementFactory;
import fr.utbm.set.io.shape.ESRIPoint;
import fr.utbm.set.io.shape.ShapeFileIndexReader;
import fr.utbm.set.io.shape.ShapeFileReader;
import fr.utbm.set.io.shape.ShapeMultiPatchType;

/**
 * 
 */
public class ParserShapeFile<Dn,De> extends AbstractParser<INode<Dn>,IEdge<De>> {
	
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
			ShapeFileReader<Dn> reader = new ShapeFileReader<Dn>(this.shpResource, null, shxReader, new DisplayShapeFileFactory());
			
			Iterator<Dn> i = reader.iterator(); 
			while(i.hasNext()) // Read
				i.next();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public class DisplayShapeFileFactory extends AbstractElementFactory<Dn> {

		public DisplayShapeFileFactory() {
			//
		}

		public AttributeProvider createAttributeProvider(int elementIndex) {
			System.out.println("createAttributeProvider : "+ elementIndex);
			return new HeapAttributeProvider();
		}
		
		public Dn createPolyline(AttributeProvider provider, int shapeIndex, int[] parts, ESRIPoint[] points, boolean hasZ) {
			System.out.print("createPolyline : " + provider.toString() + ", shapeIndex : " + shapeIndex + ", parts : [");
			for(int i = 0 ; i < parts.length ; ++i)
				System.out.print(parts[i]+", ");
			System.out.print("], points : [");
			for(int i = 0 ; i < points.length ; ++i)
				System.out.print(points[i]+", ");
			System.out.println("], hasZ : "+ hasZ);
			return null;
		}

		/** {@inheritDoc}
		 */
		@Override
		public Dn createMultiPoint(AttributeProvider provider, int shapeIndex, ESRIPoint[] points, boolean hasZ) {
			System.out.print("createMultiPoint : " + provider.toString() + ", shapeIndex : " + shapeIndex + ", points : [");
			for(int i = 0 ; i < points.length ; ++i)
				System.out.print(points[i]+", ");
			System.out.println("], hasZ : "+ hasZ);
			return null;
		}

		/** {@inheritDoc}
		 */
		@Override
		public Dn createPoint(AttributeProvider provider, int shape_index, ESRIPoint point) {
			System.out.print("createPoint : " + provider.toString() + ", shapeIndex : " + shape_index + ", point : "+ point);
			return null;
		}

		/** {@inheritDoc}
		 */
		@Override
		public Dn createMultiPatch(AttributeProvider provider, int shapeIndex, int[] parts, ShapeMultiPatchType[] partTypes, ESRIPoint[] points) {
			System.out.print("createMultiPatch : " + provider.toString() + ", shapeIndex : " + shapeIndex + ", parts : [");
			for(int i = 0 ; i < parts.length ; ++i)
				System.out.print(parts[i]+", ");
			System.out.print("], points : [");
			for(int i = 0 ; i < points.length ; ++i)
				System.out.print(points[i]+", ");
			System.out.print("], partType : [");
			for(int i = 0 ; i < partTypes.length ; ++i)
				System.out.print(partTypes[i]+", ");
			System.out.println("], hasZ");
			return null;
		}

		/** {@inheritDoc}
		 */
		@Override
		public void putAttributeIn(Dn element, String attributeName, AttributeValue value) {
			System.out.println("putAttributeIn : "+ element + ", attributename :"+attributeName + ", AttributeValue : " + value);
		}

		@Override
		public Dn createPolygon(AttributeProvider provider, int shapeIndex, int[] parts, ESRIPoint[] points, boolean hasZ) {
			System.out.print("Create Polygon : " + provider.toString() + ", shapeIndex : " + shapeIndex + ", parts : [");
			for(int i = 0 ; i < parts.length ; ++i)
				System.out.print(parts[i]+", ");
			System.out.print("], points : [");
			for(int i = 0 ; i < points.length ; ++i)
				System.out.print(points[i]+", ");
			System.out.println("], hasZ : "+ hasZ);
			return null;
		}
	}


}
<<<<<<< HEAD
package fr.utbm.info.gl52;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import fr.utbm.info.gl52.Parser.IBad;
import fr.utbm.set.attr.AttributeProvider;
import fr.utbm.set.attr.AttributeValue;
import fr.utbm.set.attr.HeapAttributeProvider;
import fr.utbm.set.io.shape.AbstractElementFactory;
import fr.utbm.set.io.shape.ESRIPoint;
import fr.utbm.set.io.shape.ShapeFileIndexReader;
import fr.utbm.set.io.shape.ShapeFileReader;
import fr.utbm.set.io.shape.ShapeMultiPatchType;

public class TestShapeFileParser{

	private final String SHP_TEST_FILE = "resources/test.shp"; //$NON-NLS-1$
	private final String SHX_TEST_FILE = "resources/test.shx"; //$NON-NLS-1$

	private URL shpResource;
	private URL shxResource;

	/**
	 * {@inheritDoc}
	 */
	protected void setUp() throws Exception {
		this.shpResource = new URL("file:///C:/Users/Alexandre/Desktop/gitEclipse/BusNetworkSimulator/"+ SHP_TEST_FILE);
		this.shxResource = new URL("file:///C:/Users/Alexandre/Desktop/gitEclipse/BusNetworkSimulator/"+ SHX_TEST_FILE);
	}

	private ShapeFileReader<IBad> createNoShx() throws IOException {
		return new ShapeFileReader<IBad>(shpResource, new DisplayShapeFileFactory());
	}

	private ShapeFileReader<IBad> createShx() throws IOException {
		ShapeFileIndexReader shxReader = new ShapeFileIndexReader(this.shxResource);
		return new ShapeFileReader<IBad>(this.shpResource, null, shxReader, new DisplayShapeFileFactory());
	}

	public class DisplayShapeFileFactory extends AbstractElementFactory<IBad> {

		public DisplayShapeFileFactory() {
			//
		}

		public AttributeProvider createAttributeProvider(int elementIndex) {
			System.out.println("createAttributeProvider : "+ elementIndex);
			return new HeapAttributeProvider();
		}
		
		public IBad createPolyline(AttributeProvider provider, int shapeIndex, int[] parts, ESRIPoint[] points, boolean hasZ) {
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
		public IBad createMultiPoint(AttributeProvider provider, int shapeIndex, ESRIPoint[] points, boolean hasZ) {
			System.out.print("createMultiPoint : " + provider.toString() + ", shapeIndex : " + shapeIndex + ", points : [");
			for(int i = 0 ; i < points.length ; ++i)
				System.out.print(points[i]+", ");
			System.out.println("], hasZ : "+ hasZ);
			return null;
		}

		/** {@inheritDoc}
		 */
		@Override
		public IBad createPoint(AttributeProvider provider, int shape_index, ESRIPoint point) {
			System.out.print("createPoint : " + provider.toString() + ", shapeIndex : " + shape_index + ", point : "+ point);
			return null;
		}

		/** {@inheritDoc}
		 */
		@Override
		public IBad createMultiPatch(AttributeProvider provider, int shapeIndex, int[] parts, ShapeMultiPatchType[] partTypes, ESRIPoint[] points) {
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
		public void putAttributeIn(IBad element, String attributeName, AttributeValue value) {
			System.out.println("putAttributeIn : "+ element + ", attributename :"+attributeName + ", AttributeValue : " + value);
		}

		@Override
		public IBad createPolygon(AttributeProvider provider, int shapeIndex, int[] parts, ESRIPoint[] points, boolean hasZ) {
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

	public static void main(String[] args) {
		TestShapeFileParser t = new TestShapeFileParser();

		try {
			t.setUp();
			ShapeFileReader<IBad> shxReader = t.createShx();
			Iterator<IBad> i = shxReader.iterator(); 
			while(i.hasNext()) // Read
				i.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
=======
package fr.utbm.info.gl52;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import fr.utbm.set.attr.AttributeProvider;
import fr.utbm.set.attr.AttributeValue;
import fr.utbm.set.attr.HeapAttributeProvider;
import fr.utbm.set.io.shape.AbstractElementFactory;
import fr.utbm.set.io.shape.ESRIPoint;
import fr.utbm.set.io.shape.ShapeFileIndexReader;
import fr.utbm.set.io.shape.ShapeFileReader;
import fr.utbm.set.io.shape.ShapeMultiPatchType;

public class TestShapeFileParser{

	private final String SHP_TEST_FILE = "resources/test.shp"; //$NON-NLS-1$
	private final String SHX_TEST_FILE = "resources/test.shx"; //$NON-NLS-1$

	private URL shpResource;
	private URL shxResource;

	/**
	 * {@inheritDoc}
	 */
	protected void setUp() throws Exception {
		this.shpResource = new URL("file:///C:/Users/Alexandre/Desktop/gitEclipse/BusNetworkSimulator/"+ SHP_TEST_FILE);
		this.shxResource = new URL("file:///C:/Users/Alexandre/Desktop/gitEclipse/BusNetworkSimulator/"+ SHX_TEST_FILE);
	}

	private ShapeFileReader<Integer> createNoShx() throws IOException {
		return new ShapeFileReader<Integer>(shpResource, new DisplayShapeFileFactory());
	}

	private ShapeFileReader<Integer> createShx() throws IOException {
		ShapeFileIndexReader shxReader = new ShapeFileIndexReader(this.shxResource);
		return new ShapeFileReader<Integer>(this.shpResource, null, shxReader, new DisplayShapeFileFactory());
	}

	public class DisplayShapeFileFactory extends AbstractElementFactory<Integer> {

		public DisplayShapeFileFactory() {
			//
		}

		public AttributeProvider createAttributeProvider(int elementIndex) {
			System.out.println("createAttributeProvider : "+ elementIndex);
			return new HeapAttributeProvider();
		}
		
		public Integer createPolyline(AttributeProvider provider, int shapeIndex, int[] parts, ESRIPoint[] points, boolean hasZ) {
			System.out.print("createPolyline : " + provider.toString() + ", shapeIndex : " + shapeIndex + ", parts : [");
			for(int i = 0 ; i < parts.length ; ++i)
				System.out.print(parts[i]+", ");
			System.out.print("], points : [");
			for(int i = 0 ; i < points.length ; ++i)
				System.out.print(points[i]+", ");
			System.out.println("], hasZ : "+ hasZ);
			return -1;
		}

		/** {@inheritDoc}
		 */
		@Override
		public Integer createMultiPoint(AttributeProvider provider, int shapeIndex, ESRIPoint[] points, boolean hasZ) {
			System.out.print("createMultiPoint : " + provider.toString() + ", shapeIndex : " + shapeIndex + ", points : [");
			for(int i = 0 ; i < points.length ; ++i)
				System.out.print(points[i]+", ");
			System.out.println("], hasZ : "+ hasZ);
			return -1;
		}

		/** {@inheritDoc}
		 */
		@Override
		public Integer createPoint(AttributeProvider provider, int shape_index, ESRIPoint point) {
			System.out.print("createPoint : " + provider.toString() + ", shapeIndex : " + shape_index + ", point : "+ point);
			return -1;
		}

		/** {@inheritDoc}
		 */
		@Override
		public Integer createMultiPatch(AttributeProvider provider, int shapeIndex, int[] parts, ShapeMultiPatchType[] partTypes, ESRIPoint[] points) {
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
			return -1;
		}

		/** {@inheritDoc}
		 */
		@Override
		public void putAttributeIn(Integer element, String attributeName, AttributeValue value) {
			System.out.println("putAttributeIn : "+ element + ", attributename :"+attributeName + ", AttributeValue : " + value);
		}

		@Override
		public Integer createPolygon(AttributeProvider provider, int shapeIndex, int[] parts, ESRIPoint[] points, boolean hasZ) {
			System.out.print("Create Polygon : " + provider.toString() + ", shapeIndex : " + shapeIndex + ", parts : [");
			for(int i = 0 ; i < parts.length ; ++i)
				System.out.print(parts[i]+", ");
			System.out.print("], points : [");
			for(int i = 0 ; i < points.length ; ++i)
				System.out.print(points[i]+", ");
			System.out.println("], hasZ : "+ hasZ);
			return -1;
		}
	}

	public static void main(String[] args) {
		TestShapeFileParser t = new TestShapeFileParser();

		try {
			t.setUp();
			ShapeFileReader<Integer> shxReader = t.createShx();
			Iterator<Integer> i = shxReader.iterator(); 
			while(i.hasNext()) // Read
				i.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
>>>>>>> refs/heads/Florent

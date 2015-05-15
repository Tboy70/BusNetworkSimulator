package fr.utbm.info.gl52;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import fr.utbm.set.attr.AttributeProvider;
import fr.utbm.set.io.shape.AbstractElementFactory;
import fr.utbm.set.io.shape.ESRIPoint;
import fr.utbm.set.io.shape.ShapeFileIndexReader;
import fr.utbm.set.io.shape.ShapeFileReader;

public class TestParser{

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

	/**
	 * {@inheritDoc}
	 */
	protected void tearDown() throws Exception {
		this.shxResource = null;
		this.shpResource = null;
	}
	
	private ShapeFileReader<Integer> createNoShx() throws IOException {
		return new ShapeFileReader<Integer>(shpResource, new NullFactory());
	}

	private ShapeFileReader<Integer> createShx() throws IOException {
		ShapeFileIndexReader shxReader = new ShapeFileIndexReader(this.shxResource);
		return new ShapeFileReader<Integer>(this.shpResource, null, shxReader, new NullFactory());
	}

	/**
	 * Test method for {@link fr.utbm.set.io.shape.AbstractCommonShapeFileReader#getShapeElementType()}.
	 * @throws Exception
	 */
	public void testGetShapeElementType_noshx() throws Exception {
		ShapeFileReader<Integer> reader = createNoShx();
		// assertEquals(ShapeElementType.POLYGON, reader.getShapeElementType());
	}

	private class NullFactory extends AbstractElementFactory<Integer> {

		public NullFactory() {
			//
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
		TestParser t = new TestParser();
		
		try {
			
			t.setUp();
			ShapeFileReader<Integer> shxReader = t.createShx();
			Iterator<Integer> i = shxReader.iterator(); 
			while(i.hasNext()){
				i.next();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

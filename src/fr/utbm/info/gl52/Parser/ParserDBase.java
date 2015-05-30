/**
 * 
 */
package fr.utbm.info.gl52.Parser;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;
import fr.utbm.set.attr.AttributeContainer;
import fr.utbm.set.io.dbase.DBaseFileField;
import fr.utbm.set.io.dbase.DBaseFileReader;

/**
 * @author Alexandre
 *
 */
@SuppressWarnings("deprecation")
public class ParserDBase<Dn,De> extends AbstractParser<IGraph<INode<Dn>,IEdge<De>>> implements Iterator<AttributeContainer> {

	private static final String DBF_TEST_FILE = "resources\\quartier_polyline.dbf"; //$NON-NLS-1$

	private DBaseFileReader reader;
	
	private List<DBaseFileField> fields;

	private Iterator<AttributeContainer> it;
	
	public ParserDBase(String file) {
		super(file);
		
		File f = new File("C:\\Users\\Alexandre\\Desktop\\gitEclipse\\BusNetworkSimulator\\"+ DBF_TEST_FILE);
		try {
			this.reader = new DBaseFileReader(f);
			this.reader.readDBFHeader();
			this.fields = this.reader.readDBFFields();
		}catch(Exception e){
			throw new RuntimeException("Problème in DBase parser at init");
		}
		
		this.it = this.reader.iterator();
	}
	
	public List<DBaseFileField> getFields(){
		return this.fields;
	}

	public AttributeContainer next(){
		if(this.it.hasNext())
			return this.it.next();
		return null;
	}

	public Iterator<AttributeContainer> iterator() {
		return this.it;
	}

	public boolean hasNext() {
		return this.it.hasNext();
	}

	@Override
	public void remove() {
		this.it.remove();
	}
}

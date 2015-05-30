package fr.utbm.info.gl52;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.arakhne.afc.vmutil.locale.Locale;

import fr.utbm.set.attr.Attribute;
import fr.utbm.set.attr.AttributeContainer;
import fr.utbm.set.attr.AttributeNotInitializedException;
import fr.utbm.set.attr.InvalidAttributeTypeException;
import fr.utbm.set.io.dbase.DBaseFileField;
import fr.utbm.set.io.dbase.DBaseFileReader;

@SuppressWarnings("deprecation")
public class TestDBaseFileParser{

	private static final String DBF_TEST_FILE = "resources\\test.dbf"; //$NON-NLS-1$

	private static String columnize(String s, int length) {
		StringBuilder b = new StringBuilder();
		b.append(s);
		for(int i=s.length(); i<length; ++i) {
			b.append(" "); //$NON-NLS-1$
		}
		String ss = b.toString();
		if (ss.length()>length) {
			ss = ss.substring(0, length);
		}
		return ss;
	}

	/** Main program to display the content of the dBASE file.
	 * This program works in a similar way than the dbview unix
	 * command.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\Alexandre\\Desktop\\gitEclipse\\BusNetworkSimulator\\"+ DBF_TEST_FILE);
		DBaseFileReader reader = new DBaseFileReader(file);

		reader.readDBFHeader();
		List<DBaseFileField> fields = reader.readDBFFields();

		System.out.println(Locale.getString(DBaseFileReader.class, "FILE_VERSION", reader.getDBFVersion())); //$NON-NLS-1$
		System.out.println(Locale.getString(DBaseFileReader.class, "LAST_UPDATE", reader.getDBFLastUpdateDate())); //$NON-NLS-1$
		System.out.println(Locale.getString(DBaseFileReader.class, "CHARSET", reader.getDBFLanguage())); //$NON-NLS-1$
		System.out.println(Locale.getString(DBaseFileReader.class, "FIELD_COUNT", reader.getDBFFieldCount())); //$NON-NLS-1$
		System.out.println(Locale.getString(DBaseFileReader.class, "RECORD_COUNT", reader.getDBFRecordCount())); //$NON-NLS-1$
		System.out.println(Locale.getString(DBaseFileReader.class, "RECORD_LENGTH", reader.getDBFRecordSize())); //$NON-NLS-1$
		System.out.println(Locale.getString(DBaseFileReader.class, "HEADER_LENGTH", reader.getDBFHeaderSize())); //$NON-NLS-1$

		System.out.println("------------------------------------------"); //$NON-NLS-1$
		System.out.println(Locale.getString(DBaseFileReader.class, "FIELD_HEADER")); //$NON-NLS-1$

		for(DBaseFileField field : fields) {
			System.out.println(Locale.getString(DBaseFileReader.class, "FIELD", //$NON-NLS-1$
					columnize(field.getName(),10),
					(char)field.getType().toByte(),
					field.getLength(),
					field.getDecimalPointPosition()));
		}

		System.out.println("=========================================="); //$NON-NLS-1$

		boolean first = true;

		for(AttributeContainer attrs : reader) {
			if (first) {
				first = false;
			}
			else {
				System.out.println("------------------------------------------"); //$NON-NLS-1$
			}
			for(Attribute attr : attrs.attributes()) {
				try {
					System.out.println(Locale.getString(DBaseFileReader.class, "RECORD_VALUE", //$NON-NLS-1$ 
							columnize(attr.getName(), 10),
							attr.getValue(), attr.getType()));
				}
				catch (InvalidAttributeTypeException e) {
					System.out.println(Locale.getString(DBaseFileReader.class, "INVALID_ATTRIBUTE_TYPE",  //$NON-NLS-1$
							columnize(attr.getName(), 10), attr.getType()));
				}
				catch (AttributeNotInitializedException e) {
					System.out.println(Locale.getString(DBaseFileReader.class, "ATTRIBUTE_NOT_INITIALIZED", //$NON-NLS-1$ 
							columnize(attr.getName(), 10)));
				}
			}
		}
	}

}

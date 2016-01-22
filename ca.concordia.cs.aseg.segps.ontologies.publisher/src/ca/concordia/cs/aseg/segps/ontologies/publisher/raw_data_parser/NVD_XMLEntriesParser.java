/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */
package ca.concordia.cs.aseg.segps.ontologies.publisher.raw_data_parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class NVD_XMLEntriesParser {

	public static void main(String[] args) {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		try {
			SAXParser saxParser = factory.newSAXParser();
			EntryHandler handler = new EntryHandler();
			saxParser.parse(new File("nvdcve-2.0-2014.xml"), handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}

}

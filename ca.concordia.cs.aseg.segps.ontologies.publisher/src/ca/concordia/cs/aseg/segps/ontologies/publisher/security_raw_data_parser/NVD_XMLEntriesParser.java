/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */
package ca.concordia.cs.aseg.segps.ontologies.publisher.security_raw_data_parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class NVD_XMLEntriesParser {

	private static String dataCorpusPath = "C:/Users/umroot/workspace/data/unzipped";
	private static String downloadedData = "C:/Users/umroot/workspace/data/zipped";
	
	public static void main(String[] args) {
		
		/**
		 * Unzipping  the nvdcve-*.xml.zip files 
		 */
		File zippedFiles = new File(downloadedData);
		File[] nvdXMLZipFeeds = zippedFiles.listFiles();
		for(File file: nvdXMLZipFeeds){
			System.out.println("file unzip: "+ file.getName());
			unzip(file.getAbsolutePath());
		}
		
		/**
		 * Extracting and parsing NVD xml feeds
		 */
		extractData(dataCorpusPath);
	}
	
	public static void extractData(String corpus){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			File corpusPath = new File(corpus);
			File[] nvdXMLFeeds = corpusPath.listFiles();
			for (int i = 0; i <  nvdXMLFeeds.length; i++) {
				System.out.println("Parsing "+nvdXMLFeeds[i].getName() +"...");
				SAXParser saxParser = factory.newSAXParser();
				EntryHandler handler = new EntryHandler();
				saxParser.parse(new File(nvdXMLFeeds[i].getAbsolutePath()), handler);
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void unzip(String dataSource){
	    String password = "password";
	    try {
	         ZipFile zipFile = new ZipFile(dataSource);
	         if (zipFile.isEncrypted()) {
	            zipFile.setPassword(password);
	         }
	         zipFile.extractAll(dataCorpusPath);
	    } catch (ZipException e) {
	        e.printStackTrace();
	    }
	}

}

/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */

package ca.concordia.cs.aseg.segps.ontologies.urigenerator.system_specific.tbox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;

public class JavaTBox {

	/*
	 * CONCEPTS
	 */
	
	public static String JavaDoc() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.java)
				+ "JavaDoc";
		
		return uri;
	}
	
	public static String JavaPackage() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.java)
				+ "JavaPackage";
		
		return uri;
	}
	
	/*
	 * No PROPERTIES to define
	 */
	
	/*
	 * INDIVIDUALS
	 */
	public static String privateVisibility() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.java)
				+ "private";
		
		return uri;
	}
	
	public static String publicVisibility() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.java)
				+ "public";
		
		return uri;
	}
	
	public static String protectedVisibility() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.java)
				+ "protected";
		
		return uri;
	}
	
	public static String overrides() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.java)
				+ "overrides";
		
		return uri;
	}
	
	public static String suppressWarnings() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.java)
				+ "suppressWarnings";
		
		return uri;
	}
	
	public static String deprecated() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.java)
				+ "deprecated";
		
		return uri;
	}
}

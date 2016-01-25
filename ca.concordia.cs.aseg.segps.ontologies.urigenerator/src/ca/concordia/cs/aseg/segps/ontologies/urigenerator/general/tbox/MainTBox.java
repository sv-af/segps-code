/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */

package ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;

public class MainTBox {

	// Classes
	public static String Product() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "Product";
		return uri;
	}

	public static String Release() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "Release";
		return uri;
	}
	public static String Artifact() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "Artifact";
		return uri;
	}
	public static String Organization() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "Organization";
		return uri;
	}
}

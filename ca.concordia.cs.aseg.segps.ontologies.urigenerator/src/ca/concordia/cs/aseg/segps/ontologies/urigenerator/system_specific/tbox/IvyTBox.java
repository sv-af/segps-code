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

public class IvyTBox {

	/*
	 * CONCEPTS
	 */
	public static String IvyConfiguration() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.ivy)
				+ "IvyConfiguration";
		
		return uri;
	}

	public static String IvyModule() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.ivy)
				+ "IvyModule";
		
		return uri;
	}

	public static String Visibility() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.ivy)
				+ "Visibility";
		
		return uri;
	}

	/*
	 * PROPERTIES
	 */
	public static String excludesConfiguration() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.ivy)
				+ "excludesConfiguration";
		
		return uri;
	}

	public static String excludesModule() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.ivy)
				+ "excludesModule";
		
		return uri;
	}

	public static String hasConfiguration() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.ivy)
				+ "hasConfiguration";

		return uri;
	}

	public static String hasVisibility() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.ivy)
				+ "hasVisibility";

		return uri;
	}

	public static String usesConfiguration() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.ivy)
				+ "usesConfiguration";

		return uri;
	}

	/*
	 * DEFAULT INDIVIDUALS
	 */
	public static String privateVisibility() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.ivy)
				+ "private";

		return uri;
	}

	public static String publicVisibility() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.ivy)
				+ "public";

		return uri;
	}
}
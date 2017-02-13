/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */
package ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.abox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.utils.URLCleaner;

public class MainABox {
	// Classes
	public static String Product(String Product) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ URLCleaner.clean(Product);
		return uri;
	}

	public static String Release(String Release) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ URLCleaner.clean(Release);
		return uri;
	}

	public static String Artifact(String Artifact) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ URLCleaner.clean(Artifact);
		return uri;
	}

	public static String Organization(String Organization) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ URLCleaner.clean(Organization);
		return uri;
	}

	public static String Developer(String Developer) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ URLCleaner.clean(Developer);
		return uri;
	}

	public static String File(String file) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ URLCleaner.clean(file);
		return uri;
	}

	public static String Directory(String directory) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ URLCleaner.clean(directory);
		return uri;
	}

	public static String Milestone(String milestone) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ URLCleaner.clean(milestone);
		return uri;
	}

	public static String Activity(String activity) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ URLCleaner.clean(activity);
		return uri;
	}

	public static String Stakeholder(String stakeholder) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ URLCleaner.clean(stakeholder);
		return uri;
	}

	public static String License(String license) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ URLCleaner.clean(license);
		return uri;
	}

	public static String SeonThing(String seonThing) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ URLCleaner.clean(seonThing);
		return uri;
	}
}
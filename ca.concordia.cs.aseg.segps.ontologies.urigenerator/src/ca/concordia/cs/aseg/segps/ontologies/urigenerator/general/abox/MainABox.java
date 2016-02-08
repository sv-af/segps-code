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

public class MainABox{
	// Classes
	public static String Product(String Product) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ Product;
		return uri;
	}

	public static String Release(String Release) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ Release;
		return uri;
	}

	public static String Artifact(String Artifact) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ Artifact;
		return uri;
	}
	
	public static String Organization(String Organization) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ Organization;
		return uri;
	}
	public static String Developer(String Developer) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ Developer;
		return uri;
	}
	public static String File(String file) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ file;
		return uri;
	}
	public static String Directory(String directory) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ directory;
		return uri;
	}
	public static String Milestone(String milestone) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ milestone;
		return uri;
	}
	public static String Activity(String activity) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ activity;
		return uri;
	}
	public static String Stakeholder(String stakeholder) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ stakeholder;
		return uri;
	}
	public static String SeonThing(String seonThing) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.main)
				+ seonThing;
		return uri;
	}
}                    
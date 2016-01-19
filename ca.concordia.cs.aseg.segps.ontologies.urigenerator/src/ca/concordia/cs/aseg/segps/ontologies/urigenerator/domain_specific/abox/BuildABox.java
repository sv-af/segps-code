/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */

package ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;

public class BuildABox {
	public static String BuildProject(String project) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.build)
				+ project;
		return uri;
	}

	public static String BuildRelease(String release) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.build)
				+ release;
		return uri;
	}

	public static String DependencyExclusion(String exclusion) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.build)
				+ exclusion;
		return uri;
	}

	public static String DependencyLink(String dependencylink) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.build)
				+ dependencylink;
		return uri;
	}
}
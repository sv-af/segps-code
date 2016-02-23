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
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.utils.URLCleaner;

public class BuildABox {
	public static String BuildProject(String project) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.build)
				+ URLCleaner.clean(project);
		return uri;
	}

	public static String BuildRelease(String release) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.build)
				+  URLCleaner.clean(release);
		return uri;
	}

	public static String DependencyExclusion(String exclusion) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.build)
				+  URLCleaner.clean(exclusion);
		return uri;
	}

	public static String DependencyLink(String dependencylink) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.build)
				+  URLCleaner.clean(dependencylink);
		return uri;
	}
}
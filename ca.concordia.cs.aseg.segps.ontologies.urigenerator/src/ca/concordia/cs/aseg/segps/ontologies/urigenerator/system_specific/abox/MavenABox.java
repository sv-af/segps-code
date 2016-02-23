/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */

package ca.concordia.cs.aseg.segps.ontologies.urigenerator.system_specific.abox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.utils.URLCleaner;

public class MavenABox {
	
	public static String Group(String group) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.maven)
				+ group;
		return  URLCleaner.clean(uri);
	}

	public static String Contributor(String contributor) {
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.maven)
				+  URLCleaner.clean(contributor);
		return uri;
	}

	public static void main(String[] args) {
		String s = MavenABox.Group("org.oracle");
		System.out.println(s);
	}
}
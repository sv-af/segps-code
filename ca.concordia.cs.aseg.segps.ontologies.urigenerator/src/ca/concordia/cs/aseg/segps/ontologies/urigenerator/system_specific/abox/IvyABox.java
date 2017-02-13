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

public class IvyABox {
	public static String Visibility(String visibility){
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.ivy)
				+ URLCleaner.clean(visibility);
		return uri;
	}
	
	public static String IvyModule(String module){
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.ivy)
				+ URLCleaner.clean(module);
		return uri;
	}
	public static String IvyConfiguration(String configuration){
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.ivy)
				+ URLCleaner.clean(configuration);
		return uri;
	}
}
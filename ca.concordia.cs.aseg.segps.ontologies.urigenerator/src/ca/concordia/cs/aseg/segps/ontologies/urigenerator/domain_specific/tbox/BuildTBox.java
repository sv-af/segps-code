/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */

package ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.tbox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;

public class BuildTBox {
	/*
	 * CONCEPTS
	 */
	public static String BuildProject(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.build) + "BuildProject";
		return uri;
	}
	
	public static String BuildRelease(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.build) + "BuildRelease";
		return uri;
	}
	
	/*public static String DependencyExclusion(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.build) + "DependencyExclusion";
		return uri;
	}*/
	
	public static String DependencyLink(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.build) + "DependencyLink";
		return uri;
	}
	/*
	 * PROPERTIES
	 */
	public static String hasVersionNumber(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.build) + "hasVersionNumber";
		return uri;
	}
	
	public static String excludesRelease(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.build) + "excludesRelease";
		return uri;
	}
	
	public static String excludesThing(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.build) + "excludesThing";
		return uri;
	}
	
	public static String hasDependencySource(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.build) + "hasDependencySource";
		return uri;
	}
	
	public static String hasDependencyTarget(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.build) + "hasDependencyTarget";
		return uri;
	}
	
	/*public static String hasExclusion(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.build) + "hasExclusion";
		return uri;
	}*/

	public static String excludesProduct() {
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.build) + "excludesProduct";
		return uri;
	}
	
}
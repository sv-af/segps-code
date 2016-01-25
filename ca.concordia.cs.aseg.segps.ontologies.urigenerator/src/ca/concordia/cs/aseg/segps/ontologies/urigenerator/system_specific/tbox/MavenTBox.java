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

public class MavenTBox {

	/*
	 * CONCEPTS
	 */
	public static String Group(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.maven) + "Group";
		return uri;
	}
	
	public static String Contributor(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.maven) + "Contributor";
		return uri;
	}
	
	/*
	 * PROPERTIES
	 */
	public static String hasGroup(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.maven) + "hasGroup";
		return uri;
	}
	
	public static String hasGroupID(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.maven) + "hasGroupID";
		return uri;
	}

	public static String hasArtifactID() {
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.build) + "hasArtifactID";
		return uri;
	}

	public static String hasDependencyScope() {
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.build) + "hasDependencyScope";
		return uri;
	}

	public static String hasDependencyType() {
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.build) + "hasDependencyType";
		return uri;
	}

	public static String isOptionalDependency() {
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.build) + "isOptionalDependency";
		return uri;
	}
	
	
}
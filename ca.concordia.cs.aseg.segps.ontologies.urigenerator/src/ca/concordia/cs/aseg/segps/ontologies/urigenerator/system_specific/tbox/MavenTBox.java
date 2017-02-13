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
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.maven) + "hasArtifactID";
		return uri;
	}

	public static String hasDependencyScope() {
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.maven) + "hasDependencyScope";
		return uri;
	}

	public static String hasDependencyType() {
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.maven) + "hasDependencyType";
		return uri;
	}

	public static String isOptionalDependency() {
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.maven) + "isOptionalDependency";
		return uri;
	}
	
	public static String hasLicenseName() {
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.maven) + "hasLicenseName";
		return uri;
	}
	
	public static String hasLicenseUrl() {
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.maven) + "hasLicenseUrl";
		return uri;
	}
}
/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */

package ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;

public class MainTBox {

	// Classes
	public static String Product() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "Product";
		return uri;
	}

	public static String Release() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "Release";
		return uri;
	}

	public static String Artifact() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "Artifact";
		return uri;
	}

	public static String Organization() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "Organization";
		return uri;
	}

	public static String Developer() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "Developer";
		return uri;
	}

	public static String File() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "file";
		return uri;
	}

	public static String Directory() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "directory";
		return uri;
	}

	public static String Milestone() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "milestone";
		return uri;
	}

	public static String Activity() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "activity";
		return uri;
	}

	public static String Stakeholder() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "stakeholder";
		return uri;
	}

	public static String SeonThing() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "seonThing";
		return uri;
	}

	// PROPERTIES
	/*
	 *      
	 *     
	 *     
	 */
	public static String belongsToOrgaization() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "belongsToOrgaization";
		return uri;
	}

	public static String belongsToRelease() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "belongsToRelease";
		return uri;
	}

	public static String carriesOutActivity() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "carriesOutActivity";
		return uri;
	}

	public static String containsFile() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "containsFile";
		return uri;
	}

	public static String dependsOn() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "dependsOn";
		return uri;
	}

	public static String hasAuthor() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "hasAuthor";
		return uri;
	}

	public static String hasChild() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "hasChild";
		return uri;
	}

	public static String hasMilestone() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "hasMilestone";
		return uri;
	}

	public static String hasParent() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "hasParent";
		return uri;
	}

	public static String hasRelease() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "hasRelease";
		return uri;
	}

	public static String hasSibling() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "hasSibling";
		return uri;
	}

	public static String isBasedOn() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "isBasedOn";
		return uri;
	}

	public static String isCarriedOutBy() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "isCarriedOutBy";
		return uri;
	}

	public static String isReleaseOf() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "isReleaseOf";
		return uri;
	}

	public static String isSimilar() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "isSimilar";
		return uri;
	}

	/*
	 * DATA PRPERTIES
	 */
	public static String activityEnd() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "activityEnd";
		return uri;
	}

	public static String activityStart() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "activityStart";
		return uri;
	}

	public static String hasCreationDate() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "hasCreationDate";
		return uri;
	}

	public static String hasDescription() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "hasDescription";
		return uri;
	}

	public static String hasEmail() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "hasEmail";
		return uri;
	}

	public static String hasIdentifier() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "hasIdentifier";
		return uri;
	}

	public static String hasModificationDate() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "hasModificationDate";
		return uri;
	}

	public static String hasName() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "hasName";
		return uri;
	}

	public static String hasPath() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "hasPath";
		return uri;
	}

	public static String hasReleaseDate() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "hasReleaseDate";
		return uri;
	}

	public static String hasTargetDate() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.main)
				+ "hasTargetDate";
		return uri;
	}
}

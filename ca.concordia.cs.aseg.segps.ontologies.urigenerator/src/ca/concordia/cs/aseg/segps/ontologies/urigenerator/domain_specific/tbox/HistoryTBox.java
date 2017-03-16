package ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.tbox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;

public class HistoryTBox {
	/*
	 * CONCEPTS
	 */
	public static String Branch() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "Branch";
		return uri;
	}

	public static String ChangeSet() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "ChangeSet";
		return uri;
	}

	public static String Commit() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "Commit";
		return uri;
	}

	public static String Committer() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "Committer";
		return uri;
	}

	public static String Version() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "Version";
		return uri;
	}

	public static String FileUnderVersionControl() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "FileUnderVersionControl";
		return uri;
	}

	/*
	 * OBJECT PROPERTIES
	 */
	public static String appearsInRelease() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "appearsInRelease";
		return uri;
	}

	public static String commitsChangeSet() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "commitsChangeSet";
		return uri;
	}

	public static String commitsVersion() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "commitsVersion";
		return uri;
	}

	public static String constituesVersion() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "constituesVersion";
		return uri;
	}

	public static String containsVersion() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "containsVersion";
		return uri;
	}

	public static String followsVersion() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "followsVersion";
		return uri;
	}

	public static String hasVersion() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "hasVersion";
		return uri;
	}

	public static String isCommittedBy() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "isCommittedBy";
		return uri;
	}

	public static String isOnBranch() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "isOnBranch";
		return uri;
	}

	public static String isVersionOf() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "isVersionOf";
		return uri;
	}

	public static String performsCommit() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "performsCommit";
		return uri;
	}

	public static String precedesVersion() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "precedesVersion";
		return uri;
	}

	public static String isCommittedIn() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "isCommittedIn";
		return uri;
	}

	/*
	 * DATA PROPERTIES
	 */
	public static String committedOn() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "committedOn";
		return uri;
	}

	public static String hasCommitMessage() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "hasCommitMessage";
		return uri;
	}

	public static String hasContentIdentifier() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "hasContentIdentifier";
		return uri;
	}

	public static String hasTag() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "hasTag";
		return uri;
	}

	public static String linesAdded() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "linesAdded";
		return uri;
	}

	public static String linesDeleted() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.history) + "linesDeleted";
		return uri;
	}

}

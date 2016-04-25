package ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.utils.URLCleaner;

public class IssuesABox {

	public static String Issue(String project, String issueId) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ project + "/" + issueId;
		return URLCleaner.clean(uri);
	}

	public static String Assignee(String project, String assigneeId) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ project + "/" + assigneeId;
		return URLCleaner.clean(uri);
	}

	public static String Attachment(String project, String attachmentId) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ project + "/" + attachmentId;
		return URLCleaner.clean(uri);
	}

	public static String Bug(String project, String bugId) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ project + "/" + bugId;
		return URLCleaner.clean(uri);
	}

	public static String Comment(String project, String issueId, String comment) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ project + "/" + issueId + "/" + comment;
		return URLCleaner.clean(uri);
	}

	public static String Enhancement(String project, String enhancement) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ project + "/" + enhancement;
		return URLCleaner.clean(uri);
	}

	public static String FeatureAddition(String project, String featureAddition) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ project + "/" + featureAddition;
		return URLCleaner.clean(uri);
	}

	public static String FeatureRequest(String project, String featureRequest) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ project + "/" + featureRequest;
		return URLCleaner.clean(uri);
	}

	public static String Improvement(String project, String improvement) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ project + "/" + improvement;
		return URLCleaner.clean(uri);
	}

	public static String Priority(String priority) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ priority;
		return URLCleaner.clean(uri);
	}

	public static String Reporter(String project, String reporter) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ project + "/" + reporter;
		return URLCleaner.clean(uri);
	}

	public static String Resolution(String resolution) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ resolution;
		return URLCleaner.clean(uri);
	}

	public static String Severity(String project, String severity) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ project + "/" + severity;
		return URLCleaner.clean(uri);
	}

	public static String Status(String project, String status) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ project + "/" + status;
		return URLCleaner.clean(uri);
	}
}

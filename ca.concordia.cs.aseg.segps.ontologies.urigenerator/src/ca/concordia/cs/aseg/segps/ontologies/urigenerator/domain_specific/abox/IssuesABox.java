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
				+ "Issue/" + project + "/" + issueId;
		return URLCleaner.clean(uri);
	}

	public static String Assignee(String project, String assigneeId) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ "Assignee/" + project + "/" + assigneeId;
		return URLCleaner.clean(uri);
	}

	public static String Attachment(String project, String attachmentId) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ "Attachment/" + project + "/" + attachmentId;
		return URLCleaner.clean(uri);
	}

	public static String Comment(String project, String issueId, String comment) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ "Comment/" + project + "/" + issueId + "/" + comment;
		return URLCleaner.clean(uri);
	}

	// TODO
	public static String Enhancement(String project, String enhancement) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ "Enhancement/" + project + "/" + enhancement;
		return URLCleaner.clean(uri);
	}

	// TODO
	public static String FeatureAddition(String project, String featureAddition) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ "FeatureAddition/" + project + "/" + featureAddition;
		return URLCleaner.clean(uri);
	}

	// TODO
	public static String FeatureRequest(String project, String featureRequest) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ "FeatureRequest/" + project + "/" + featureRequest;
		return URLCleaner.clean(uri);
	}

	// TODO
	public static String Improvement(String project, String improvement) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ "Improvement/" + project + "/" + improvement;
		return URLCleaner.clean(uri);
	}

	public static String Priority(String priority) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ "Priority/" + priority;
		return URLCleaner.clean(uri);
	}

	public static String Reporter(String project, String reporter) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ "Reporter/" + project + "/" + reporter;
		return URLCleaner.clean(uri);
	}

	public static String Resolution(String resolution) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ "Resolution/" + resolution;
		return URLCleaner.clean(uri);
	}

	public static String Severity(String severity) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ "Severity/" + severity;
		return URLCleaner.clean(uri);
	}

	public static String Status(String project, String status) {
		String uri = NamespaceFactory
				.createAboxNamespace(NamespaceRegistry.theSEONAboxNameSpace,
						OntologyRegistry.issues)
				+ "Status/" + status;
		return URLCleaner.clean(uri);
	}
}

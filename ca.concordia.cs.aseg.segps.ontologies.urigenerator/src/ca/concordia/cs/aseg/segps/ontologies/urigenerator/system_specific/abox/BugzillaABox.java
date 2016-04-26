package ca.concordia.cs.aseg.segps.ontologies.urigenerator.system_specific.abox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox.IssuesABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.utils.URLCleaner;

public class BugzillaABox extends IssuesABox {
	// ///////////////////CONCEPTS//////////////////////////////////
	public static String Component(String projectName, String component) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace,
				OntologyRegistry.issues_bugzilla)
				+ "/Component" + "/" + projectName + "/" + component;
		return URLCleaner.clean(uri);
	}
	
	public static String OperatingSystem(String operatingSystem) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace,
				OntologyRegistry.issues_bugzilla)
				+ "/OperatingSystem" + "/" + operatingSystem;
		return URLCleaner.clean(uri);
	}
	
	public static String Platform(String platform) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace,
				OntologyRegistry.issues_bugzilla)
				+ "/Platform" + "/" + platform;
		return URLCleaner.clean(uri);
	}
	
	public static String Priority(String priority) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace,
				OntologyRegistry.issues_bugzilla)
				+ "/Priority" + "/" + priority;
		return URLCleaner.clean(uri);
	}
	
	public static String Status(String status) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace,
				OntologyRegistry.issues_bugzilla)
				+ "/Status" + "/" + status;
		return URLCleaner.clean(uri);
	}
	
	public static String Severity(String severity) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theSEONAboxNameSpace,
				OntologyRegistry.issues_bugzilla)
				+ "/Severity" + "/" + severity;
		return URLCleaner.clean(uri);
	}
	
//	// ///////////////////INDIVIDUALS//////////////////////////////////
//	public static enum Priority {
//		P1, P2, P3, P4, P5
//	}
//	
//	public static enum Status {
//		ASSIGNED, CLOSED, NEW, REOPENED, RESOLVED, UNCONFIRMED, VERIFIED
//	}
//	
//	public static enum Severity {
//		BLOCKER, CLEANUP, CRITICAL, ENHANCEMENT, MAJOR, MINOR, NORMAL, TRIVIAL
//	}
//	
//	public static enum Resolution {
//		DUPLICATE, FIXED, INVALID, MOVED, WONTFIX, WORKSFORME
//	}
//	
//	public static enum OperatingSystem {
//		LINUX, MACOS, OTHEROS, WINDOWS
//	}
//	
//	public static enum Platform {
//		PC, MAC, OTHERPLATFORM
//	}
}

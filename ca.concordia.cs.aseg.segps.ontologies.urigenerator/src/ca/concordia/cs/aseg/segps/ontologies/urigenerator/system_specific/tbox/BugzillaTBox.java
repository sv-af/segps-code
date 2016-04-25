package ca.concordia.cs.aseg.segps.ontologies.urigenerator.system_specific.tbox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.tbox.IssuesTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;

public class BugzillaTBox extends IssuesTBox{
	// ///////////////////PROPERTIES//////////////////////////////////
	public static String affectsComponent() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.issues_bugzilla)
				+ "/affectsComponent";
		return uri;
	}
	
	public static String hasCC() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.issues_bugzilla)
				+ "/hasCC";
		return uri;
	}
	
	public static String hasQAContact() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.issues_bugzilla)
				+ "/hasQAContact";
		return uri;
	}
	
	public static String isTargetedFor() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.issues_bugzilla)
				+ "/isTargetedFor";
		return uri;
	}
	
	// ///////////////////CONCEPTS//////////////////////////////////
	public static String Component() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.issues_bugzilla)
				+ "/Component";
		return uri;
	}
	
	public static String OperatingSystem() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.issues_bugzilla)
				+ "/OperatingSystem";
		return uri;
	}
	
	public static String Platform() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theSEONTboxNameSpace,
				OntologyRegistry.issues_bugzilla)
				+ "/Platform";
		return uri;
	}
	
	// ///////////////////INDIVIDUALS//////////////////////////////////
}

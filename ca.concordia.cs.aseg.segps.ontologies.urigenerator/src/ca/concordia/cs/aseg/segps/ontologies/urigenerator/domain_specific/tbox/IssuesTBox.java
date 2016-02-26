package ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.tbox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;

public class IssuesTBox {

	/**
	 * Concepts
	 */
	public static String Assignee() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "Assignee";
		return uri;
	}
	
	public static String Attachment() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "Attachment";
		return uri;
	}
	
	public static String Bug() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "Bug";
		return uri;
	}
	
	public static String Comment() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "Comment";
		return uri;
	}
	
	public static String Enhancement() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "Enhancement";
		return uri;
	}
	
	public static String FeatureAddition() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "FeatureAddition";
		return uri;
	}
	
	public static String FeatureRequest() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "FeatureRequest";
		return uri;
	}
	
	public static String Improvement() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "Improvement";
		return uri;
	}
	
	public static String Issue() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "Issue";
		return uri;
	}
	
	public static String Priority() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "Priority";
		return uri;
	}
	
	public static String Reporter() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "Reporter";
		return uri;
	}
	
	public static String Resolution() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "Resolution";
		return uri;
	}
	
	public static String Severity() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "Severity";
		return uri;
	}
	
	public static String Status() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "Status";
		return uri;
	}
	
	/**
	 * OBJECT PROPERTIES
	 */
	public static String blocksIssue() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "blocksIssue";
		return uri;
	}
	
	public static String commentsIssue(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "commentsIssue";
		return uri;
	}
	
	public static String dependsOnIssue(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "dependsOnIssue";
		return uri;
	}
	
	public static String hasAssignee(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "hasAssignee";
		return uri;
	}
	
	public static String hasAttachment(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "hasAttachment";
		return uri;
	}
	
	public static String hasComment(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "hasComment";
		return uri;
	}
	
	public static String hasDuplicate(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "hasDuplicate";
		return uri;
	}
	
	public static String hasPriority(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "hasPriority";
		return uri;
	}
	
	public static String hasReporter(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "hasReporter";
		return uri;
	}
	
	public static String hasResolution(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "hasResolution";
		return uri;
	}
	
	public static String hasSeverity(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "hasSeverity";
		return uri;
	}
	
	public static String hasStatus(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "hasStatus";
		return uri;
	}
	
	public static String isAssigneeOf(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "isAssigneeOf";
		return uri;
	}
	
	public static String isAttachementOf(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "isAttachementOf";
		return uri;
	}
	
	public static String isBlockedBy(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "isBlockedBy";
		return uri;
	}
	
	public static String isCommentedBy(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "isCommentedBy";
		return uri;
	}
	
	public static String isCommentOf(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "isCommentOf";
		return uri;
	}
	
	public static String isReporterOf(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "isReporterOf";
		return uri;
	}
	
	/**
	 * DATA PROPERTIES
	 */
	public static String hasActualEffort(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "hasActualEffort";
		return uri;
	}
	
	public static String hasCommentText(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "hasCommentText";
		return uri;
	}
	
	public static String hasEstimatedEffort(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "hasEstimatedEffort";
		return uri;
	}
	
	public static String hasIssueNumber(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "hasIssueNumber";
		return uri;
	}
	
	public static String hasResolutionDate(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "hasResolutionDate";
		return uri;
	}
	
	public static String hasTitle(){
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.issues)
				+ "hasTitle";
		return uri;
	}
}


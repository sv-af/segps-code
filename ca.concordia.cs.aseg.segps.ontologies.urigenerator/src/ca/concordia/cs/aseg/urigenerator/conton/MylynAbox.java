 package ca.concordia.cs.aseg.urigenerator.conton;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.utils.URLCleaner;

public class MylynAbox {
	public static String InteractionHistory(String projectName, String issueId) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theContonAboxNameSpace,
				OntologyRegistry.mylyn)
				+ "/InteractionHistory" + "/" + projectName + "/" + issueId;
		return URLCleaner.clean(uri);
	}

	public static String InteractionEvent(String projectName, String issueId, String eventId) {
		String uri = NamespaceFactory.createAboxNamespace(
				NamespaceRegistry.theContonAboxNameSpace,
				OntologyRegistry.mylyn)
				+ "/InteractionEvent" + "/" + projectName + "/" + issueId + "/" + eventId;
		return URLCleaner.clean(uri);
	}
}

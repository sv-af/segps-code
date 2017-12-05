package ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.utils.URLCleaner;

public class VideoAbox {
	
	public static String Video(String videoURL) {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.videos)
				+ URLCleaner.clean(release);
		return uri;
	}

	public static String Speech(String video, String speechID) {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.videos)
				+ URLCleaner.clean(release);
		return uri;
	}

	public static String Image(String video, String imageID) {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.videos)
				+ URLCleaner.clean(release);
		return uri;
	}

	public static String Topic(String video, String topicName) {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.videos)
				+ URLCleaner.clean(release);
		return uri;
	}

	public static String Comment(String video, String commentID, String commenter) {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.videos)
				+ URLCleaner.clean(release);
		return uri;
	}
	
	public static String Publisher(String publisherName) {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.videos)
				+ URLCleaner.clean(publisherName);
		return uri;
	}


}

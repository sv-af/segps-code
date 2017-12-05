package ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.tbox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox.VideoAbox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox.MainTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox.RDF;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;

public class VideoTBox {
	/*
	 * CONCEPTS
	 */
	public static String Video() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.videos)
				+ "Video";
		return uri;
	}

	public static String Speech() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.videos)
				+ "Speech";
		return uri;
	}

	public static String Image() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.videos)
				+ "Image";
		return uri;
	}

	public static String Topic() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.videos)
				+ "Topic";
		return uri;
	}

	public static String Comment() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.videos)
				+ "Comment";
		return uri;
	}
	
	public static String Publisher() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.videos)
				+ "Publisher";
		return uri;
	}

	/*
	 * OBJECT PROPERTIES
	 */
	public static String hasSpeech() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.videos)
				+ "hasSpeech";
		return uri;
	}

	public static String hasImage() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.videos)
				+ "hasImage";
		return uri;
	}

	public static String hasTopic() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.videos)
				+ "hasTopic";
		return uri;
	}

	public static String hasComment() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.videos)
				+ "hasComment";
		return uri;
	}
	
	public static String hasReply() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.videos)
				+ "hasReply";
		return uri;
	}

	public static String isReplyOf() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.videos)
				+ "isReplyOf";
		return uri;
	}
	
	/*
	 * DATA PROPERTIES
	 */
	public static String hasText() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.videos)
				+ "hasText";
		return uri;
	}

	public static String hasKeyword() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.videos)
				+ "hasKeyword";
		return uri;
	}

	public static String hasLabel() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.videos)
				+ "hasLabel";
		return uri;
	}

	public static String hasTitle() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.videos)
				+ "hasTitle";
		return uri;
	}

	public static void main(String[] args) {

		String video, author, title, url;
		url = "https://www.youtube.com/watch?v=EO91xsIPd5o";
		author = VideoAbox.Author("Radio Javan");
		video = VideoAbox.Video(url);
		title = "Title1";

		System.out.println(video + "\t\t" + RDF.type() + "\t\t" + VideoTBox.Video());
		System.out.println(author + "\t\t" + RDF.type() + "\t\t" + MainTBox.Stakeholder());
		System.out.println(video + "\t\t" + MainTBox.hasAuthor() + "\t\t" + author);
		// System.out.println(VideoTBox.Speech());
		// System.out.println(VideoTBox.Image());
	}
}

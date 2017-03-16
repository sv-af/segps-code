package ca.concordia.cs.aseg.segps.ontologies.publisher.history;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ca.concordia.cs.aseg.segps.ontologies.publisher.util.NtriplesWriter;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox.HistoryABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.tbox.HistoryTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox.MainTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox.RDF;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox.RDFS;

public abstract class CVSPublisher {
	private int declarationSize = 100000, individualSize = 500000;

	public void publishFromArtifactList(List<CVSArtifact> artifacts, String outputLocation) throws Exception {
		NtriplesWriter triplesWriter = new NtriplesWriter(outputLocation, declarationSize, individualSize);
		for (CVSArtifact artifact : artifacts) {
			// System.out.println(artifact.toString());
			createTriples(artifact, triplesWriter);
		}
		triplesWriter.flushAndClose();
	}

	public void publishFromRevisionList(List<String> revisionURLS, String outputLocation) throws Exception {
		NtriplesWriter triplesWriter = new NtriplesWriter(outputLocation, declarationSize, individualSize);
		for (String url : revisionURLS) {
			CVSArtifact artifact = createArtifact(url);
			createTriples(artifact, triplesWriter);
		}
		triplesWriter.flushAndClose();
	}

	public void publishFromRevision(String revisionURL, String outputLocation) throws IOException {
		System.out.println("\nPublishing: " + revisionURL);
		NtriplesWriter triplesWriter = new NtriplesWriter(outputLocation, declarationSize, individualSize);
		CVSArtifact artifact = createArtifact(revisionURL);
		try {
			createTriples(artifact, triplesWriter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		triplesWriter.flushAndClose();
	}

	public abstract CVSArtifact createArtifact(String revisionURL);

	public abstract Map<String, String> createFileVersionMap(List<String> changeset);

	private void createTriples(CVSArtifact artifact, NtriplesWriter ntriplesWriter) throws Exception {
		System.out.println(artifact);
		String commitURI = HistoryABox.Commit(artifact.getRevisionURL());
		String committerURI = HistoryABox.Committer(artifact.getCommitter());
		String changesetURI = HistoryABox.ChangeSet(artifact.getCommitID(), artifact.getCommitter(),
				artifact.getCommitDate());

		// create triples for types
		ntriplesWriter.addDeclarationTriple(commitURI, RDF.type(), HistoryTBox.Commit(), false);
		ntriplesWriter.addDeclarationTriple(committerURI, RDF.type(), HistoryTBox.Committer(), false);
		ntriplesWriter.addDeclarationTriple(changesetURI, RDF.type(), HistoryTBox.ChangeSet(), false);

		// create relationship between types
		ntriplesWriter.addIndividualTriple(committerURI, HistoryTBox.performsCommit(), commitURI, false);
		ntriplesWriter.addIndividualTriple(committerURI, HistoryTBox.commitsChangeSet(), changesetURI, false);

		// create data properties
		ntriplesWriter.addIndividualTriple(changesetURI, HistoryTBox.committedOn(), artifact.getCommitDate(), true);
		ntriplesWriter.addIndividualTriple(changesetURI, HistoryTBox.hasCommitMessage(), artifact.getCommitMessage(),
				true);
		ntriplesWriter.addIndividualTriple(commitURI, MainTBox.hasIdentifier(), artifact.getCommitID(), true);
		ntriplesWriter.addIndividualTriple(committerURI, MainTBox.hasName(), artifact.getCommitter(), true);
		ntriplesWriter.addIndividualTriple(commitURI, MainTBox.hasURL(), artifact.getRevisionURL(), true);
		if (artifact.getAuthor() != null) {
			ntriplesWriter.addIndividualTriple(commitURI, MainTBox.hasAuthor(), artifact.getAuthor(), true);
		}

		// Create types, object and data properties for files in changed set
		for (String file : artifact.getChangeSet().keySet()) {
			String versionFile = artifact.getChangeSet().get(file);
			String fileURI = HistoryABox.FileUnderVersionControl(file);
			ntriplesWriter.addDeclarationTriple(fileURI, RDF.type(), HistoryTBox.FileUnderVersionControl(), false);

			String versionURI = HistoryABox.Version(versionFile);
			ntriplesWriter.addDeclarationTriple(versionURI, RDF.type(), HistoryTBox.Version(), false);

			ntriplesWriter.addIndividualTriple(committerURI, HistoryTBox.commitsVersion(), versionURI, false);
			ntriplesWriter.addIndividualTriple(commitURI, HistoryTBox.constituesVersion(), versionURI, false);
			ntriplesWriter.addIndividualTriple(changesetURI, HistoryTBox.containsVersion(), versionURI, false);
			ntriplesWriter.addIndividualTriple(fileURI, HistoryTBox.hasVersion(), versionURI, false);

			ntriplesWriter.addIndividualTriple(versionURI, HistoryTBox.hasContentIdentifier(), artifact.getCommitID(),
					true);

		}

		// Add tags for explicitly mentioned CVEs
		Matcher m = Pattern.compile("CVE-\\d{4}-\\d{4,7}").matcher(artifact.getCommitMessage());
		while (m.find()) {
			ntriplesWriter.addIndividualTriple(commitURI, RDFS.label(), m.group(), true);
		}

	}

	public static String processLink(String link) {
		String processedLink = "";
		if (link.startsWith("http://svn.apache.org")) {
			Pattern pattern = null;
			if (link.contains("pathrev")) {
				pattern = Pattern.compile("pathrev=(\\d+)");
			} else if (link.contains("r1") && link.contains("r2")) {
				pattern = Pattern.compile("r2=(\\d+)");
			} else if (link.contains("revision=r")) {
				pattern = Pattern.compile("revision=r(\\d+)");
			} else if (link.contains("revision")) {
				pattern = Pattern.compile("revision=(\\d+)");
			} else if (link.contains("rev")) {
				pattern = Pattern.compile("rev=(\\d+)");
			} else if (link.contains("org/r")) {
				pattern = Pattern.compile("r(\\d+)");
			}
			Matcher matcher = pattern.matcher(link);
			String revNum = null;
			while (matcher.find()) {
				revNum = matcher.group(1);
			}
			processedLink = "http://svn.apache.org/r" + revNum;
		} else if (link.startsWith("https://github")) {
			// process links into format:
			// https://api.github.com/repos/:owner/:repo/commits/:sha
			if (link.contains("/commit/")) {
				String[] linkParts = link.split("/");
				int i = linkParts.length - 1;
				processedLink = "https://api.github.com/repos/" + linkParts[i - 3] + "/" + linkParts[i - 2]
						+ "/commits/" + linkParts[i];
			}
		}
		return processedLink;
	}

	public abstract String convertDate(String date);

	
}

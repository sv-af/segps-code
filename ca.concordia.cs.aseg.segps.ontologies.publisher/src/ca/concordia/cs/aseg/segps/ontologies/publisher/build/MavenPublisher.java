package ca.concordia.cs.aseg.segps.ontologies.publisher.build;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

import ca.concordia.cs.aseg.maven.parser.MavenArtifact;
import ca.concordia.cs.aseg.maven.parser.MavenDependency;
import ca.concordia.cs.aseg.maven.util.Serializer;
import ca.concordia.cs.aseg.segps.ontologies.publisher.ntriples.NtriplesWriter;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox.BuildABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.tbox.BuildTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.abox.MainABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox.MainTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox.RDF;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.system_specific.abox.MavenABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.system_specific.tbox.MavenTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.utils.URLCleaner;

public class MavenPublisher {
	/*
	 * Publish triples from directory of POMs
	 */
	public void publish(String outputFileLocation, String directory) {
		publish(outputFileLocation, directory, 0);
	}

	/*
	 * Publish triples from directory of either POMs or serialized MavenArtifact
	 * objects
	 */
	public void publish(String outputFileLocation, String file, int mode) {
		switch (mode) {
		case 0:
			publishFromPom(outputFileLocation, file);
			break;
		case 1:
			publishFromArtifactObject(outputFileLocation, file);
			break;
		}
	}

	public void publishFromPom(String outputFileLocation, String inputFilesLocation) {
		NtriplesWriter triplesWriter = new NtriplesWriter(outputFileLocation, 100000, 500000);
		String[] extensions = { "pom" };
		MavenArtifact mavenArtifact;
		File baseDirectory = new File(inputFilesLocation);
		try {
			if (baseDirectory.isDirectory()) {
				File[] dirs = baseDirectory.listFiles();
				for (int d = 0; d < dirs.length; d++) {
					if (dirs[d].isDirectory()) {

						System.out.println("Working on directory(" + d + "): " + dirs[d].getName());

						/*
						 * if (dirs[d].getName().equals("org")) { continue; }
						 */

						/*
						 * if (dirs[d].getName().equals("apache") ||
						 * dirs[d].getName().equals("glassfish") ||
						 * dirs[d].getName().equals("jboss") ||
						 * dirs[d].getName().equals("ow2") ||
						 * dirs[d].getName().equals("codehaus")) { continue; }
						 */
						List<File> pomFiles = (List<File>) FileUtils.listFiles(dirs[d], extensions, true);
						System.out.println("\t Num of files: " + pomFiles.size());
						File file = null;

						for (int i = 0; i < pomFiles.size(); i++) {
							file = pomFiles.get(i);
							mavenArtifact = MavenArtifact.getArtifactFromPOM(file);
							if (mavenArtifact != null) {
								createTriples(mavenArtifact, triplesWriter);
							}
							pomFiles.set(i, null);
						}
						dirs[d] = null;
					} else {
						if (dirs[d].getName().endsWith(".pom")) {
							mavenArtifact = MavenArtifact.getArtifactFromPOM(dirs[d]);
							if (mavenArtifact != null) {
								createTriples(mavenArtifact, triplesWriter);
							}
						}
					}
				}

			} else {
				if (baseDirectory.getName().endsWith(".pom")) {
					mavenArtifact = MavenArtifact.getArtifactFromPOM(baseDirectory);
					if (mavenArtifact != null) {
						createTriples(mavenArtifact, triplesWriter);
					}
				}
			}
			triplesWriter.flushAndClose();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void publishFromArtifactObject(String outputFileLocation, String inputFilesLocation) {
		NtriplesWriter triplesWriter = new NtriplesWriter(outputFileLocation, 100000, 500000);
		try {
			File baseDirectory = new File(inputFilesLocation);
			if (baseDirectory.isDirectory()) {
				String[] parsedArtifacts = baseDirectory.list();
				System.out.println("\t Num of files: " + parsedArtifacts.length);
				File file = null;
				MavenArtifact mavenArtifact = null;
				
				for (int i = 0; i < parsedArtifacts.length; i++) {
					file = new File(baseDirectory.getAbsolutePath() + "\\" + parsedArtifacts[i]);
					mavenArtifact = (MavenArtifact) Serializer.unserializeFile(file);
					if (mavenArtifact != null) {
						createTriples(mavenArtifact, triplesWriter);
					}
					parsedArtifacts[i] = null;
				}
			} else {
				MavenArtifact mavenArtifact = (MavenArtifact) Serializer.unserializeFile(baseDirectory);

				if (mavenArtifact != null) {
					createTriples(mavenArtifact, triplesWriter);
				}
			}
			triplesWriter.flushAndClose();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private String createArtifactTriples(MavenArtifact mavenArtifact, NtriplesWriter triplesWriter) throws Exception {
		// create types
		String organizationURI =  URLCleaner.clean(MainABox.Organization(mavenArtifact.getOrganization()));
		String groupURI = MavenABox.Group(mavenArtifact.getGroupId());
		String projectURI = BuildABox.BuildProject(mavenArtifact.getGroupId() + ":" + mavenArtifact.getArtifactId());
		String versionURI = BuildABox.BuildRelease(mavenArtifact.toString());

		triplesWriter.addDeclarationTriple(organizationURI, RDF.type(), MainTBox.Organization(), false);
		triplesWriter.addDeclarationTriple(groupURI, RDF.type(), MavenTBox.Group(), false);
		triplesWriter.addDeclarationTriple(projectURI, RDF.type(), BuildTBox.BuildProject(), false);
		triplesWriter.addDeclarationTriple(versionURI, RDF.type(), BuildTBox.BuildRelease(), false);

		// create relationship between types
		triplesWriter.addIndividualTriple(projectURI, MavenTBox.hasGroup(), groupURI, false);
		triplesWriter.addIndividualTriple(projectURI, MainTBox.hasRelease(), versionURI, false);
		triplesWriter.addIndividualTriple(projectURI, MainTBox.belongsToOrgaization(), organizationURI, false);

		// create data properties
		triplesWriter.addIndividualTriple(projectURI, MavenTBox.hasArtifactID(), mavenArtifact.getArtifactId(), true);
		triplesWriter.addIndividualTriple(groupURI, MavenTBox.hasGroupID(), mavenArtifact.getGroupId(), true);
		triplesWriter.addIndividualTriple(versionURI, BuildTBox.hasVersionNumber(), mavenArtifact.getVersion(), true);
		triplesWriter.addIndividualTriple(versionURI, MainTBox.hasName(), mavenArtifact.getName(), true);
		triplesWriter.addIndividualTriple(versionURI, MainTBox.hasDescription(), mavenArtifact.getDescription(), true);
		return versionURI;

	}

	private void createTriples(MavenArtifact mavenArtifact, NtriplesWriter triplesWriter) throws Exception {
		System.out.println("creating triples for:" + mavenArtifact.toString());
		String mainArtifact = createArtifactTriples(mavenArtifact, triplesWriter);
		if (mavenArtifact.getParent() != null) {
			String parent = createArtifactTriples(mavenArtifact.getParent(), triplesWriter);
			triplesWriter.addIndividualTriple(mainArtifact, MainTBox.hasParent(), parent, false);
		}
		for (MavenDependency dependency : mavenArtifact.getDependencies()) {
			String depLinkUri = BuildABox.DependencyLink(mavenArtifact.toString() + "_" + dependency.toString());
			String dependencyUri=BuildABox.BuildRelease(dependency.toString());

			triplesWriter.addDeclarationTriple(depLinkUri, RDF.type(), BuildTBox.DependencyLink(), false);

			// create relationship between types
			triplesWriter.addIndividualTriple(depLinkUri, BuildTBox.hasDependantLink(), mainArtifact, false);
			triplesWriter.addIndividualTriple(depLinkUri, BuildTBox.hasDependencyLink(), dependencyUri, false);
			
			// create data properties
			if (dependency.getScope() != null) {
				triplesWriter.addIndividualTriple(depLinkUri, MavenTBox.hasDependencyScope(), dependency.getScope(), true);
			}
			triplesWriter.addIndividualTriple(depLinkUri, MavenTBox.hasDependencyType(), dependency.getType(), true);
			triplesWriter.addIndividualTriple(depLinkUri, MavenTBox.isOptionalDependency(), String.valueOf(dependency.isOptional()), true);
			
			for (String exclusion : dependency.getExclusions()) {
				String exclusionURI=BuildABox.BuildProject(exclusion).toString();
				triplesWriter.addIndividualTriple(depLinkUri, BuildTBox.excludesProduct(), exclusionURI, false);
			}
		}
		mavenArtifact = null;
	}
}

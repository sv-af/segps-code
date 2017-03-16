package ca.concordia.cs.aseg.segps.ontologies.publisher.build;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import ca.concordia.cs.aseg.maven.parser.models.MavenArtifact;
import ca.concordia.cs.aseg.maven.parser.models.MavenDependency;
import ca.concordia.cs.aseg.maven.parser.models.MavenLicense;
import ca.concordia.cs.aseg.maven.util.Serializer;
import ca.concordia.cs.aseg.segps.ontologies.publisher.util.NtriplesWriter;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox.BuildABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.tbox.BuildTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.abox.MainABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox.MainTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox.RDF;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.system_specific.abox.MavenABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.system_specific.tbox.MavenTBox;

public class MavenPublisher {

	private int declarationSize = 100000, individualSize = 500000;

	/*
	 * Publish triples from directory of POMs
	 */
	public void publish(String outputFileLocation, String directory) {
		publish(outputFileLocation, directory, 0);
	}

	/*
	 * Publish triples from directory of either indexFile, POM directory or
	 * serialized MavenArtifact objects
	 */
	public void publish(String outputFileLocation, String file, int mode) {
		switch (mode) {
		case 0:
			publishFromPom(outputFileLocation, file);
			break;
		case 1:
			publishFromArtifactObject(outputFileLocation, file);
			break;
		case 2:
			try {
				publishFromIndexFile(outputFileLocation, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	private void publishFromPom(String outputFileLocation, String inputFilesLocation) {
		NtriplesWriter triplesWriter = new NtriplesWriter(outputFileLocation, declarationSize, individualSize);
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
							mavenArtifact = MavenArtifact.getArtifactFromPOM(file, null);
							if (mavenArtifact != null) {
								createTriples(mavenArtifact, triplesWriter);
							}
							pomFiles.set(i, null);
						}
						dirs[d] = null;
					} else {
						if (dirs[d].getName().endsWith(".pom")) {
							mavenArtifact = MavenArtifact.getArtifactFromPOM(dirs[d], null);
							if (mavenArtifact != null) {
								createTriples(mavenArtifact, triplesWriter);
							}
						}
					}
				}

			} else {
				if (baseDirectory.getName().endsWith(".pom")) {
					mavenArtifact = MavenArtifact.getArtifactFromPOM(baseDirectory, null);
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

	private void publishFromArtifactObject(String outputFileLocation, String inputFilesLocation) {
		NtriplesWriter triplesWriter = new NtriplesWriter(outputFileLocation, declarationSize, individualSize);
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

	private void publishFromIndexFile(String outputFileLocation, String indexFileLocation) throws IOException {
		NtriplesWriter triplesWriter = new NtriplesWriter(outputFileLocation, declarationSize, individualSize);
		File index = new File(indexFileLocation);
		List<String> indexitems = FileUtils.readLines(index);
		//int count = 0;
		for (String item : indexitems) {
			MavenArtifact mavenArtifact = MavenArtifact.getArtifactFromGAV(item);
			if (mavenArtifact != null) {
				try {
					createTriples(mavenArtifact, triplesWriter);
					//count++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			item = null;
			/*
			 * if (count == 100) break;
			 */
		}
		triplesWriter.flushAndClose();
	}

	public void publishFromMavenArtifactList(String outputFileLocation, List<MavenArtifact> inputList)
			throws IOException {
		NtriplesWriter triplesWriter = new NtriplesWriter(outputFileLocation, declarationSize, individualSize);
		for (MavenArtifact mavenArtifact : inputList) {
			if (mavenArtifact != null) {
				try {
					createTriples(mavenArtifact, triplesWriter);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		triplesWriter.flushAndClose();
	}

	private String createArtifactTriples(MavenArtifact mavenArtifact, NtriplesWriter triplesWriter) throws Exception {
		// create types
		String groupURI = MavenABox.Group(mavenArtifact.getGroupId());
		String projectURI = BuildABox.BuildProject(mavenArtifact.getGroupId() + ":" + mavenArtifact.getArtifactId());
		String versionURI = BuildABox.BuildRelease(mavenArtifact.toString());

		triplesWriter.addDeclarationTriple(groupURI, RDF.type(), MavenTBox.Group(), false);
		triplesWriter.addDeclarationTriple(projectURI, RDF.type(), BuildTBox.BuildProject(), false);
		triplesWriter.addDeclarationTriple(versionURI, RDF.type(), BuildTBox.BuildRelease(), false);

		// create relationship between types
		triplesWriter.addIndividualTriple(projectURI, MavenTBox.hasGroup(), groupURI, false);
		triplesWriter.addIndividualTriple(projectURI, MainTBox.hasRelease(), versionURI, false);
		if (mavenArtifact.getOrganizationName() != null) {
			String organizationURI = MainABox.Organization(mavenArtifact.getOrganizationName());
			triplesWriter.addDeclarationTriple(organizationURI, RDF.type(), MainTBox.Organization(), false);
			triplesWriter.addIndividualTriple(projectURI, MainTBox.belongsToOrganization(), organizationURI, false);
			triplesWriter.addIndividualTriple(organizationURI, MainTBox.hasName(), mavenArtifact.getOrganizationName(),
					true);
			if (mavenArtifact.getOrganizationURL() != null) {
				triplesWriter.addIndividualTriple(organizationURI, MainTBox.hasURL(),
						mavenArtifact.getOrganizationURL(), true);
			}
		}
		// create data properties
		triplesWriter.addIndividualTriple(projectURI, MavenTBox.hasArtifactID(), mavenArtifact.getArtifactId(), true);
		triplesWriter.addIndividualTriple(groupURI, MavenTBox.hasGroupID(), mavenArtifact.getGroupId(), true);
		triplesWriter.addIndividualTriple(versionURI, BuildTBox.hasVersionNumber(), mavenArtifact.getVersion(), true);
		triplesWriter.addIndividualTriple(versionURI, MainTBox.hasName(), mavenArtifact.getName(), true);
		triplesWriter.addIndividualTriple(versionURI, MainTBox.hasDescription(), mavenArtifact.getDescription(), true);
		if (mavenArtifact.getReleasedDate() != null) {
			triplesWriter.addIndividualTriple(versionURI, MainTBox.hasReleaseDate(),
					mavenArtifact.getReleasedDate().toString(), true);
		}
		return versionURI;

	}

	private void createTriples(MavenArtifact mavenArtifact, NtriplesWriter triplesWriter) throws Exception {
		System.out.println("creating triples for:" + mavenArtifact.toString());
		String mainArtifact = createArtifactTriples(mavenArtifact, triplesWriter);

		if (mavenArtifact.getParent() != null) {
			String parent = BuildABox.BuildRelease(mavenArtifact.getParent().toString());
			triplesWriter.addIndividualTriple(mainArtifact, MainTBox.hasParent(), parent, false);
		}
		if (mavenArtifact.getDependencies() != null) {
			for (MavenDependency dependency : mavenArtifact.getDependencies()) {
				if(dependency.getGroupID().equals("var") ||dependency.getArtifactID().equals("var")||dependency.getVersion().equals("var"))
					continue;
				int hasNumberOfExclusions =0;
				String depLinkUri = BuildABox.DependencyLink(mavenArtifact.toString() + "_" + dependency.toString());
				String dependencyUri = BuildABox.BuildRelease(dependency.toString());

				triplesWriter.addDeclarationTriple(depLinkUri, RDF.type(), BuildTBox.DependencyLink(), false);

				// create relationship between types
				triplesWriter.addIndividualTriple(depLinkUri, BuildTBox.hasDependencySource(), mainArtifact, false);
				triplesWriter.addIndividualTriple(depLinkUri, BuildTBox.hasDependencyTarget(), dependencyUri, false);

				// create data properties
				if (dependency.getScope() != null) {
					triplesWriter.addIndividualTriple(depLinkUri, MavenTBox.hasDependencyScope(), dependency.getScope(),
							true);
				}
				if (dependency.getType() != null) {
					triplesWriter.addIndividualTriple(depLinkUri, MavenTBox.hasDependencyType(), dependency.getType(),
							true);
				}
				triplesWriter.addIndividualTriple(depLinkUri, MavenTBox.isOptionalDependency(),
						String.valueOf(dependency.isOptional()), true);
				if(dependency.isOptional()){
					triplesWriter.addIndividualTriple(mainArtifact, BuildTBox.hasOptionalBuildDependencyOn(), dependencyUri, false);
				}else{
					triplesWriter.addIndividualTriple(mainArtifact, BuildTBox.hasNonOptionalBuildDependencyOn(), dependencyUri, false);
				}
				if (dependency.getExclusions() != null) {
					for (String exclusion : dependency.getExclusions()) {
						hasNumberOfExclusions++;
						String exclusionURI = BuildABox.BuildProject(exclusion).toString();
						triplesWriter.addIndividualTriple(depLinkUri, BuildTBox.excludesProject(), exclusionURI, false);
					}
				}
				triplesWriter.addIndividualTriple(depLinkUri, BuildTBox.hasNumberOfExclusions(), String.valueOf(hasNumberOfExclusions), true);

			}
		}
		if (mavenArtifact.getLicenses() != null) {
			for (MavenLicense license : mavenArtifact.getLicenses()) {
				// create data properties
				triplesWriter.addIndividualTriple(mainArtifact, MavenTBox.hasLicenseName(), license.getName(), true);
				triplesWriter.addIndividualTriple(mainArtifact, MavenTBox.hasLicenseUrl(), license.getUrl(), true);
			}
		}

		mavenArtifact = null;
	}

}

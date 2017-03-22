package ca.concordia.cs.aseg.segps.ontologies.publisher.domain_spanning;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import ca.concordia.cs.aseg.segps.ontologies.publisher.util.NtriplesWriter;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_spanning.abox.MeasurementsABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_spanning.tbox.MeasurementsTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox.BuildABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox.SecurityDBsABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox.RDF;

public class ProjectSimilarityPublisher {

	public void publish(String outputFileLocation, String directory) throws Exception {
		publish(new File(outputFileLocation), new File(directory));
	}

	public void publish(File outputFileLocation, File directory) throws Exception {
		for (int i = 0; i < 4; i++) {
			System.out.println("\nCreating triples for filegroup " + i);
			publish(outputFileLocation, directory, i);
		}
	}

	private void publish(File outputFileLocation, File directory, int filegroup) throws Exception {

		/*
		 * For a filegroup i.e. files with a common index within their filename
		 * (filename.index.dat), Create hashmaps for <id,source> & <id,fullname>
		 * Lookup sameProject info from hashmaps and create triples
		 */
		NtriplesWriter triplesWriter = new NtriplesWriter(outputFileLocation.getAbsolutePath(), 100000, 500000);
		File projectFullNames = null, projectSources = null, sameProjects = null;
		HashMap<Integer, String> projectFullNamesMap, projectSourcesMap;
		String filter = filegroup + ".txt";
		Collection<File> listF = FileUtils.listFiles(directory, new WildcardFileFilter("*" + filter + "*"),
				TrueFileFilter.TRUE);
		for (File f : listF) {
			// System.out.println(f.getAbsolutePath());
			if (f.getAbsolutePath().contains("projectFullName")) {
				projectFullNames = f;
			}
			if (f.getAbsolutePath().contains("projectSource")) {
				projectSources = f;
			}
			if (f.getAbsolutePath().contains("sameProject")) {
				sameProjects = f;
			}
		}
		projectFullNamesMap = createMap(projectFullNames);
		projectSourcesMap = createMap(projectSources);
		List<SimilarProject> projects = parseSameProjectFile(sameProjects, projectFullNamesMap, projectSourcesMap);
		System.out.println(projects.size());
		createTriples(projects, triplesWriter);
		triplesWriter.flushAndClose();
		System.out.println("Done");
	}

	private HashMap<Integer, String> createMap(File file) {
		HashMap<Integer, String> map = new HashMap<>();
		if (file != null) {
			try {
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					String[] lineParts = line.split("\t");
					map.put(Integer.valueOf(lineParts[0]), lineParts[1]);
				}
				bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return map;
	}

	private List<SimilarProject> parseSameProjectFile(File file, HashMap<Integer, String> names,
			HashMap<Integer, String> sources) {
		List<SimilarProject> similarProjects = null;
		if (file != null && names.size() > 0 && sources.size() > 0) {
			similarProjects = new ArrayList<>();
			try {
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					String[] lineParts = line.split("\t");
					String[] samePair = lineParts[0].replace("SAMEPROJECT(", "").replace(")", "").trim().split(",");
					// System.out.println(samePair[0] + " " + samePair[1] + " "
					// + lineParts[1]);

					String mvnProj = null, nvdProj = null;
					if (sources.get(Integer.valueOf(samePair[0].trim())).equals("mvn")) {
						mvnProj = names.get(Integer.valueOf(samePair[0].trim())).toString();
					} else {
						nvdProj = names.get(Integer.valueOf(samePair[0].trim())).toString();
					}
					if (sources.get(Integer.valueOf(samePair[1].trim())).equals("mvn")) {
						mvnProj = names.get(Integer.valueOf(samePair[1].trim())).toString();
					} else {
						nvdProj = names.get(Integer.valueOf(samePair[1].trim())).toString();
					}
					SimilarProject project = new SimilarProject(mvnProj, nvdProj, Double.valueOf(lineParts[1]));
					similarProjects.add(project);
				}
				bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return similarProjects;
	}

	private void createTriples(List<SimilarProject> similarProjects, NtriplesWriter triplesWriter) throws Exception {
		for (SimilarProject project : similarProjects) {
			// create types
			String similarityURI = MeasurementsABox
					.SimilarityMeasure("B:" + project.getMvnProj() + "_V:" + project.getNvdProj());
			String mvnProjURI = BuildABox.BuildRelease(project.getMvnProj());
			String nvdProjURI = SecurityDBsABox.AffectedRelease(project.getNvdProj());

			triplesWriter.addDeclarationTriple(similarityURI, RDF.type(), MeasurementsTBox.SimilarityMeasure(), false);

			// create relationship between types
			triplesWriter.addIndividualTriple(similarityURI, MeasurementsTBox.measuresThing(), mvnProjURI, false);
			triplesWriter.addIndividualTriple(similarityURI, MeasurementsTBox.measuresThing(), nvdProjURI, false);

			// create data properties
			triplesWriter.addIndividualTriple(similarityURI, MeasurementsTBox.hasMeasureValue(),
					String.valueOf(project.getSimilarityScore()), true);
		}
	}

	public static void main(String[] args) {
		try {
			new ProjectSimilarityPublisher().publish(new File("similarity.nt"),
					new File("E:\\Google Drive\\ASEG Project\\ICSME 2016\\Code\\psl-example\\data\\data\\segps"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class SimilarProject {
	private String mvnProj, nvdProj;
	private double similarityScore;

	public SimilarProject(String mvnProj, String nvdProj, double similarityScore) {
		super();
		this.mvnProj = mvnProj;
		this.nvdProj = nvdProj;
		this.similarityScore = similarityScore;
	}

	public String getMvnProj() {
		return mvnProj;
	}

	public void setMvnProj(String mvnProj) {
		this.mvnProj = mvnProj;
	}

	public String getNvdProj() {
		return nvdProj;
	}

	public void setNvdProj(String nvdProj) {
		this.nvdProj = nvdProj;
	}

	public double getSimilarityScore() {
		return similarityScore;
	}

	public void setSimilarityScore(double similarityScore) {
		this.similarityScore = similarityScore;
	}

}

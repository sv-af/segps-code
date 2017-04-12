package ca.concordia.cs.aseg.segps.ontologies.publisher;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import ca.concordia.cs.aseg.maven.util.Utils;
import ca.concordia.cs.aseg.segps.ontologies.publisher.build.MavenPublisher;
import ca.concordia.cs.aseg.segps.ontologies.publisher.code.JavaByteCodePublisher;
import ca.concordia.cs.aseg.segps.ontologies.publisher.history.CVSArtifact;
import ca.concordia.cs.aseg.segps.ontologies.publisher.history.CVSPublisher;
import ca.concordia.cs.aseg.segps.ontologies.publisher.history.GithubPublisher;
import ca.concordia.cs.aseg.segps.ontologies.publisher.history.SVNPublisher;
import ca.concordia.cs.aseg.segps.ontologies.publisher.security.NVD_XMLEntriesParser;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox.BuildABox;

public class Main {

	public static void main(String[] args) {
		Utils.initProperties();
		// publishSecurity("E:/DEVELOPMENT/NVD/zipped","E:/DEVELOPMENT/NVD/unzipped");
		// publishHistory();
		publishCode();
		// publishCodeHistory();
		// publishBuild(Utils.MAVEN_INDEX_LOCATION + "uniqueArtifacts", Utils.TRIPLES_LOCATION + "build.nt");

	}

	private static void publishBuild(String indexFileLoc, String outputLoc) {
		System.out.println("Publishing Build triples \n\tFrom: " + indexFileLoc + "\n\tTo: " + outputLoc + "...");
		new MavenPublisher().publish(outputLoc, indexFileLoc, 2);
		System.out.println("Done!\n");
	}

	private static void publishCode() {
		System.out.println("Publishing Code triples...");
		String projectURI = BuildABox.BuildRelease("aseg:testCallgraph:1.0");
		new JavaByteCodePublisher().publish(new File("testCallgraph.jar"), projectURI, new ArrayList<String>(),
				"out.nt");
		System.out.println("Done!\n");
	}

	private static void publishHistory() {
		System.out.println("Publishing History triples...");
		CVSPublisher cvsPublisher = null;
		List<CVSArtifact> artifacts = new ArrayList<>();
		String excelLoc = "E:\\Google Drive\\ASEG Project\\Conferences 2017\\ICST 2017 - accepted\\experiment\\NVDPatchLinks.xls";
		String sheet1 = "NVD-SVN", sheet2 = "NVD-GIT";
		try {
			FileInputStream inputStream = new FileInputStream(new File(excelLoc));
			System.out.println("Opening excel workbook...");
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			HSSFSheet svnSheet = workbook.getSheet(sheet1);
			HSSFSheet gitSheet = workbook.getSheet(sheet2);
			Iterator<Row> rowIterator = svnSheet.iterator();
			rowIterator.next();
			CVSArtifact artifact = null;
			cvsPublisher = new SVNPublisher();

			System.out.println("--Creating SVN artifacts...");
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				String url = row.getCell(1).getStringCellValue();
				artifact = cvsPublisher.createArtifact(url);
				artifacts.add(artifact);
			}

			Iterator<Row> rowIterator2 = gitSheet.iterator();
			rowIterator2.next();
			cvsPublisher = new GithubPublisher();
			System.out.println("--Creating Git artifacts...");
			while (rowIterator2.hasNext()) {
				Row row = rowIterator2.next();
				String url = row.getCell(1).getStringCellValue();
				artifact = cvsPublisher.createArtifact(url);
				artifacts.add(artifact);
			}
			workbook.close();
			System.out.println("--Publishing triples from artifact list...");
			cvsPublisher.publishFromArtifactList(artifacts, "history.nt");
			System.out.println("Done!\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void publishSecurity(String downloadedData, String dataCorpusPath) {
		System.out.println("Publishing Security triples...");
		// String dataCorpusPath = "C:/Users/umroot/workspace/data/unzipped";
		// String downloadedData = "C:/Users/umroot/workspace/data/zipped";
		//String dataCorpusPath = "E:/DEVELOPMENT/NVD/unzipped";
		//String downloadedData = "E:/DEVELOPMENT/NVD/zipped";
		/**
		 * Unzipping the nvdcve-*.xml.zip files
		 */
		File zippedFiles = new File(downloadedData);
		File[] nvdXMLZipFeeds = zippedFiles.listFiles();
		for (File file : nvdXMLZipFeeds) {
			System.out.println("file unzip: " + file.getName());
			NVD_XMLEntriesParser.unzip(file.getAbsolutePath(), dataCorpusPath);
		}

		/**
		 * Extracting and parsing NVD xml feeds
		 */
		NVD_XMLEntriesParser.extractData(dataCorpusPath);
		System.out.println("Done!\n");
	}

	private static void publishCodeHistory() {
		System.out.println("Publishing Code-History triples...");
		System.out.println("Done!\n");
	}

}

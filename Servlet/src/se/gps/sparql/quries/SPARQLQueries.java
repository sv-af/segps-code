package se.gps.sparql.quries;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import se.gps.database.connection.*;

import com.hp.hpl.jena.query.ParameterizedSparqlString;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;

import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoQueryExecution;
import virtuoso.jena.driver.VirtuosoQueryExecutionFactory;

public class SPARQLQueries {
	// Connections objects for the Vertuoso server
	 static DBconnections connection = new DBconnections();
	 static VirtGraph    vtServer	= connection.getConnectionToTriplesStore();
	 
	 static final String Path = "/home/sultan/web/apache-tomcat-7.0.59/webapps/segps/data/";
	
	/**
	 * This function received Maven project information (groupId/vendor,
	 * artifactId/product and version) from the user, and run the SPARQL query
	 * to get all the announced security vulnerabilities in NVD data; and then
	 * write to CSV format for visualization. 
	 * @param vendor
	 * @param product
	 * @param version
	 * @throws IOException 
	 */
	public static boolean getSecurtiyVulnerabilities(String vendor, String product, String version) throws IOException {
		/**
		 * To be completed 
		 */
		String FileName = "ProjectSecurityVulnerabilities";
		String vRQ1 = null;
		// Prepare the SPARQL query to filter the string for special HTML characters to prevent
		// command injection attack in the triple store
		ParameterizedSparqlString pss = new ParameterizedSparqlString();
	
		pss.setNsPrefix("owl", "http://www.w3.org/2002/07/owl#");
		pss.setNsPrefix("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
		pss.setNsPrefix("secont", "http://encs.concordia.ca/ontologies/2015/Secont#");
		pss.setNsPrefix("mavon", "http://encs.concordia.ca/ontologies/2015/MavenOntology#");
		
		pss.setCommandText("SELECT  ?Project ?Vulnerability ?Score ?PubDate "
				+ "?AuthenticationImpact ?ConfidentialityImpact ?IntegrityImpact ?AvailabilityImpact ?Summary From <http://ontology-data.com>\n"
				+ "WHERE{\n"
				+ "?p mavon:hasVersion ?Project.\n"
				+ "?Project secont:hasVulnerability ?Vulnerability.\n"
				+ "?Vulnerability secont:score ?Score.\n"
				+ "?Vulnerability secont:publishedDateTime ?PubDate.\n"
				+ "?Vulnerability secont:hasAuthentication ?AuthenticationImpact.\n"
				+ "?Vulnerability secont:hasConfidentialityImpact ?ConfidentialityImpact.\n"
				+ "?Vulnerability secont:hasIntegrityImpact ?IntegrityImpact.\n"
				+ "?Vulnerability secont:hasAvailabilityImpact ?AvailabilityImpact.\n"
				+ "?Vulnerability secont:summary ?Summary.\n"
				+ "?Project mavon:hasArtifactID ?product.\n"
				+ "?Project mavon:hasVersionNumber ?version.\n"
				+ "?Project mavon:hasGroupID ?groupId.\n"
				+ "FILTER(regex(str(?groupId),?vendor,\"i\"))"
				+ "}");
	
		pss.setLiteral("?vendor", vendor);
		pss.setLiteral("?product", product);
		pss.setLiteral("?version", version);
		
		//Used to append the inference rules that is created to reasoning part.
		StringBuffer QueryWithInferencesRules = new StringBuffer();
		QueryWithInferencesRules.append("DEFINE input:inference 'rule-sets'\n");
		QueryWithInferencesRules.append("DEFINE input:same-as \"yes\" \n");
		QueryWithInferencesRules.append(pss.toString());

		
	//	System.out.println(QueryWithInferencesRules.toString());
				
		// Executing the SPARQL query after connecting to the Virtuoso server
		// and establishing the connection the triple store
		VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create(
				QueryWithInferencesRules.toString(), vtServer);
		ResultSet results = vqe.execSelect();
		if (results.hasNext()) {
			PrintStream console = System.out;

			System.out.println("Writing the results into CSV formats...");
			PrintStream out = new PrintStream(new FileOutputStream(Path
					+ FileName + ".csv"));
			System.setOut(out);
			ResultSetFormatter.outputAsCSV(out, results);
			// return the activation to the system.out
			System.setOut(console);

			System.out.println("Done!");
			vRQ1 = "vRQ1";
			csvNormalization(vRQ1, FileName);
			return true;
		} else {
			System.out.println("No Results");
			return false;
		}
	}
	
	/**
	 * This function received Maven project information (groupId/vendor,
	 * artifactId/product and version) from the user and run the SPARQL query to
	 * get vulnerable projects (two level of dependencies) that user's project
	 * depends on.
	 * @param vendor
	 * @param product
	 * @param version
	 * @throws IOException 
	 */
	public static boolean getTransitiveDependencies(String vendor, String product, String version) throws IOException {
		/**
		 * To be completed
		 */
		String FileName = "VulnerabilitiesDependencies";
		String vRQ2 = null;

		// Prepare the SPARQL query to filter the string for special HTML
		// characters to prevent
		// command injection attack in the triple store
		ParameterizedSparqlString pss = new ParameterizedSparqlString();

		pss.setNsPrefix("owl", "http://www.w3.org/2002/07/owl#");
		pss.setNsPrefix("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
		pss.setNsPrefix("secont",
				"http://encs.concordia.ca/ontologies/2015/Secont#");
		pss.setNsPrefix("mavon",
				"http://encs.concordia.ca/ontologies/2015/MavenOntology#");
		pss.setCommandText("select distinct ?project ?super ?vulnerability\n"
				+ " From <http://ontology-data.com> \n"
				+ "where{\n"
				+ "?project mavon:hasGroupID ?vendor.\n"
				+ "?project mavon:hasArtifactID ?product.\n"
				+ "?project mavon:hasVersionNumber ?version.\n"
				+ "?project mavon:dependsOn ?super "
				+ "option(transitive, t_distinct, t_no_cycles, t_max(1)).\n"
				+ "{ select ?super ?vulnerability {\n"
				+ "    ?super secont:hasVulnerability ?vulnerability."
				+ "  }"
				+ "} }\n"
				+ "ORDER BY ASC(?project)");
		
		pss.setLiteral("?vendor", vendor);
		pss.setLiteral("?product", product);
		pss.setLiteral("?version", version);
		
		//Used to append the inference rules that is created to reasoning part.
		StringBuffer QueryWithInferencesRules = new StringBuffer();
		QueryWithInferencesRules.append("DEFINE input:inference 'rule-sets'\n");
		QueryWithInferencesRules.append("DEFINE input:same-as \"yes\" \n");
		QueryWithInferencesRules.append(pss.toString());
		VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create(
				QueryWithInferencesRules.toString(), vtServer);
		ResultSet results = vqe.execSelect();
		if (results.hasNext()) {
			PrintStream console = System.out;

			System.out.println("Writing the results into CSV formats...");
			PrintStream out = new PrintStream(new FileOutputStream(Path
					+ FileName + ".csv"));
			System.setOut(out);
			ResultSetFormatter.outputAsCSV(out, results);
			// return the activation to the system.out
			System.setOut(console);

			System.out.println("Done!");
			vRQ2 = "vRQ2";
			csvNormalization(vRQ2, FileName);
			return true;
		} else {
			System.out.println("No Results");
			return false;
		}
	}
	
	public static void csvNormalization(String vRQ, String FileName) throws IOException{
	
		FileWriter file = new FileWriter(Path + vRQ +".csv");
		
		// Prepare visualization from Project vulnerabilities. 
		if (vRQ.equalsIgnoreCase("vRQ1")) {
			BufferedWriter bw = new BufferedWriter(file);

			// writing the header
			bw.write("Project,Vulnerability,Score,PubDate");
			bw.newLine();

			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(Path
					+ FileName + ".csv"));
			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.contains("Project")) {
					continue;
				}
				String[] array = line.split(",");

				String[] project = array[0].split("#");
				String[] vulnerability = array[1].split("#");
				String score = array[2];
				String[] date = array[3].split("T");
				
				// writing to csv file
				bw.write(project[1] + "," + vulnerability[1] + "," + score
						+ "," + date[0]);
				bw.newLine();
			}

			bw.flush();
			bw.close();
		} else if (vRQ.equalsIgnoreCase("vRQ2")) {
			BufferedWriter bw = new BufferedWriter(file);

			// writing the header
			bw.write("Project,Super,Vulnerability");
			bw.newLine();

			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(Path
					+ FileName + ".csv"));
			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.contains("project")) {
					continue;
				}
				String[] array = line.split(",");

				String[] project = array[0].split("#");
				String[] superNode = array[1].split("#");
				String[] vulnerability = array[2].split("#");

				// writing to csv file
				bw.write(project[1] + "," + superNode[1] + "," + vulnerability[1]);
				bw.newLine();
			}
			bw.flush();
			bw.close();
			System.out.println("Dependencies created !!");
			normalizeDependencyCSVfile(vRQ +".csv");
		}
	}
	@SuppressWarnings("unused")
	private static void normalizeDependencyCSVfile(String FileName) throws IOException {

	    String line = null;
	    BufferedReader stream = null;

	    List<String[]> project_super = new ArrayList<String[]>();
	    List<String[]> super_vulnerability = new ArrayList<String[]>();

		try {
			stream = new BufferedReader(
					new FileReader(Path + FileName));
			while ((line = stream.readLine()) != null) {
				String[] splitted = line.split(",");
				if (splitted[0].equalsIgnoreCase("project")) {
					continue;
				}

				project_super.add(new String[] { splitted[0], splitted[1] });
				super_vulnerability
						.add(new String[] { splitted[1], splitted[2] });

			}
		} finally {
			if (stream != null)
				stream.close();
		}
	    
		removingDuplicatesAndMerge(project_super,super_vulnerability);
	    
	    	    
	}
	
	// removing duplicates from the list
	public static void removingDuplicatesAndMerge(List<String[]> list1, List<String[]> list2) throws IOException{
		
		String FileName = "vRQ2_.csv";
		
		File file= new File (Path + FileName);
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		// writing the header
		bw.write("Project,Super");
		bw.newLine();
		
		String[] array={};
	    
	    //Removing the duplicates by adding to set "s"
	    Set<String[]> s1 = new TreeSet<String[]>(new Comparator<String[]>() {
	         @Override
	         public int compare(String[] o1, String[] o2) {
	                return o1[1].compareTo(o2[1]);
	        }
	   });
	    
	    // remove duplicates from list1 and add to the output file
	    s1.addAll(list1);
	    List<Object> res1 = Arrays.asList(s1.toArray());
	    
	    for (Object object : res1) {
	    	array = (String[])object;
	         System.out.println(array[0]+", "+array[1]);
	         bw.write(array[0] +","+array[1]);
	         bw.newLine();
	    }
	    
	    s1.clear();
	    // remove duplicates from list1 and add to the output file
	    s1.addAll(list2);
	    List<Object> res2 = Arrays.asList(s1.toArray());
	    for (Object object : res2) {
	    	array = (String[])object;
	         System.out.println(array[0]+", "+array[1]);
	         bw.write(array[0] +","+array[1]);
	         bw.newLine();
	    }
	    
	    bw.flush();
		bw.close();
	}
	
}

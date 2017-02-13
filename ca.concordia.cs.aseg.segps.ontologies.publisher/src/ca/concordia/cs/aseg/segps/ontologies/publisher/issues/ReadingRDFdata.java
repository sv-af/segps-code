package ca.concordia.cs.aseg.segps.ontologies.publisher.issues;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.sql.ResultSet;

import javax.management.Query;


public class ReadingRDFdata {

	public static void main(String[] args) throws FileNotFoundException {
		
	/*	Model model = FileManager.get().loadModel("raw_data/tika.rdf");
		
		StmtIterator iter;
		Statement stmt;

		Property predicate;
		Resource subject;
		RDFNode obj;
		
		iter = model.listStatements();
		while (iter.hasNext()) {
			stmt = iter.next();
			subject = stmt.getSubject();
			System.out.println("Subject = " + subject.getURI());
			predicate = stmt.getPredicate();
			System.out.println("Predicate = " +predicate.getLocalName());
			obj = stmt.getObject();
			System.out.println("Object = " + obj.toString());
		}*/
		
		File inputFolder = new File("raw_data/");
		String outputFolder = "output/";
		
		String query = "extract rdf data"; 
		try{
			PrintStream console = System.out;
			for (final File fileEntry : inputFolder.listFiles()) {
				PrintStream out = new PrintStream(new FileOutputStream(outputFolder+
						fileEntry.getName() + ".csv"));
				OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
				System.out.println("Parsing "+fileEntry.toString() );
				System.setOut(out);
				File file = new File(fileEntry.toString());
				FileReader reader = new FileReader(file);
				model.read(reader, null);

				Query query = QueryFactory.create(bugQueryt);
				QueryExecution qe = QueryExecutionFactory.create(query, model);

				ResultSet resutls = qe.execSelect();
				ResultSetFormatter.outputAsCSV(out, resutls);
				// return the activation to the system.out
				System.setOut(console);
				System.out.println("Done !!");
				
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}

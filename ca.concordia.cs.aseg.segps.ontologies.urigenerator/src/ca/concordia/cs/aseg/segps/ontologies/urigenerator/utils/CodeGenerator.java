package ca.concordia.cs.aseg.segps.ontologies.urigenerator.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
	public static void main(String[] args) {
		generateCode("theSEONTBoxNamespace", "measurement");
	}

	static void generateCode(String namespaceRegistry, String ontologyRegistry) {
		try {
			List<String> lines = new ArrayList<>();
			FileInputStream fis = new FileInputStream(new File("C:\\Users\\e_eghan\\Desktop\\props.txt"));

			// Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));

			String line = null;
			while ((line = br.readLine()) != null) {
				line = line.replace("\"", " ");
				lines.add(line.trim());
			}

			br.close();

			for (String str : lines) {
				String s = "public static String " + str
						+ "() {\nString uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry."
						+ namespaceRegistry + ", OntologyRegistry." + ontologyRegistry + ") +\"" + str
						+ "\";\n		return uri;	}";
				System.out.println(s);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

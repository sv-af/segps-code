import java.io.FileNotFoundException;
import java.io.IOException;

import se.gps.database.connection.DBconnections;
import se.gps.servlets.PopulatingVulnerabilitiesServlet;
import se.gps.sparql.quries.SPARQLQueries;
public class Main {

	public static void main(String[] args) throws IOException {
		SPARQLQueries sprl = new SPARQLQueries();
		try {
			boolean data = sprl.getTransitiveDependencies("org.apache.geronimo.assemblies", "geronimo-jetty6-javaee5", "2.1.1");
			if(data){
				System.out.println("It is modified and good");
			}else{
				System.out.println("It is not good");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

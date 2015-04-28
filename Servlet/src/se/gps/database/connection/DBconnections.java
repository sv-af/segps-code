package se.gps.database.connection;

import virtuoso.jena.driver.VirtGraph;

public class DBconnections {
	/* Graph IRIs*/
	static String graphDataIRI = "http://ontology-data.com";
	static String graphSchemaIRI = "http://ontology-schema.com";
	static String graphRulesIRI = "rule-sets";
	/* Server Connection url, pass, and usename*/
	public static String url = "jdbc:virtuoso://localhost:1111";
	public static String password = "dba";
	public static String username = "dba";
	
	/**
	 * set is an object of Virtuoso Graph 
	 * @return
	 */
	public VirtGraph getConnectionToTriplesStore() {
		VirtGraph set = new VirtGraph(graphDataIRI,
				"jdbc:virtuoso://localhost:1111", "dba", "dba");
		return set;
	}

}

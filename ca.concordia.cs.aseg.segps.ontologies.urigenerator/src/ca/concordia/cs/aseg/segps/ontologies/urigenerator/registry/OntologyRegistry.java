/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */
package ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry;

public class OntologyRegistry {

	// General ontologies registry
	public static String main="general/2015/02/main.owl#";

	// Build System ontologies registry
	public static String build="domain-specific/2015/02/build.owl#";
	public static String ivy="system-specific/2015/02/ivy.owl#";
	public static String ant="system-specific/2015/02/ant.owl#";
	public static String maven="system-specific/2015/02/maven.owl#";
	
	// Vulnerability ontologies registry 
	public static String securityDBs = "domain-specific/2015/02/securityDBs.owl#";
	public static String securityDBs_nvd = "domain-specific/2015/02/securityDBs-nvd.owl#";
	public static String securityDBs_osvdb ="domain-specific/2015/02/securityDBs-osvdb.owl#";
}

/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */
package ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry;

public class OntologyRegistry {

	// SE-ON ontologies registry
	public static String main="general/2012/02/main.owl#";
	public static String measurement="general/2012/02/measurement.owl#";
	public static String code="domain-specific/2012/02/code.owl#";
	public static String java="system-specific/2012/02/java.owl#";
	public static String issues="system-specific/2012/02/issues.owl#";
	public static String issues_jira="system-specific/2012/02/issues-jira.owl#";
	public static String history="domain-specific/2012/02/history.owl#";

	// Build System ontologies registry
	public static String build="domain-specific/2015/02/build.owl#";
	public static String ivy="system-specific/2015/02/ivy.owl#";
	public static String ant="system-specific/2015/02/ant.owl#";
	public static String maven="system-specific/2015/02/maven.owl#";
	
	// Vulnerability ontologies registry 
	public static String securityDBs = "domain-specific/2015/02/securityDBs.owl#";
	public static String securityDBs_nvd = "system-specific/2015/02/securityDBs-nvd.owl#";
	public static String securityDBs_osvdb ="system-specific/2015/02/securityDBs-osvdb.owl#";
}

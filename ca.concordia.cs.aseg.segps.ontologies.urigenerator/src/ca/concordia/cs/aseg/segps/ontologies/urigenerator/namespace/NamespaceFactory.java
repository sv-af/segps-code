/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */
package ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace;

public class NamespaceFactory {
	
	 
	public static String createAboxNamespace(String nameSpacePrefix,String aboxName)
	{
		String ns=nameSpacePrefix+"/"+aboxName;
		return(ns);
	}

	public static String createTboxNamespace(String nameSpacePrefix,String tboxName)
	{
		String ns=nameSpacePrefix+"/"+tboxName;
		return(ns);
	}
}

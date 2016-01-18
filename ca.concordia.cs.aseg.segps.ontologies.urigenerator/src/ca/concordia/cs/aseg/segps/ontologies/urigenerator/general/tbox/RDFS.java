/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://secold.org
 * Please see the LICENSE file for details.
 */
package ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox;

public class RDFS {

////////////////////PROPERTIES//////////////////////////////////
	public static String label()
	{
		String uri="http://www.w3.org/2000/01/rdf-schema#label";
		return uri;
	}
	
	public static String comment()
	{
		String uri="http://www.w3.org/2000/01/rdf-schema#comment";
		return uri;
	}
	
	public static String subPropertyOf()
	{
		String uri="http://www.w3.org/2000/01/rdf-schema#subPropertyOf";
		return uri;
	}
	public static String subClassOf()
	{
		String uri="http://www.w3.org/2000/01/rdf-schema#subClassOf";
		return uri;
	}
}

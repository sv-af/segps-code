package ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox;

public class FOAF {
	///////////////////////////////////CONCEPTS/////////////////////
	public static String Person()
	{
		String uri="http://xmlns.com/foaf/spec/#term_person";
		return uri;
	}

	////////////////////PROPERTIES//////////////////////////////////
	public static String name()
	{
		String uri="http://xmlns.com/foaf/spec/#term_name";
		return uri;
	}
	
	public static String knows()
	{
		String uri="http://xmlns.com/foaf/spec/#term_knows";
		return uri;
	}
}

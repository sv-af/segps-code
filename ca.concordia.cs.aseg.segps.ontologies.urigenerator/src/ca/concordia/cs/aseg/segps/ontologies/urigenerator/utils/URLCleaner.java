/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */
package ca.concordia.cs.aseg.segps.ontologies.urigenerator.utils;

public class URLCleaner {
//This class removes all invalid chars from a given URL and make it ready to use as a part of another URL
	public static String clean_simple_safe(String URL)
	{//.replaceAll("[^a-zA-Z0-9]", "");
		
		
	/*	String cln=URL.replace(":", "_");
		cln=cln.replace("/", "_");*/
		String cln=URL.replaceAll("[^a-zA-Z0-9]", "_");
		return(cln);
		
	}
	
	public static String clean(String URL)  
	{
		try
		{
		//alternative ISO-8859-1
			
		//return(java.net.URLEncoder.encode(URL, "UTF-8"));
			return(clean_simple_safe(URL));
		}catch(Exception ex)
		{
			System.out.print("Error at URLCleaner.clean(): "+URL+ex.getMessage());
			return(clean_simple_safe(URL));
		}
	}
	
	
	
}

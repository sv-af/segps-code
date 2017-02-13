/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */
package ca.concordia.cs.aseg.segps.ontologies.urigenerator.utils;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox.BuildABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.abox.MainABox;

public class URLCleaner {
	// This class removes all invalid chars from a given URL and make it ready
	// to use as a part of another URL
	public static String clean_simple_safe(String URL) {
		// IRI REF = '<' ([^<>"{}|^`\]-[#x00-#x20])* '>'
		URL=URL.trim();
		String cln = URL.replace("^", "_").replace("<", "_").replace(">", "_").replace("\"", "_").replace("{", "_")
				.replace("}", "_").replace("|", "_").replace("\'", "_").replace("`", "_").replace("\\", "_")
				.replace(" ", "_").replace("$", ".");

		return (cln.trim());
	}

	public static String clean(String URL) {
		try {
			// alternative ISO-8859-1

			// return(java.net.URLEncoder.encode(URL, "UTF-8"));
			return (clean_simple_safe(URL));
		} catch (Exception ex) {
			System.out.print("Error at URLCleaner.clean(): " + URL + ex.getMessage());
			return URL;
		}
	}

	public static void main(String[] args) {
		System.out.println(clean("The Apache Software License, Version 2.0"));
		System.out.println(MainABox.License("The Apache Software License, Version 2.0"));
		System.out.println(BuildABox.BuildRelease("The Apache Software License, Version 2.0"));
	}
}

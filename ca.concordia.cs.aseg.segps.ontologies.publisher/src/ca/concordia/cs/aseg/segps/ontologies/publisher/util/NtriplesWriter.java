/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */
package ca.concordia.cs.aseg.segps.ontologies.publisher.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class NtriplesWriter {

	HashSet<String> declaration_triples;
	HashSet<String> individual_triples;
	String outputFileAddress = "";
	boolean bClosed = false;
	int maxNumberOfTriples,maxNumberOfIndividualTriples;

	public NtriplesWriter(String OutputFileAddress, int expectedNumberOfIndividualTriple, int expectedNumberOfDeclarationTriple) {
		outputFileAddress = OutputFileAddress;
		maxNumberOfTriples = expectedNumberOfDeclarationTriple;
		maxNumberOfIndividualTriples = expectedNumberOfIndividualTriple;
		declaration_triples = new HashSet<String>();
		individual_triples = new HashSet<String>();
	}

	public void addDeclarationTriple(String subject, String predicate,
			String object, boolean bLiteralObject) throws Exception {
		if (!bClosed) {
			if (bLiteralObject) {
				if (object != null) {
					if (object.length() > 0) {
						declaration_triples.add("<" + subject + "> <"
								+ predicate + "> " + escapeLiteral(object)
								+ " .");
					}
				}
			} else {
				declaration_triples.add("<" + subject + "> <" + predicate
						+ "> <" + object + "> .");
			}

			if (declaration_triples.size() == maxNumberOfTriples) {
				flushAndContinue(declaration_triples);
			}
		} else {
			throw (new Exception(
					"You can not add triple anymore, since you have flushed and closed already"));
		}
	}

	public void addIndividualTriple(String subject, String predicate,
			String object, boolean bLiteralObject) throws Exception {
		if (!bClosed) {
			if (bLiteralObject) {
				if (object != null) {
					if (object.length() > 0) {
						individual_triples.add("<" + subject + "> <"
								+ predicate + "> " + escapeLiteral(object)
								+ " .");
					}
				}
			} else {
				individual_triples.add("<" + subject + "> <" + predicate
						+ "> <" + object + "> .");
			}

			if (individual_triples.size() == maxNumberOfIndividualTriples) {
				flushAndContinue(individual_triples);
			}
		} else {
			throw (new Exception(
					"You can not add triple anymore, since you have flushed and closed already"));
		}
	}

	public String createTriple(String subject, String predicate, String object,
			boolean bLiteralObject) {
		String triple = null;
		try {
			if (!bClosed) {
				if (bLiteralObject) {
					if (object != null) {
						if (object.length() > 0) {
							triple = "<" + subject + "> <" + predicate + "> "
									+ escapeLiteral(object) + " .";
						}
					}
				} else {
					triple = "<" + subject + "> <" + predicate + "> <" + object
							+ "> .";
				}

			} else {
				throw (new Exception(
						"You can not add triple anymore, since you have flushed and closed already"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return triple;
	}


	public void flushAndContinue(HashSet<String> triples) throws IOException {

		BufferedWriter bufferedWriter = null;
		bufferedWriter = new BufferedWriter(new FileWriter(outputFileAddress,
				true));

		for (String line : triples) {
			// System.out.println(line);
			bufferedWriter.write(line);
			bufferedWriter.newLine();
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		triples.clear();
		bClosed = false;
	}

	public void flushAndClose() throws IOException {

		BufferedWriter bufferedWriter = null;
		bufferedWriter = new BufferedWriter(new FileWriter(outputFileAddress,
				true));
		for (String line : individual_triples) {
			// System.out.println(line);
			bufferedWriter.write(line);
			bufferedWriter.newLine();
		}
		for (String line : declaration_triples) {
			// System.out.println(line);
			bufferedWriter.write(line);
			bufferedWriter.newLine();
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		bClosed = true;
	}

	// com.hp.hpl.jena.n3.N3JenaWriterCommon
	String escapeLiteral(String input) {
		boolean allowTripleQuotedStrings = false;

		String s = input;

		// Format the text - with escaping.
		StringBuffer sbuff = new StringBuffer();
		boolean singleQuoteLiteral = true;

		String quoteMarks = "\"";

		// Things that force the use of """ strings
		if (allowTripleQuotedStrings
				&& (s.indexOf("\n") != -1 || s.indexOf("\r") != -1 || s
						.indexOf("\f") != -1)) {
			quoteMarks = "\"\"\"";
			singleQuoteLiteral = false;
		}

		sbuff.append(quoteMarks);
		string(sbuff, s, singleQuoteLiteral);
		sbuff.append(quoteMarks);

		/*
		 * // Format the language tag if ( lang != null && lang.length()>0) {
		 * sbuff.append("@") ; sbuff.append(lang) ; }
		 * 
		 * // Format the datatype if ( datatype != null ) { sbuff.append("^^") ;
		 * sbuff.append(formatURI(datatype)) ; }
		 */
		return sbuff.toString();

	}

	private static void string(StringBuffer sbuff, String s,
			boolean singleQuoteLiteral) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// Escape escapes and quotes
			if (c == '\\' || c == '"') {
				sbuff.append('\\');
				sbuff.append(c);
				continue;
			}

			// iman uncommented this if block
			// Characters to literally output.
			// This would generate 7-bit safe files
			if (c >= 32 && c < 127) {
				sbuff.append(c);
				continue;
			}

			// Whitespace
			if (singleQuoteLiteral && (c == '\n' || c == '\r' || c == '\f')) {
				if (c == '\n')
					sbuff.append("\\n");
				if (c == '\t')
					sbuff.append("\\t");
				if (c == '\r')
					sbuff.append("\\r");
				if (c == '\f')
					sbuff.append("\\f");
				continue;
			}

			// iman commented this line
			// Output as is (subject to UTF-8 encoding on output that is)
			// sbuff.append(c) ;

			// iman uncommented this block

			// // Unicode escapes
			// // c < 32, c >= 127, not whitespace or other specials
			String hexstr = Integer.toHexString(c).toUpperCase();
			int pad = 4 - hexstr.length();
			sbuff.append("\\u");
			for (; pad > 0; pad--)
				sbuff.append("0");
			sbuff.append(hexstr);
		}
	}

}

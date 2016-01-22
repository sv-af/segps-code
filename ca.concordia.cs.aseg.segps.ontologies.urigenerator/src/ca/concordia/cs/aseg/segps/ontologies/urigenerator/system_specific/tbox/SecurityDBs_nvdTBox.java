/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */
package ca.concordia.cs.aseg.segps.ontologies.urigenerator.system_specific.tbox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;

public class SecurityDBs_nvdTBox {

	/*
	 * Classes
	 */
	public static String VendorAdvisoryReference() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "VendorAdvisoryReference";
		return uri;
	}
	
	public static String UnknownReference() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "UnknownReference";
		return uri;
	}
	
	public static String PatchReference() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "PatchReference";
		return uri;
	}

	/*
	 * Individuals
	 */
	public static String High() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "High";
		return uri;
	}
	public static String Low() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "Low";
		return uri;
	}
	public static String Medium() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "Medium";
		return uri;
	}
	public static String Unknown() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "Unknown";
		return uri;
	}

	public static String Patched() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "Patched";
		return uri;
	}

	public static String Detected() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "Detected";
		return uri;
	}

	public static String Rejected() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "Rejected";
		return uri;
	}

	/*
	 * Object Properties
	 */

	
	/*
	 * Data Properties 
	 */

}

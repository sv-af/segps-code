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

	public static String AccessComplexity() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "AccessComplexity";
		return uri;
	}

	public static String AccessVector() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "AccessVector";
		return uri;
	}

	public static String Authentication() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "Authentication";
		return uri;
	}

	public static String AvailabilityImpact() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "AvailabilityImpact";
		return uri;
	}

	public static String ConfidentialityImpact() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "ConfidentialityImpact";
		return uri;
	}

	public static String IntegrityImpact() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "IntegrityImpact";
		return uri;
	}

	public static String AvailabilityRequirement() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "AvailabilityRequirement";
		return uri;
	}

	public static String CollateralDamagePotential() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "CollateralDamagePotential";
		return uri;
	}

	public static String TargetDistribution() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "TargetDistribution";
		return uri;
	}

	public static String ConfidentialityRequirement() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "ConfidentialityRequirement";
		return uri;
	}

	public static String IntegrityRequirement() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "IntegrityRequirement";
		return uri;
	}

	public static String Exploitability() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "Exploitability";
		return uri;
	}

	public static String RemediationLevel() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "RemediationLevel";
		return uri;
	}

	public static String ReportConfidence() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "ReportConfidence";
		return uri;
	}
	
	/*
	 * Object Properties
	 */

	
	/*
	 * Data Properties *** may need update
	 */
	public static String hasAccessComplexity() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "hasAccessComplexity";
		return uri;
	}

	public static String hasAccessVector() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "hasAccessVector";
		return uri;
	}

	public static String hasAuthentication() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "hasAuthentication";
		return uri;
	}

	public static String hasAvailabilityImpact() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "hasAvailabilityImpact";
		return uri;
	}

	public static String hasConfidentialityImpact() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "hasConfidentialityImpact";
		return uri;
	}

	public static String hasIntegrityImpact() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "hasIntegrityImpact";
		return uri;
	}

	public static String hasAvailabilityRequirement() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "hasAvailabilityRequirement";
		return uri;
	}

	public static String hasCollateralDamagePotential() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "hasCollateralDamagePotential";
		return uri;
	}

	public static String hasTargetDistribution() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "hasTargetDistribution";
		return uri;
	}

	public static String hasConfidentialityRequirement() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "hasConfidentialityRequirement";
		return uri;
	}

	public static String hasIntegrityRequirement() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "hasIntegrityRequirement";
		return uri;
	}

	public static String hasExploitability() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "hasExploitability";
		return uri;
	}

	public static String hasRemediationLevel() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "hasRemediationLevel";
		return uri;
	}

	public static String hasReportConfidence() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs_nvd)
				+ "hasReportConfidence";
		return uri;
	}
}

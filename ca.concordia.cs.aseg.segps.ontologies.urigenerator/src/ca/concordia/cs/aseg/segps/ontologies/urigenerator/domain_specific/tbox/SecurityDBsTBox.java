/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */

package ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.tbox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;

public class SecurityDBsTBox {

	// Classes
	public static String Vulnerability() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "Vulnerability";
		return uri;
	}

	public static String VulnerabilitySeverity() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "VulnerabilitySeverity";
		return uri;
	}
	
	public static String Weakness() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "Weakness";
		return uri;
	}
	
	public static String SecurityEngineer() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "SecurityEngineer";
		return uri;
	}
	
	public static String Attacker() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "Attacker";
		return uri;
	}

	public static String Author() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "Author";
		return uri;
	}

	public static String Score() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "Score";
		return uri;
	}
	
	public static String TemporalScoreMetrics() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "TemporalScoreMetrics";
		return uri;
	}
	
	public static String EnviromentalScoreMetrics() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "EnviromentalScoreMetrics";
		return uri;
	}
	
	public static String BaseScoreMertrics() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "BaseScoreMertrics";
		return uri;
	}
	
	public static String AffectedRelease() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "AffectedRelease";
		return uri;
	}
	
	public static String AffectedProduct() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "AffectedProduct";
		return uri;
	}
	
	public static String OperatingSystem() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "OperatingSystem";
		return uri;
	}
	
	public static String Application() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "Application";
		return uri;
	}
	
	public static String Status() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "Status";
		return uri;
	}
	
//	public static String LifeCycle() {
//		String uri = NamespaceFactory.createTboxNamespace(
//				NamespaceRegistry.theTboxNameSpace,
//				OntologyRegistry.securityDBs)
//				+ "LifeCycle";
//		return uri;
//	}
	
	public static String Impacts() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "Impacts";
		return uri;
	}
	
	public static String Countermeasures() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "Countermeasures";
		return uri;
	}
	
	public static String Comments() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "Comments";
		return uri;
	}
	
	public static String Summary() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "Summary";
		return uri;
	}
	
	public static String Action() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "Action";
		return uri;
	}
	
	public static String Reference() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "Reference";
		return uri;
	}
	
	// Object Properties
	public static String hasVulnerability() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasVulnereability";
		return uri;
	}
	public static String hasReferenceURI() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasReferenceURI";
		return uri;
	}
	
	public static String hasSeverity() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasSeverity";
		return uri;
	}
	
	public static String hasSeverityScore() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasSeverityScore";
		return uri;
	}
	

	public static String hasAffect() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasAffect";
		return uri;
	}
	
	public static String affectProduct() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "affectProduct";
		return uri;
	}
	
	public static String affectRelease() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "affectRelease";
		return uri;
	}
	
	public static String hasStatus() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasStatus";
		return uri;
	}
	
	public static String hasWeakness() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasWeakness";
		return uri;
	}
	
	public static String isAchieving() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "isAchieving";
		return uri;
	}
	
	public static String isMedicatedBy() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "isMedicatedBy";
		return uri;
	}
	
	public static String isExploting() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "isExploting";
		return uri;
	}
	
	public static String isLocatedIn() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "isLocatedIn";
		return uri;
	}
	
	public static String isLuncedBy() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "isLuncedBy";
		return uri;
	}
	
	public static String hasSummary() { // you can use hasDescription from main.owl
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasSummary";
		return uri;
	}
	// Data Properties
	public static String hasSource() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasSource";
		return uri;
	}
	
	public static String hasURL() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasURL";
		return uri;
	}
		
	public static String hasAffectedReleaseName() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasAffectedReleaseName";
		return uri;
	}
	
	public static String hasAffectedReleaseVersion() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasAffectedReleaseVersion";
		return uri;
	}
	
	public static String hasPublishedDate() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasPublishedDate";
		return uri;
	}
	
	public static String hasModifiedDate() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasModifiedDate";
		return uri;
	}
	
	public static String hasVulnerabilityId() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasVulnerabilityId";
		return uri;
	}
	
	public static String hasWeaknessId() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasWeaknessId";
		return uri;
	}
	
	public static String hasBaseScore() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasBaseScore";
		return uri;
	}
	
	public static String hasAccessComplexity() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasAccessComplexity";
		return uri;
	}

	public static String hasAccessVector() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasAccessVector";
		return uri;
	}

	public static String hasAuthentication() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasAuthentication";
		return uri;
	}

	public static String hasAvailabilityImpact() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasAvailabilityImpact";
		return uri;
	}

	public static String hasConfidentialityImpact() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasConfidentialityImpact";
		return uri;
	}

	public static String hasIntegrityImpact() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasIntegrityImpact";
		return uri;
	}

	public static String hasAvailabilityRequirement() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasAvailabilityRequirement";
		return uri;
	}

	public static String hasCollateralDamagePotential() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasCollateralDamagePotential";
		return uri;
	}

	public static String hasTargetDistribution() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasTargetDistribution";
		return uri;
	}

	public static String hasConfidentialityRequirement() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasConfidentialityRequirement";
		return uri;
	}

	public static String hasIntegrityRequirement() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasIntegrityRequirement";
		return uri;
	}

	public static String hasExploitability() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasExploitability";
		return uri;
	}

	public static String hasRemediationLevel() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasRemediationLevel";
		return uri;
	}

	public static String hasReportConfidence() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasReportConfidence";
		return uri;
	}
}

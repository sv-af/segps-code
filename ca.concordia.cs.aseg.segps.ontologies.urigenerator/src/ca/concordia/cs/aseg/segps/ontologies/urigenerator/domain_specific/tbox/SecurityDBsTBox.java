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
	
	public static String LifeCycle() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "LifeCycle";
		return uri;
	}
	
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
	public static String hasReference() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasReference";
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
	
	public static String hasBaseScore() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasBaseScore";
		return uri;
	}
	public static String hasEnvironmentalScore() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasEnvironmentalScore";
		return uri;
	}
	public static String hasTemporalScore() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasTemporalScore";
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
	
	// Data Properties
	public static String hasSource() {
		String uri = NamespaceFactory.createTboxNamespace(
				NamespaceRegistry.theTboxNameSpace,
				OntologyRegistry.securityDBs)
				+ "hasSource";
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
}

package ca.concordia.cs.aseg.segps.ontologies.publisher.nvd_puplisher;

import java.io.IOException;
import java.util.ArrayList;

import ca.concordia.cs.aseg.segps.ontologies.publisher.ntriples.NtriplesWriter;
import ca.concordia.cs.aseg.segps.ontologies.publisher.security_raw_data_parser.Entry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox.SecurityDBsABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.tbox.SecurityDBsTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.abox.MainABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox.MainTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox.RDF;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.system_specific.tbox.SecurityDBs_nvdTBox;

public class InstancesLinker {
	
	private Entry currentEntry = new Entry();
	private NtriplesWriter writer;
	
	
	private void generalLayer(Entry currentEntry){
	}
	
	private void domainSpanningLayer(Entry currentEntry){
	}
	
	private void domainSpecificLayer(Entry currentEntry){
		
		try {
			// ABox instances
			String cve = SecurityDBsABox.VulnerabilityURI(currentEntry.getcveID());
			
			// TBox instances 
			writer.addDeclarationTriple(cve, RDF.type(), SecurityDBsTBox.Vulnerability(), false);
			writer.addIndividualTriple(cve, SecurityDBsTBox.hasVulnerabilityId(), currentEntry.getcveID(), true);
			
			/**Add publication(disclosure) date and modification date**/
			writer.addIndividualTriple(cve, SecurityDBsTBox.hasPublishedDate(), currentEntry.getPublishedDatetime(), true);
			writer.addIndividualTriple(cve, SecurityDBsTBox.hasModifiedDate(), currentEntry.getLastModifiedDatetime(), true);
			
			//Check if the vulnerability has weakness type. 
			if(currentEntry.getcweID() != null){
				// ABox instances
				String cwe = SecurityDBsABox.WeaknessURI(currentEntry.getcweID());
				// TBox instances
				writer.addDeclarationTriple(cwe, RDF.type(), SecurityDBsTBox.Weakness(), false);
				writer.addIndividualTriple(cve, SecurityDBsTBox.hasWeakness(), cwe, false);
				writer.addIndividualTriple(cve, SecurityDBsTBox.hasWeaknessId(), currentEntry.getcweID(), true);
			}
			
			// Check if the vulnerability has external sources *e.g. references* 
			if(currentEntry.getReferencesList() != null){
				ArrayList<String> rfl = currentEntry.getReferencesList();
				// rfl contain [Reference type (e.g. Unknown, Patch, ...etc), Reference Source, Reference Location (URL), ...]
				for(int i=0; i<rfl.size(); ){
					// ABox instances
					String ReferenceURI = rfl.get(i+2);
					// TBox instances
					writer.addDeclarationTriple(ReferenceURI, RDF.type(), SecurityDBsTBox.Reference(), false);
					writer.addIndividualTriple(cve, SecurityDBsTBox.hasReferenceURI(), ReferenceURI, false);
					i+=3;
				}
			}
			
			// Mapping the vulnerable products facts into the ontology concepts and properties. 
			ArrayList<String> affectedProducts = currentEntry.getAffectedProductList();
			for(int i=0; i<affectedProducts.size(); i++){
				// ABox instances
				
				String temp = affectedProducts.get(i).replaceAll("\\s+","");// removes all whitespace and non visible characters such as tab, \n . 
				String[] split = temp.split(":"); // e.g.  cpe:/a:vendor_name:product_name:version.	
				String affectedRelease = SecurityDBsABox.AffectedRelease(split[2] + ":" + split[3] + ":" + split[4]); // e.g. vendor_name:product_name:version
				String organizationName = MainABox.Organization(split[2]);
				String procutName = MainABox.Product(split[2]+":"+split[3]);
				String versionID = split[4];
			
				// TBox instances
				// Classify Affected products into OS or APP
				if (split[1].equals("/o")) {
					writer.addDeclarationTriple(procutName, RDF.type(), SecurityDBsTBox.OperatingSystem(), false);
					writer.addIndividualTriple(procutName, MainTBox.belongsToOrgaization(), organizationName, false); 
				}else if(split[1].equals("/a")){
					writer.addDeclarationTriple(procutName, RDF.type(), SecurityDBsTBox.Application(), false);
					writer.addIndividualTriple(procutName, MainTBox.belongsToOrgaization(), organizationName, false); 
				}
				
				writer.addDeclarationTriple(affectedRelease, RDF.type(), SecurityDBsTBox.AffectedRelease(), false);
				writer.addDeclarationTriple(organizationName, RDF.type(), MainTBox.Organization(), false);
				writer.addIndividualTriple(cve, SecurityDBsTBox.affectRelease(), affectedRelease, false);
				writer.addIndividualTriple(cve, SecurityDBsTBox.affectProduct(), procutName, false);
				// We might delete 1 and 2 if the reasoner will be able to infer the inverse relations
				// hasVulnerability inverse of affectProduct
				/**1**/writer.addIndividualTriple(affectedRelease, SecurityDBsTBox.hasVulnerability(), cve, false);
				/**2**/writer.addIndividualTriple(procutName, SecurityDBsTBox.hasVulnerability(), cve, false);
				writer.addIndividualTriple(affectedRelease, SecurityDBsTBox.hasAffectedReleaseVersion(), versionID, true);
				writer.addIndividualTriple(affectedRelease, SecurityDBsTBox.hasAffectedReleaseName(), split[3], true);
			}
			
			if(currentEntry.getSummary() != null){
				String summaryURI = SecurityDBsABox.Summary(currentEntry.getcveID());
				writer.addIndividualTriple(summaryURI, RDF.type(), SecurityDBsTBox.Summary(), false);
	//			writer.addIndividualTriple(cve, SecurityDBsTBox.hasSummary(), summaryURI, false); // this might be changed to data-property !!
				writer.addIndividualTriple(summaryURI, MainTBox.hasDescription(), currentEntry.getSummary(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void nvd_SystemSpecificLayer(Entry currentEntry) {
		String cve = SecurityDBsABox.VulnerabilityURI(currentEntry.getcveID());
		// Check references sources, types, and location.
		try {
			if (currentEntry.getReferencesList() != null) {
				ArrayList<String> rfl = currentEntry.getReferencesList();
				// rfl contain [Reference type (e.g. Unknown, Patch, ...etc),
				// Reference Source, Reference Location (URL), ...]
				for (int i = 0; i < rfl.size();) {
					
					String ReferenceType = rfl.get(i);
					String ReferenceSource = rfl.get(i + 1);
					String ReferenceURL = rfl.get(i + 2);
										
					// TBox instances
					if (ReferenceType.equalsIgnoreCase("PATCH")) {
						writer.addDeclarationTriple(ReferenceURL, RDF.type(),SecurityDBs_nvdTBox.PatchReference(), false);
						writer.addIndividualTriple(ReferenceURL, SecurityDBs_nvdTBox.hasPatchSource(), ReferenceSource, true);
						writer.addIndividualTriple(cve, SecurityDBsTBox.hasStatus(), SecurityDBs_nvdTBox.Patched(), false);
					} else if (ReferenceType.equalsIgnoreCase("UNKNOWN")) {
						writer.addDeclarationTriple(ReferenceURL, RDF.type(),SecurityDBs_nvdTBox.UnknownReference(), false);
						writer.addIndividualTriple(ReferenceURL, SecurityDBs_nvdTBox.hasUnknownSource(), ReferenceSource, true);
						// trying to optmize the vulnerablility status,
						// so far, we can catputre the patched and detected status, 
						// and if non of these status happen, then the vulnerability status should be still unkown.
				//		writer.addIndividualTriple(cve, SecurityDBsTBox.hasStatus(), SecurityDBs_nvdTBox.Unknown(), false); 
					} else if (ReferenceType.equalsIgnoreCase("VENDOR_ADVISORY") || ReferenceSource.equalsIgnoreCase("CONFIRM")) {
						writer.addDeclarationTriple(ReferenceURL, RDF.type(),SecurityDBs_nvdTBox.VendorAdvisoryReference(),false);
						writer.addIndividualTriple(ReferenceURL, SecurityDBs_nvdTBox.hasVendorAdvisorySource(), ReferenceSource, true);
						writer.addIndividualTriple(cve, SecurityDBsTBox.hasStatus(),SecurityDBs_nvdTBox.Detected(), false);
					}
					i += 3;
				}
			}
			
			double score = currentEntry.getScore();
			if(score != -1){
				//ABox instances
				String scoreURI = SecurityDBsABox.Score(currentEntry.getcveID(),String.valueOf(score));
				writer.addDeclarationTriple(scoreURI, RDF.type(), SecurityDBsTBox.BaseScoreMertrics(), false);
				String severityLevel = null;
				/**
				 * 1. Vulnerabilities are labelled "Low" severity if they have a score of 0.0-3.9.
				 * 2. Vulnerabilities will be labelled "Medium" severity if they have a score of 4.0-6.9.
				 * 3. Vulnerabilities will be labelled "High" severity if they have a score of 7.0-10.0.
				 */
				if(score <= 3.9){
					severityLevel = SecurityDBs_nvdTBox.Low();
					writer.addIndividualTriple(cve, SecurityDBsTBox.hasSeverity(), severityLevel, false);
				}else if(score > 4 && score < 6.9){
					severityLevel = SecurityDBs_nvdTBox.Medium();
					writer.addIndividualTriple(cve, SecurityDBsTBox.hasSeverity(), severityLevel, false);
				}else if(score >= 7.0 ){
					severityLevel = SecurityDBs_nvdTBox.High();
					writer.addIndividualTriple(cve, SecurityDBsTBox.hasSeverity(), severityLevel, false);
				}
				writer.addDeclarationTriple(severityLevel, RDF.type(), SecurityDBsTBox.VulnerabilitySeverity(), false);
				writer.addIndividualTriple(severityLevel, SecurityDBsTBox.hasSeverityScore(), scoreURI, false);
				writer.addIndividualTriple(scoreURI, SecurityDBsTBox.hasAccessComplexity(), currentEntry.getAccessComplexity(), true);
				writer.addIndividualTriple(scoreURI, SecurityDBsTBox.hasAccessVector(), currentEntry.getAccessVector(), true);
				writer.addIndividualTriple(scoreURI, SecurityDBsTBox.hasAuthentication(), currentEntry.getAuthentication(), true);
				writer.addIndividualTriple(scoreURI, SecurityDBsTBox.hasAvailabilityImpact(), currentEntry.getAvailabilityImpact(),true);
				writer.addIndividualTriple(scoreURI, SecurityDBsTBox.hasIntegrityImpact(), currentEntry.getIntegrityImpact(), true);
				writer.addIndividualTriple(scoreURI, SecurityDBsTBox.hasConfidentialityImpact(), currentEntry.getConfidentialityImpact(), true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void distributer(Entry currentEntry){
		
		this.currentEntry = currentEntry;
		writer = new NtriplesWriter("C:/Users/umroot/workspace/data/triples/sevont.nt",100000, 500000);

//		System.out.println("Mapping "+ this.currentEntry.getcveID()+" facts into SEVONT layers");
		
		// Populate triples for General layer
		generalLayer(this.currentEntry);
		// Populate triples for Domain-Spanning layer
		domainSpanningLayer(this.currentEntry);
		// Populate triples for Domain-Specific layer
		domainSpecificLayer(this.currentEntry);
		// Populate triples for System-Specific layer
		nvd_SystemSpecificLayer(this.currentEntry);
		try {
			writer.flushAndClose();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

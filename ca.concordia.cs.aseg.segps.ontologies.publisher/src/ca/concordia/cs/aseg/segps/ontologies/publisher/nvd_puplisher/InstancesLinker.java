package ca.concordia.cs.aseg.segps.ontologies.publisher.nvd_puplisher;

import java.io.IOException;
import java.util.ArrayList;

import ca.concordia.cs.aseg.segps.ontologies.publisher.ntriples.NtriplesWriter;
import ca.concordia.cs.aseg.segps.ontologies.publisher.security_raw_data_parser.Entry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_spanning.abox.VulnerabilitiesABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_spanning.tbox.VulnerabilitiesTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox.SecurityDBsABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.tbox.SecurityDBsTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.abox.MainABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox.RDF;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.system_specific.abox.SecurityDBs_nvdABox;
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
//			String vulnID = SecurityDBsABox.VulnerabilityID(currentEntry.getcveID());
			String cve = SecurityDBsABox.VulnerabilityURI(currentEntry.getcveID());
			
			// TBox instances 
			writer.addDeclarationTriple(cve, RDF.type(), SecurityDBsTBox.Vulnerability(), false);
//			writer.addDeclarationTriple(cveRef, RDF.type(), SecurityDBsTBox.Reference(), false);
//			writer.addIndividualTriple(vulnID, SecurityDBsTBox.hasReferenceURI(), cveRef, false);
			writer.addIndividualTriple(cve, SecurityDBsTBox.hasVulnerabilityId(), currentEntry.getcveID(), true);
			
			//Check if the vulnerability has weakness type. 
			if(currentEntry.getcweID() != null){
				// ABox instances
			//	String cweID = SecurityDBsABox.WeaknessID(currentEntry.getcweID());
				String cwe = SecurityDBsABox.WeaknessURI(currentEntry.getcweID());
				// TBox instances
				writer.addDeclarationTriple(cwe, RDF.type(), SecurityDBsTBox.Weakness(), false);
//				writer.addDeclarationTriple(cweRef, RDF.type(), SecurityDBsTBox.Reference(), false);
				writer.addIndividualTriple(cve, SecurityDBsTBox.hasWeakness(), cwe, false);
//				writer.addIndividualTriple(vulnID, SecurityDBsTBox.hasWeaknessId(), cweRef, false);
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
				String affectedProduct = SecurityDBsABox.AffectedProductr(affectedProducts.get(i));
				String[] splits = affectedProduct.split(":");
				String Organization = MainABox.Organization(splits[0]);
				String Procut = MainABox.Product(splits[1]);
				String Version = splits[2];
				
			}
			// Write the final results into triple-store file
			//writer.flushAndClose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void systemSpecificLayer(Entry currentEntry) {
		String cve = SecurityDBsABox.VulnerabilityURI(currentEntry.getcveID());
		// Check references sources, types, and location.
		try {
			if (currentEntry.getReferencesList() != null) {
				ArrayList<String> rfl = currentEntry.getReferencesList();
				// rfl contain [Reference type (e.g. Unknown, Patch, ...etc),
				// Reference Source, Reference Location (URL), ...]
				for (int i = 0; i < rfl.size();) {
					// ABox instances
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
						writer.addIndividualTriple(cve, SecurityDBsTBox.hasStatus(), SecurityDBs_nvdTBox.Unknown(), false);
					} else if (ReferenceType.equalsIgnoreCase("VENDOR_ADVISORY") || ReferenceSource.equalsIgnoreCase("CONFIRM")) {
						writer.addDeclarationTriple(ReferenceURL, RDF.type(),SecurityDBs_nvdTBox.VendorAdvisoryReference(),false);
						writer.addIndividualTriple(ReferenceURL, SecurityDBs_nvdTBox.hasVendorAdvisorySource(), ReferenceSource, true);
						writer.addIndividualTriple(cve, SecurityDBsTBox.hasStatus(),SecurityDBs_nvdTBox.Detected(), false);
					}
					i += 3;
				}
			}

			// Write the final results into triple-store file
			//writer.flushAndClose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void distributer(Entry currentEntry){
		
		this.currentEntry = currentEntry;
		writer = new NtriplesWriter("out.nt",100000, 500000);

		System.out.println("Mapping "+ this.currentEntry.getcveID()+" facts into SEVONT layers");
		
		// Populate triples for General layer
		generalLayer(this.currentEntry);
		// Populate triples for Domain-Spanning layer
		domainSpanningLayer(this.currentEntry);
		// Populate triples for Domain-Specific layer
		domainSpecificLayer(this.currentEntry);
		// Populate triples for System-Specific layer
		systemSpecificLayer(this.currentEntry);
		try {
			writer.flushAndClose();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

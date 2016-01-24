package ca.concordia.cs.aseg.segps.ontologies.publisher.nvd_puplisher;

import ca.concordia.cs.aseg.segps.ontologies.publisher.ntriples.NtriplesWriter;
import ca.concordia.cs.aseg.segps.ontologies.publisher.security_raw_data_parser.Entry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_spanning.abox.VulnerabilitiesABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_spanning.tbox.VulnerabilitiesTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox.SecurityDBsABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.tbox.SecurityDBsTBox;
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
		writer = new NtriplesWriter("out.nt",100, 100);
		
		try {
			// ABox instances
//			String vulnID = SecurityDBsABox.VulnerabilityID(currentEntry.getcveID());
			String cve = SecurityDBsABox.VulnerabilityURI(currentEntry.getcveID());
			
			// TBox instances 
			writer.addDeclarationTriple(cve, RDF.type(), SecurityDBsTBox.Vulnerability(), false);
//			writer.addDeclarationTriple(cveRef, RDF.type(), SecurityDBsTBox.Reference(), false);
//			writer.addIndividualTriple(vulnID, SecurityDBsTBox.hasReferenceURI(), cveRef, false);
		
			if(currentEntry.getcweID() != null){
				// ABox instances
			//	String cweID = SecurityDBsABox.WeaknessID(currentEntry.getcweID());
				String cwe = SecurityDBsABox.WeaknessURI(currentEntry.getcweID());
				// TBox instances
				writer.addDeclarationTriple(cwe, RDF.type(), SecurityDBsTBox.Weakness(), false);
//				writer.addDeclarationTriple(cweRef, RDF.type(), SecurityDBsTBox.Reference(), false);
				writer.addIndividualTriple(cve, SecurityDBsTBox.hasWeakness(), cwe, false);
//				writer.addIndividualTriple(vulnID, SecurityDBsTBox.hasWeaknessId(), cweRef, false);
			}
			

			
			// Write the final results into triple-store file
			writer.flushAndClose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void systemSpecificLayer(Entry currentEntry){
	}
	
	public void distributer(Entry currentEntry){
		
		this.currentEntry = currentEntry;
		
		System.out.println("Mapping "+ this.currentEntry.getcveID()+" facts into SEVONT layers");
		
		// Populate triples for General layer
		generalLayer(this.currentEntry);
		// Populate triples for Domain-Spanning layer
		domainSpanningLayer(this.currentEntry);
		// Populate triples for Domain-Specific layer
		domainSpecificLayer(this.currentEntry);
		// Populate triples for System-Specific layer
		systemSpecificLayer(this.currentEntry);
	}

}

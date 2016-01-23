package ca.concordia.cs.aseg.segps.ontologies.publisher.nvd_puplisher;

import ca.concordia.cs.aseg.segps.ontologies.publisher.security_raw_data_parser.Entry;
import ca.concordia.cs.aseg.segps.ontologies.publisher.ntriples.NtriplesWriter;
public class InstancesLinker {
	
	private NtriplesWriter writer;
	
	private void generalLayer(Entry currentEntry){
		System.out.println("General Layer is Here :)");
	}
	
	private void domainSpanningLayer(Entry currentEntry){
		System.out.println("Domain-Spanning is Here :)");
	}
	
	private void domainSpecificLayer(Entry currentEntry){
		System.out.println("Domain-Specific Layer is Here :)");
	}
	
	private void systemSpecificLayer(Entry currentEntry){
		System.out.println("System-Specific Layer is Here :)");
	}
	
	public void distributer(Entry currentEntry){
		System.out.println("Populating instances and triples for Gneral layer ...");
		generalLayer(currentEntry);
		
		System.out.println("Populating instances and triples for Domain-Spanning layer ...");
		domainSpanningLayer(currentEntry);
		
		System.out.println("Populating instances and triples for Domain-Specific layer ...");
		domainSpecificLayer(currentEntry);
		
		System.out.println("Populating instances and triples for System-Specific layer ...");
		systemSpecificLayer(currentEntry);
	}

}

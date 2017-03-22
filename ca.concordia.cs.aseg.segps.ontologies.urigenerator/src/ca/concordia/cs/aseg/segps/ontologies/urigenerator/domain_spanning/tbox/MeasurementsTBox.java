/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */
package ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_spanning.tbox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;

public class MeasurementsTBox {

	public static String SimilarityMeasure() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.measurement)
				+ "SimilarityMeasure";
		return uri;
	}

	public static String measuresThing() {
			String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.main)
					+ "measuresThing";
			return uri;	}

	public static String hasMeasureValue() {
			String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.main)
					+ "hasMeasureValue";
			return uri;
	}

}

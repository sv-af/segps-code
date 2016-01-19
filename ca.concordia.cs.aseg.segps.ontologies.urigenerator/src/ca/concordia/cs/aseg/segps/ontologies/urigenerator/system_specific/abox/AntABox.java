/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */

package ca.concordia.cs.aseg.segps.ontologies.urigenerator.system_specific.abox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;

public class AntABox {
	public static String AntTarget(String target){
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.ant)
				+ target;
		return uri;
	}
	
	public static String AntTask(String task){
		String uri = NamespaceFactory.createAboxNamespace(NamespaceRegistry.theAboxNameSpace, OntologyRegistry.ant)
				+ task;
		return uri;
	}
}
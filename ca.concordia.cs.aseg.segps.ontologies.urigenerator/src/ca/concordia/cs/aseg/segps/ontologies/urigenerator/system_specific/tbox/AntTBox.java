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

public class AntTBox {

	/*
	 * CONCEPTS
	 */
	public static String AntTarget(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.ant) + "AntTarget";
		return uri;
	}
	
	public static String AntTask(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.ant) + "AntTask";
		return uri;
	}
	
	/*
	 * PROPERTIES
	 */
	public static String containsTask(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.ant) + "containsTask";
		return uri;
	}
	
	public static String hasTarget(){
		String uri= NamespaceFactory.createTboxNamespace(NamespaceRegistry.theTboxNameSpace, OntologyRegistry.ant) + "hasTarget";
		return uri;
	}
	
	
}
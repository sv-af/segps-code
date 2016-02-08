/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */

package ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;

public class CodeABox {

	public static String AccessModifier() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.code)
				+ "AccessModifier";
		return uri;
	}

	public static String AnnotationType() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.code)
				+ "AnnotationType";
		return uri;
	}

	public static String ClassType(String project, String clazz) {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.code)
				+ project+":"+clazz;
		return uri;
	}

	public static String CodeEntity() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.code)
				+ "CodeEntity";
		return uri;
	}

	public static String ComplexType() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.code)
				+ "ComplexType";
		return uri;
	}

	public static String Constructor(String constructor) {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.code)
				+ constructor;
		return uri;
	}

	public static String Datatype() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.code)
				+ "Datatype";
		return uri;
	}

	public static String EnumerationType() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.code)
				+ "EnumerationType";
		return uri;
	}

	public static String ExceptionType() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.code)
				+ "ExceptionType";
		return uri;
	}

	public static String Field() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.code)
				+ "Field";
		return uri;
	}

	public static String InterfaceType(String project, String interfaceName) {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.code)
				+ project+":"+interfaceName;
		return uri;
	}

	public static String Method(String method) {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.code)
				+ method;
		return uri;
	}

	public static String Namespace(String project, String nameSpace) {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.code)
				+ project+":"+nameSpace;
		return uri;
	}

	public static String Parameter(String paramString) {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.code)
				+ paramString;
		return uri;
	}

	public static String PrimitiveType(String returnType) {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.code)
				+ returnType;
		return uri;
	}

	public static String Variable() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONAboxNameSpace, OntologyRegistry.code)
				+ "Variable";
		return uri;
	}

}

/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */

package ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.tbox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace.NamespaceFactory;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.NamespaceRegistry;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.registry.OntologyRegistry;

public class CodeTBox {

	/*
	 * CONCEPTS
	 */
	public static String AccessModifier() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "AccessModifier";
		return uri;
	}

	public static String AnnotationType() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "AnnotationType";
		return uri;
	}

	public static String ClassType() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "ClassType";
		return uri;
	}

	public static String CodeEntity() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "CodeEntity";
		return uri;
	}

	public static String ComplexType() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "ComplexType";
		return uri;
	}

	public static String Constructor() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "Constructor";
		return uri;
	}

	public static String Datatype() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "Datatype";
		return uri;
	}

	public static String EnumerationType() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "EnumerationType";
		return uri;
	}

	public static String ExceptionType() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "ExceptionType";
		return uri;
	}

	public static String Field() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "Field";
		return uri;
	}

	public static String InterfaceType() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "InterfaceType";
		return uri;
	}

	public static String Method() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "Method";
		return uri;
	}

	public static String Namespace() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "Namespace";
		return uri;
	}

	public static String Parameter() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "Parameter";
		return uri;
	}

	public static String PrimitiveType() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "PrimitiveType";
		return uri;
	}

	public static String Variable() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "Variable";
		return uri;
	}

	/*
	 * PROPERTIES
	 */
	public static String accessesField() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "accessesField";
		return uri;
	}

	public static String catchesException() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "catchesException";
		return uri;
	}

	public static String constructorIsInvokedBy() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "constructorIsInvokedBy";
		return uri;
	}

	public static String containsCodeEntity() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "containsCodeEntity";
		return uri;
	}

	public static String declaresConstructor() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "declaresConstructor";
		return uri;
	}

	public static String declaresField() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "declaresField";
		return uri;
	}

	public static String declaresMethod() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "declaresMethod";
		return uri;
	}

	public static String expectsDatatype() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "expectsDatatype";
		return uri;
	}

	public static String hasAccessModifier() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "hasAccessModifier";
		return uri;
	}

	public static String hasDatatype() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "hasDatatype";
		return uri;
	}

	public static String hasNamespaceMember() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "hasNamespaceMember";
		return uri;
	}

	public static String hasParameter() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "hasParameter";
		return uri;
	}

	public static String hasReturnType() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "hasReturnType";
		return uri;
	}

	public static String hasSubClass() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "hasSubClass";
		return uri;
	}

	public static String hasSubInterface() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "hasSubInterface";
		return uri;
	}

	public static String hasSubtype() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "hasSubtype";
		return uri;
	}

	public static String hasSuperClass() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "hasSuperClass";
		return uri;
	}

	public static String hasSuperInterface() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "hasSuperInterface";
		return uri;
	}

	public static String hasSuperType() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "hasSuperType";
		return uri;
	}

	public static String implementsInterface() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "implementsInterface";
		return uri;
	}

	public static String instantiatesClass() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "instantiatesClass";
		return uri;
	}

	public static String invokesConstructor() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "invokesConstructor";
		return uri;
	}

	public static String invokesMethod() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "invokesMethod";
		return uri;
	}

	public static String isAccessedBy() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "isAccessedBy";
		return uri;
	}

	public static String isCaughtBy() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "isCaughtBy";
		return uri;
	}

	public static String isDatatypeOf() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "isDatatypeOf";
		return uri;
	}

	public static String isDeclaredConstructorOf() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "isDeclaredConstructorOf";
		return uri;
	}

	public static String isDeclaredFieldOf() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "isDeclaredFieldOf";
		return uri;
	}

	public static String isDeclaredMethodOf() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "isDeclaredMethodOf";
		return uri;
	}

	public static String isExpectedDatatype() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "isExpectedDatatype";
		return uri;
	}

	public static String isImplementedBy() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "isImplementedBy";
		return uri;
	}

	public static String isInstantiatedBy() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "isInstantiatedBy";
		return uri;
	}

	public static String isNamespaceMemberOf() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "isNamespaceMemberOf";
		return uri;
	}

	public static String isParameterOf() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "isParameterOf";
		return uri;
	}

	public static String isReturnTypeOf() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "isReturnTypeOf";
		return uri;
	}

	public static String isThrownBy() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "isThrownBy";
		return uri;
	}

	public static String methodIsInvokedBy() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "methodIsInvokedBy";
		return uri;
	}

	public static String throwsException() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "throwsException";
		return uri;
	}

	public static String usesComplexType() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "usesComplexType";
		return uri;
	}

	public static String hasCodeIdentifier() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "hasCodeIdentifier";
		return uri;
	}

	public static String hasDoc() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "hasDoc";
		return uri;
	}

	public static String hasLength() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "hasLength";
		return uri;
	}

	public static String hasPosition() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "hasPosition";
		return uri;
	}

	public static String isAbstract() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "isAbstract";
		return uri;
	}

	public static String isConstant() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "isConstant";
		return uri;
	}

	public static String isStatic() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "isStatic";
		return uri;
	}

	public static String startsAt() {
		String uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code)
				+ "startsAt";
		return uri;
	}

	/*public static void main(String[] args) {
		try {
			List<String> lines = new ArrayList<>();
			FileInputStream fis = new FileInputStream(new File("C:\\Users\\elliseghan\\Desktop\\props.txt"));

			// Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));

			String line = null;
			while ((line = br.readLine()) != null) {
				line = line.replace("\"", " ");
				lines.add(line.trim());
			}

			br.close();

			for (String str : lines) {
				String s = "public static String " + str
						+ "() {\nString uri = NamespaceFactory.createTboxNamespace(NamespaceRegistry.theSEONTboxNameSpace, OntologyRegistry.code) +\""
						+ str + "\";\n		return uri;	}";
				System.out.println(s);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
*/
	
	
}

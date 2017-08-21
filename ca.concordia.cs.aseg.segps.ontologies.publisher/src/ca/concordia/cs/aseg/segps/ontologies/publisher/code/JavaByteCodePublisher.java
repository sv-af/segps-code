package ca.concordia.cs.aseg.segps.ontologies.publisher.code;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.jar.JarFile;

import ca.concordia.cs.aseg.maven.util.Utils;
import ca.concordia.cs.aseg.segps.ontologies.publisher.util.NtriplesWriter;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox.CodeABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.tbox.CodeTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.abox.MainABox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox.MainTBox;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.general.tbox.RDF;
import ca.concordia.cs.aseg.segps.ontologies.urigenerator.system_specific.tbox.JavaTBox;
import cs.aseg.codeanalyzer.bytecode.BytecodeReader;
import gr.uom.java.xmi.AccessedMember;
import gr.uom.java.xmi.MethodCall;
import gr.uom.java.xmi.UMLClass;
import gr.uom.java.xmi.UMLGeneralization;
import gr.uom.java.xmi.UMLModel;
import gr.uom.java.xmi.UMLOperation;
import gr.uom.java.xmi.UMLRealization;

public class JavaByteCodePublisher {

	private int declarationTripleSize, individualTripleSize;
	public JavaByteCodePublisher() {
		this.declarationTripleSize=100000;
		this.individualTripleSize=500000;
	}
	public JavaByteCodePublisher(int declarationTripleSize, int individualTripleSize) {
		this.declarationTripleSize=declarationTripleSize;
		this.individualTripleSize=individualTripleSize;
	}
	public void publish(File file, String projectURI, List<String> dependencies, String outputLocation) {
		JarFile jarFile;
		try {
			jarFile = new JarFile(file);
			UMLModel model = new BytecodeReader(jarFile).getUmlModel();
			if (projectURI != null) {
				int pos = projectURI.indexOf("#") + 1;
				String projectID = projectURI.substring(pos);
				model.setId(projectID);
			}
			List<UMLModel> dependentModels = new ArrayList<>();
			dependentModels.add(model);
			for (String str : dependencies) {
				File jar = Utils.getJarFromShortURI(str);
				jarFile = new JarFile(jar);
				UMLModel umlModel = new BytecodeReader(jarFile).getUmlModel();
				umlModel.setId(str);
				dependentModels.add(umlModel);
			}
			createTriples(model, projectURI, dependentModels, outputLocation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createTriples(UMLModel model, String projectURI, List<UMLModel> dependentModels, String outputLocation)
			throws Exception {
		int pos = projectURI.indexOf("#") + 1;
		String project = projectURI.substring(pos);
		NtriplesWriter writer = new NtriplesWriter(outputLocation, declarationTripleSize, individualTripleSize);
		List<UMLClass> classes = model.getClassList();
		for (UMLClass clazz : classes) {
			String classFileURI = MainABox.File(clazz.getSourceFile());
			writer.addIndividualTriple(projectURI, MainTBox.containsFile(), classFileURI, false);
			String packageName = clazz.getPackageName();
			String pkgURI = CodeABox.Namespace(project, packageName);
			writer.addDeclarationTriple(pkgURI, RDF.type(), CodeTBox.Namespace(), false);
			writer.addIndividualTriple(classFileURI, CodeTBox.containsCodeEntity(), pkgURI, false);
			
			String classURI = null;
			if (clazz.isInterface()) {
				classURI = CodeABox.InterfaceType(project, clazz.getName());
				writer.addDeclarationTriple(classURI, RDF.type(), CodeTBox.InterfaceType(), false);
			} else {
				classURI = CodeABox.ClassType(project, clazz.getName());
				writer.addDeclarationTriple(classURI, RDF.type(), CodeTBox.ClassType(), false);
			}

			writer.addIndividualTriple(classFileURI, CodeTBox.containsCodeEntity(), classURI, false);
			writer.addDeclarationTriple(classURI, CodeTBox.hasCodeIdentifier(), clazz.getName(), true);
			writer.addIndividualTriple(classURI, CodeTBox.isNamespaceMemberOf(), pkgURI, false);
			String classVisibility = clazz.getVisibility();
			String visibilityURI = null;
			switch (classVisibility) {
			case "public":
				visibilityURI = JavaTBox.publicVisibility();
			case "private":
				visibilityURI = JavaTBox.privateVisibility();
			case "protected":
				visibilityURI = JavaTBox.protectedVisibility();
			}
			if (visibilityURI != null) {
				writer.addIndividualTriple(classURI, CodeTBox.hasAccessModifier(), visibilityURI, false);
			}
			/*
			 * Get method declarations and their contained invocations Create
			 * associated triples (including returntype, parameters and access
			 * modifiers for the method declarations)
			 */
			for (UMLOperation operation : clazz.getOperations()) {
				// System.out.println("\t method: " +
				// operation.toShortString());
				String operationURI = null;
				if (operation.isConstructor()) {
					operationURI = CodeABox.Constructor(project, clazz.toString(), operation.toShortString());
					// System.out.println(operationURI+" invokes:");
					writer.addDeclarationTriple(operationURI, RDF.type(), CodeTBox.Constructor(), false);
					writer.addDeclarationTriple(operationURI, CodeTBox.isDeclaredConstructorOf(), classURI, false);
					// System.out.println("\t constructor: " +
					// operation.toShortString());
				} else {
					operationURI = CodeABox.Method(project, clazz.toString(), operation.toShortString());
					// System.out.println(operationURI+" invokes:");
					writer.addDeclarationTriple(operationURI, RDF.type(), CodeTBox.Method(), false);
					writer.addDeclarationTriple(classURI, CodeTBox.declaresMethod(), operationURI, false);
					writer.addIndividualTriple(classFileURI, CodeTBox.containsCodeEntity(), operationURI, false);
					/*
					 * Create URI and triples for return type. How to
					 * differentiate between primitive and complex return types
					 */
					String returnType = operation.getReturnParameter().toString();
					String returnURI = null;
					if (returnType.startsWith("java")) {
						returnType = returnType.replace("/", ".");
						returnURI = CodeABox.PrimitiveType(returnType);
					} else {
						returnURI = CodeABox.ClassType(project, clazz.toString());
					}
					writer.addDeclarationTriple(operationURI, CodeTBox.hasReturnType(), returnURI, false);
					/*
					 * Create URIs and triples for method invocations
					 */
					Set<AccessedMember> members = operation.getAccessedMembers();
					for (AccessedMember member : members) {
						if (member instanceof MethodCall) {
							// System.out.println("\t\tinvocation: ");
							MethodCall call = (MethodCall) member;
							// System.out.println("\t\t\t name: " +
							// call.getMethodName());
							// System.out.println("\t\t\t owner: " +
							// call.getOriginClassName());
							// System.out.println("\t\t\t constructor: " +
							// call.isConstructorCall());

							String owner = getMethodOwner(call, dependentModels);
							if (owner != null) {
								String invocationURI = null;
								if (call.isConstructorCall()) {
									invocationURI = CodeABox.Constructor(owner, call.toShortString());
								} else {
									invocationURI = CodeABox.Method(owner, call.toShortString());
								}
								// System.out.println("\t"+invocationURI);
								writer.addDeclarationTriple(operationURI, CodeTBox.invokesMethod(), invocationURI,
										false);
							}
						}
					}

				}
				writer.addDeclarationTriple(operationURI, CodeTBox.hasCodeIdentifier(), operation.toShortString(),
						true);
				/* Create URI and triples for access modifier */
				String accessURI = null;
				switch (operation.getVisibility()) {
				case "public":
					accessURI = JavaTBox.publicVisibility();
				case "protected":
					accessURI = JavaTBox.protectedVisibility();
				case "private":
					accessURI = JavaTBox.privateVisibility();
				}
				if (accessURI != null)
					writer.addDeclarationTriple(operationURI, CodeTBox.hasAccessModifier(), accessURI, false);
				/* Create URIs and triples for method parameters */
				/*int position = 1;
				for (UMLParameter parameter : operation.getParameters()) {
					String paramString = parameter.toString().trim();
					if (!paramString.equals("void")) {
						int hashPos = operationURI.indexOf("#")+1;
						String paramOwner=operationURI.substring(hashPos);
						String paramURI = CodeABox.Parameter(paramOwner, paramString);
						writer.addDeclarationTriple(paramURI, RDF.type(), CodeTBox.Parameter(), false);
						writer.addDeclarationTriple(operationURI, CodeTBox.hasParameter(), paramURI, false);
						writer.addDeclarationTriple(paramURI, CodeTBox.hasPosition(), String.valueOf(position), true);
						position++;
					}
				}*/
				// System.out.println("\t\t name: " + operation.getName());
			}
			clazz=null;
		}
		/*
		 * Get Realizations and Generalizations within the model. Create triples
		 * for these
		 * 
		 */
		List<UMLRealization> realizations = model.getRealizationList();
		List<UMLGeneralization> generalizations = model.getGeneralizationList();
		for (UMLRealization realization : realizations) {
			String clientURI = CodeABox.ClassType(project, realization.getClient().getName());
			String provider = getComplexTypeOwner(realization.getSupplier(), dependentModels);
			if (provider != null) {
				String providerURI = CodeABox.ClassType(provider, realization.getSupplier());
				writer.addIndividualTriple(clientURI, CodeTBox.implementsInterface(), providerURI, false);
			}
			// System.out.println("Realization: " + realization);
		}
		for (UMLGeneralization generalization : generalizations) {
			String clientURI = CodeABox.ClassType(project, generalization.getChild().getName());
			String provider = getComplexTypeOwner(generalization.getParent(), dependentModels);
			if (provider != null) {
				String providerURI = CodeABox.ClassType(provider, generalization.getParent());
				writer.addIndividualTriple(clientURI, CodeTBox.hasSuperClass(), providerURI, false);
			}
			// System.out.println("Generalization: " + generalization);
		}
		writer.flushAndClose();
	}

	private String getMethodOwner(MethodCall methodCall, List<UMLModel> models) {
		String owner = null;
		for (UMLModel umlModel : models) {
			for (UMLClass umlClass : umlModel.getClassList()) {
				if (umlClass.getName().equals(methodCall.getOriginClassName())) {
					owner = umlModel.getId() + ":" + umlClass.getName();
				} else {
					continue;
				}
			}
		}
		return owner;
	}

	private String getComplexTypeOwner(String type, List<UMLModel> models) {
		String owner = null;
		for (UMLModel umlModel : models) {
			for (UMLClass umlClass : umlModel.getClassList()) {
				if (umlClass.getName().equals(type)) {
					owner = umlModel.getId();
				} else {
					continue;
				}
			}
		}
		return owner;
	}

	
}

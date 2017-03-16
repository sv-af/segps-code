package ca.concordia.cs.aseg.segps.ontologies.publisher.unit_test;

import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ca.concordia.cs.aseg.maven.parser.models.MavenArtifact;
import ca.concordia.cs.aseg.maven.parser.models.MavenDependency;
import ca.concordia.cs.aseg.segps.ontologies.publisher.build.MavenPublisher;

public class MavenPublisherTest {

	static File testFile = new File("D:\\eclipse\\workspace\\maven-processor\\src\\test\\resources\\testpom.pom");
	static File outFile = new File("experiment.nt");

	private List<MavenArtifact> setup() {
		List<MavenArtifact> list = new ArrayList<>();

		MavenArtifact A = new MavenArtifact("prjA", "A", "1.0");
		MavenArtifact B = new MavenArtifact("prjB", "B", "1.0");
		MavenArtifact C = new MavenArtifact("prjC", "C", "1.0");
		MavenArtifact D = new MavenArtifact("prjD", "D", "1.0");
		MavenArtifact E = new MavenArtifact("prjE", "E", "1.0");
		MavenArtifact F = new MavenArtifact("prjF", "F", "1.0");
		MavenArtifact G = new MavenArtifact("prjG", "G", "1.0");
		MavenArtifact H = new MavenArtifact("prjH", "H", "1.0");

		List<MavenDependency> ADeps = new ArrayList<>();
		MavenDependency depAB = new MavenDependency();
		depAB.setGroupID("prjB");
		depAB.setArtifactID("B");
		depAB.setVersion("1.0");
		List<String> exclusionsAB = new ArrayList<>();
		exclusionsAB.add("prjE:E");
		depAB.setExclusions(exclusionsAB);
		MavenDependency depAC = new MavenDependency();
		depAC.setGroupID("prjC");
		depAC.setArtifactID("C");
		depAC.setVersion("1.0");
		ADeps.add(depAB);
		ADeps.add(depAC);
		A.setDependencies(ADeps);

		List<MavenDependency> BDeps = new ArrayList<>();
		MavenDependency depBD = new MavenDependency();
		depBD.setGroupID("prjD");
		depBD.setArtifactID("D");
		depBD.setVersion("1.0");
		List<String> exclusionsBD = new ArrayList<>();
		exclusionsBD.add("prjG:G");
		depBD.setExclusions(exclusionsBD);
		MavenDependency depBF = new MavenDependency();
		depBF.setGroupID("prjF");
		depBF.setArtifactID("F");
		depBF.setVersion("1.0");
		BDeps.add(depBD);
		BDeps.add(depBF);
		B.setDependencies(BDeps);

		List<MavenDependency> CDeps = new ArrayList<>();
		MavenDependency depCE = new MavenDependency();
		depCE.setGroupID("prjE");
		depCE.setArtifactID("E");
		depCE.setVersion("1.0");
		CDeps.add(depCE);
		C.setDependencies(CDeps);

		List<MavenDependency> DDeps = new ArrayList<>();
		MavenDependency depDE = new MavenDependency();
		depDE.setGroupID("prjE");
		depDE.setArtifactID("E");
		depDE.setVersion("1.0");
		MavenDependency depDG = new MavenDependency();
		depDG.setGroupID("prjG");
		depDG.setArtifactID("G");
		depDG.setVersion("1.0");
		DDeps.add(depDE);
		DDeps.add(depDG);
		D.setDependencies(DDeps);

		List<MavenDependency> EDeps = new ArrayList<>();
		MavenDependency depEH = new MavenDependency();
		depEH.setGroupID("prjH");
		depEH.setArtifactID("H");
		depEH.setVersion("1.0");
		EDeps.add(depEH);
		E.setDependencies(EDeps);

		list.add(A);
		list.add(B);
		list.add(C);
		list.add(D);
		list.add(E);
		list.add(F);
		list.add(G);
		list.add(H);
		return list;
	}

	@Test
	public void test() {
		MavenPublisher publisher = new MavenPublisher();
		List<MavenArtifact> mavenArtifacts = setup();
		try {
			publisher.publishFromMavenArtifactList(outFile.getAbsolutePath(), mavenArtifacts);
		} catch (IOException e) {
			e.printStackTrace();
		}
		long fileSize = outFile.length();
		assertNotEquals(0, fileSize);
	}

}

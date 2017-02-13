package ca.concordia.cs.aseg.segps.ontologies.publisher.unit_test;

import static org.junit.Assert.assertNotEquals;

import java.io.File;

import org.junit.Test;

import ca.concordia.cs.aseg.segps.ontologies.publisher.build.MavenPublisher;

public class MavenPublisherTest {

	static File testFile = new File("D:\\eclipse\\workspace\\maven-processor\\src\\test\\resources\\testpom.pom");
	static File outFile = new File("sample-triples.nt");
	@Test
	public void test() {
		MavenPublisher publisher = new MavenPublisher();
		publisher.publish(outFile.getAbsolutePath(), testFile.getAbsolutePath());
		long fileSize = outFile.length();
		assertNotEquals(0, fileSize);
	}

}

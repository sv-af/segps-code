package ca.concordia.cs.aseg.segps.ontologies.urigenerator.testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.concordia.cs.aseg.segps.ontologies.urigenerator.domain_specific.abox.BuildABox;

public class ABoxUriTest {

	String project, release;
	
	@Test
	public void testBuildProjectURI() {
		project = "org.apache:derby";
		String uri = BuildABox.BuildProject(project);
		assertEquals("http://aseg.cs.concordia.ca/segps/ontologies/domain-specific/2015/02/build.owl#org.apache:derby", uri);
	}

	@Test
	public void testBuildReleaseURI() {
		release = "org.apache:derby:10.1";
		String uri = BuildABox.BuildRelease(release);
		assertEquals("http://aseg.cs.concordia.ca/segps/ontologies/domain-specific/2015/02/build.owl#org.apache:derby:10.1", uri);
	}
}

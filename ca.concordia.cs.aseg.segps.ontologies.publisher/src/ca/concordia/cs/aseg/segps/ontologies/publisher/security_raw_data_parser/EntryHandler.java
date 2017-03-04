/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */package ca.concordia.cs.aseg.segps.ontologies.publisher.security_raw_data_parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ca.concordia.cs.aseg.segps.ontologies.publisher.nvd_puplisher.InstancesLinker;


public class EntryHandler extends DefaultHandler{
	// to catch nvd entries.
	private Entry newEntry = null;
	private InstancesLinker instances = new InstancesLinker();
	boolean isCveID, isAffectedProduct, isPublishedDatetime, isLastModifiedDatetime, isScore,
			isAccessVector, isAccessComplexity, isAuthentication,
			isConfidentialityImpact, isIntegrityImpact, isAvailabilityImpact,
			isCweID, isReferenceType, isReferenceSource=false, isRefernceURL,
			isSummary;
	// to capture reference_type from xml tag attributes
	private String rt;
	// to capture href from xml tag attributes
	private String url;
	// to catputer cwe value from xml tag attributes
	private String cwe;

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {

		if(qName.equalsIgnoreCase("entry")){
			// Initialise nvd entry
			newEntry = new Entry();
		}else if(qName.equalsIgnoreCase("vuln:product")){
			isAffectedProduct = true;
		}else if(qName.equalsIgnoreCase("vuln:cve-id")){
			isCveID = true;
		}else if(qName.equalsIgnoreCase("vuln:published-datetime")){
			isPublishedDatetime = true;
		}else if(qName.equalsIgnoreCase("vuln:last-modified-datetime")){
			isLastModifiedDatetime = true;
		}else if(qName.equalsIgnoreCase("cvss:score")){
			isScore =true;
		}else if(qName.equalsIgnoreCase("cvss:access-vector")){
			isAccessVector = true;
		}else if(qName.equalsIgnoreCase("cvss:access-complexity")){
			isAccessComplexity = true;
		}else if(qName.equalsIgnoreCase("cvss:authentication")){
			isAuthentication = true;
		}else if(qName.equalsIgnoreCase("cvss:confidentiality-impact")){
			isConfidentialityImpact = true;
		}else if(qName.equalsIgnoreCase("cvss:integrity-impact")){
			isIntegrityImpact = true;
		}else if(qName.equalsIgnoreCase("cvss:availability-impact")){
			isAvailabilityImpact= true;
		}else if(qName.equalsIgnoreCase("vuln:cwe")){
			cwe = atts.getValue("id");
			isCweID = true;
		}else if(qName.equalsIgnoreCase("vuln:references")){
			rt = atts.getValue("reference_type");
			isReferenceType = true;
		}else if(qName.equalsIgnoreCase("vuln:source")){
			isReferenceSource = true;
		}else if(qName.equalsIgnoreCase("vuln:reference")){
			url = atts.getValue("href");
			isRefernceURL = true;
		}else if(qName.equalsIgnoreCase("vuln:summary")){
			isSummary = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(qName.equalsIgnoreCase("entry")){
			// Pass each collected XML tag <entry .. /entry> into the NVD publisher class
			this.instances.distributer(this.newEntry);
			// Empty the Entry object to read another data <entry ... /entry>
			newEntry = null;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(isAffectedProduct){
			newEntry.setAffectedProduct(new String(ch,start, length));
			isAffectedProduct =false;
		}else if(isCveID){
			newEntry.setcveID(new String(ch, start, length));
			isCveID = false;
		}else if(isPublishedDatetime){
			newEntry.setPublishedDatetime(new String(ch, start, length));
			isPublishedDatetime = false;
		}else if(isLastModifiedDatetime){
			newEntry.setLastModifiedDatetime(new String(ch, start, length));
			isLastModifiedDatetime = false;
		}else if(isScore){
			newEntry.setScore(Double.parseDouble(new String(ch, start, length)));
			isScore = false;
		}else if(isAccessVector){
			newEntry.setAccessVector(new String(ch, start, length));
			isAccessVector = false;
		}else if(isAccessComplexity){
			newEntry.setAccessComplexity(new String(ch, start, length));
			isAccessComplexity = false;
		}else if(isAuthentication){
			newEntry.setAuthentication(new String(ch, start, length));
			isAuthentication = false;
		}else if(isConfidentialityImpact){
			newEntry.setConfidentialityImpact(new String(ch, start, length));
			isConfidentialityImpact = false;
		}else if(isIntegrityImpact){
			newEntry.setIntegrityImpact(new String(ch, start, length));
			isIntegrityImpact = false;
		}else if(isAvailabilityImpact){
			newEntry.setAvailabilityImpact(new String(ch, start, length));
			isAvailabilityImpact = false;
		}else if(isCweID){
			newEntry.setcweID(cwe);
			isCweID = false;
		}else if(isReferenceType){
			newEntry.setReferenceType(rt);
			isReferenceType = false;
		}else if(isReferenceSource){
			newEntry.setReferenceSource(new String(ch, start, length));
			isReferenceSource = false;
		}else if(isRefernceURL){
			newEntry.setRefernceURL(url);
			isRefernceURL = false;
		}else if(isSummary){
			newEntry.setSummary(new String(ch, start, length));
			isSummary = false;
		}
	}

	@Override
	public void endDocument() throws SAXException {
		// to be completed
	}
}

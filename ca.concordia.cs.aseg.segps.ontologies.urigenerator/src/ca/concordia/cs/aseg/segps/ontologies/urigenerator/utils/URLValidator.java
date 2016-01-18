/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */
package ca.concordia.cs.aseg.segps.ontologies.urigenerator.utils;

import org.apache.commons.validator.UrlValidator;

public class URLValidator {
	
	/*
	  test case: a file from: 57/176/content/AceAuction/src2/net/narusas/si/auction/pdf/attested/...
	  produces such URL: <http://.../net.narusas.si.auction.pdf.attested.하위사항> 
	 */
	
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		boolean b=validate("http://.../net.narusas.si.auction.pdf.attested.하위사항");
		
		System.out.println(b);
		
		b=validate("http://aseg.cs.concordia.ca/resource/line/Apache+Derby/Uci_1_4/http%5C%3A%2F%2Fprojects.apache.org%2Fprojects%2Fderby.html%2Fjava%2Ftesting%2Forg%2Fapache%2FderbyTesting%2Fsystem%2Foe%2Ftest%2FOETest.java/36");
		System.out.println(b);
	}
	
	
	public static boolean validate(String URL)
	{
		boolean bresult=false;
		org.apache.commons.validator.UrlValidator validator=new UrlValidator();
		bresult=validator.isValid(URL);
		

		return(bresult);
	}
	
	
	
}

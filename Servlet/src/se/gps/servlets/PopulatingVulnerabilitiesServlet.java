package se.gps.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.gps.sparql.quries.SPARQLQueries;

public class PopulatingVulnerabilitiesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		SPARQLQueries query = new SPARQLQueries();
		boolean flag = false;
		String vendor = request.getParameter("vendor");
		String product = request.getParameter("product");
		String version = request.getParameter("version");
		String dependency = request.getParameter("dependency");
	/*	response.setContentType("text/plain");  
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(vendor+"\n");
		response.getWriter().write(product);
		response.getWriter().write(version);
		*/
		if (vendor != null && product != null && version != null && dependency.equalsIgnoreCase("dependency")) {
			flag = query.getTransitiveDependencies(vendor, product, version);
		}else{
			flag = query.getSecurtiyVulnerabilities(vendor, product, version);
		}
		 
		if (flag && dependency.equalsIgnoreCase("dependency")) {
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("vRQ2");
		}else if (flag){
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("vRQ1");
		}else{
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("fail");
		}
	}

	// Redirect POST request to GET request.
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
		// To be completed ...
	}

	/**
	 * Filter the string "message" for special HTML characters to prevent command
	 * injection attack
	 * @param message
	 * @return
	 */
	private static String checkingHTMLrequests(String message) {
		if (message == null)
			return null;
		int len = message.length();
		StringBuffer result = new StringBuffer(len + 20);
		char aChar;

		for (int i = 0; i < len; ++i) {
			aChar = message.charAt(i);
			switch (aChar) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '"':
				result.append("&quot;");
				break;
			default:
				result.append(aChar);
			}
		}
		return (result.toString());
	}

}

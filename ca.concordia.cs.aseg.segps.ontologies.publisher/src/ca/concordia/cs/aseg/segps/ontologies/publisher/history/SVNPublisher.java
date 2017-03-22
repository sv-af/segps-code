package ca.concordia.cs.aseg.segps.ontologies.publisher.history;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SVNPublisher extends CVSPublisher {

	private Map<String, String> tags;

	public SVNPublisher() {
		super();
		tags = new HashMap<>();
		tags.put("author", "th:contains(Author:)");
		tags.put("date", "th:contains(Date:)");
		tags.put("log", "pre.vc_log");
		tags.put("changedPaths", "tr > td > a");
		tags.put("id", "input[name=revision]");
	}

	public List<String> getTag(Document doc, String tagType) {
		List<String> elements = null;
		Elements elems = doc.select(tagType);
		if (elems.size() > 0) {
			elements = new ArrayList<String>();
			for (Element elem : elems) {
				// System.out.println(elem);
				if (tagType.contains(":contains")) {
					elements.add(elem.nextElementSibling().text());
				} else if (tagType.contains("input[")) {
					elements.add(elem.attr("value"));
				} else if (tagType.contains(">")) {
					if (elem.attr("title").equals("View File Contents")) {
						elements.add(elem.attr("href"));
					}
				} else {
					elements.add(elem.text());
				}
			}
		}
		return elements;
	}

	@Override
	public CVSArtifact createArtifact(String revisionURL) {
		CVSArtifact artifact = new CVSArtifact();
		List<String> logElements = null, dateElements = null, idElements = null, authorElements = null,
				pathElements = null;
		String processedURL = processLink(revisionURL);
		if (processedURL.isEmpty())
			return null;
		try {
			Document doc = Jsoup.connect(processedURL).get();
			logElements = getTag(doc, tags.get("log"));
			dateElements = getTag(doc, tags.get("date"));
			idElements = getTag(doc, tags.get("id"));
			authorElements = getTag(doc, tags.get("author"));
			pathElements = getTag(doc, tags.get("changedPaths"));

		} catch (IOException e) {
			System.out.println("Exception caught on: " + processedURL);
			e.printStackTrace();
		}
		try {
			if (logElements != null && logElements.size() > 0)
				artifact.setCommitMessage(logElements.get(0));
			if (dateElements != null && dateElements.size() > 0) {
				String dateStr = dateElements.get(0);
				if (dateStr.contains("(")) {
					int pos = dateStr.indexOf("(");
					dateStr = dateStr.substring(0, pos);
				}
				artifact.setCommitDate(convertDate(dateStr.trim()));
			}
			if (idElements != null && idElements.size() > 0)
				artifact.setCommitID(idElements.get(0));
			if (authorElements != null && authorElements.size() > 0)
				artifact.setCommitter(authorElements.get(0));
			artifact.setRevisionURL(processedURL);
			Map<String, String> changesetMap = createFileVersionMap(pathElements);
			artifact.setChangeSet(changesetMap);
			artifact.setAuthor(artifact.getCommitter());
		} catch (NullPointerException exception) {
			exception.printStackTrace();
		}
		return artifact;
	}

	@Override
	public Map<String, String> createFileVersionMap(List<String> changeset) {
		Map<String, String> map = new HashMap<>();
		for (String versionedFile : changeset) {
			int pos = versionedFile.indexOf("?");
			String file = versionedFile.substring(0, pos);
			map.put(file, versionedFile);
		}
		return map;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String convertDate(String dateStr) {
		long dateLong = Date.parse(dateStr);
		DateTime dateTime = new DateTime(dateLong);
		return dateTime.toString();
	}
}

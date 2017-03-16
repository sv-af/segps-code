package ca.concordia.cs.aseg.segps.ontologies.publisher.history;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

public class GithubPublisher extends CVSPublisher {
	//TODO respect Github api rate limits (either with BasicAuthentication or OAuth)
	
	public GithubPublisher() {
		super();
	}

	@Override
	public CVSArtifact createArtifact(String revisionURL) {
		CVSArtifact artifact = new CVSArtifact();
		String processedURL = processLink(revisionURL);
		if(processedURL.isEmpty())
			return null;
		// String query =
		// "https://api.github.com/repos/torvalds/linux/commits/338c7dbadd2671189cec7faf64c84d01071b3f96";
		HttpClient client = HttpClientBuilder.create().build();
		URL url = null;
		URI uri = null;
		try {
			url = new URL(processedURL);
			String nullFragment = null;
			uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), nullFragment);
			HttpGet request = new HttpGet(uri);
			HttpResponse httpResponse = client.execute(request);
			if (httpResponse != null) {
				BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}
				JSONObject jsonObject = new JSONObject(result.toString());
				artifact.setRevisionURL(processedURL);
				artifact.setCommitID(jsonObject.getString("sha"));
				JSONObject commitObject = jsonObject.getJSONObject("commit");
				artifact.setCommitMessage(commitObject.getString("message"));
				JSONObject authorObject = commitObject.getJSONObject("author");
				JSONObject committerObject = commitObject.getJSONObject("committer");
				artifact.setCommitDate(committerObject.getString("date"));
				artifact.setCommitter(committerObject.getString("name"));
				if (authorObject == null) {
					artifact.setAuthor(artifact.getCommitter());
				} else {
					artifact.setAuthor(authorObject.getString("name"));
				}
				JSONArray fileArray = jsonObject.getJSONArray("files");
				List<String> changeSet = new ArrayList<>();
				for (int i = 0; i < fileArray.length(); i++) {
					JSONObject file = (JSONObject) fileArray.get(i);
					changeSet.add(file.getString("raw_url"));
				}
				Map<String, String> changesetMap = createFileVersionMap(changeSet);
				artifact.setChangeSet(changesetMap);
			}
		} catch (Exception e) {
			System.out.println("Exception caught on: "+processedURL);
			e.printStackTrace();
		}
		return artifact;
	}
	
	@Override
	public Map<String, String> createFileVersionMap(List<String> changeset) {
		Map<String, String> map = new HashMap<>();
		for(String versionedFile: changeset){
			int pos1 = versionedFile.indexOf("/raw/");
			String filePart1 = versionedFile.substring(0, pos1);
			filePart1=filePart1.replace("https://github.com", "");
			String filePart2 = versionedFile.substring(pos1+5);
			filePart2=filePart2.substring(filePart2.indexOf("/"));
			String file=filePart1+filePart2;
			map.put(file, versionedFile);
		}
		return map;
	}
}

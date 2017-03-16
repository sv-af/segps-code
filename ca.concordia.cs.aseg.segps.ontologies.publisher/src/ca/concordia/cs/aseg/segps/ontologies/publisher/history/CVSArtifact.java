package ca.concordia.cs.aseg.segps.ontologies.publisher.history;

import java.util.Map;

public class CVSArtifact {

	private String commitID, commitDate, commitMessage, committer, author, revisionURL;
	private Map<String, String> changeSet;// map holds file->versionedFile

	public String getCommitID() {
		return commitID;
	}

	public void setCommitID(String commitID) {
		this.commitID = commitID;
	}

	public String getCommitDate() {
		return commitDate;
	}

	public void setCommitDate(String commitDate) {
		this.commitDate = commitDate;
	}

	public String getCommitMessage() {
		return commitMessage;
	}

	public void setCommitMessage(String commitMessage) {
		this.commitMessage = commitMessage;
	}

	public String getCommitter() {
		return committer;
	}

	public void setCommitter(String committer) {
		this.committer = committer;
	}

	public String getRevisionURL() {
		return revisionURL;
	}

	public void setRevisionURL(String revisionURL) {
		this.revisionURL = revisionURL;
	}

	public Map<String, String> getChangeSet() {
		return changeSet;
	}

	public void setChangeSet(Map<String, String> changeSet) {
		this.changeSet = changeSet;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		String result = commitID + "\n" + revisionURL + "\n" + committer + "\n" + commitDate + "\n" + commitMessage;
		if (changeSet != null)
			result = result + "\n" + changeSet.toString();
		result = result + "\n------------------------------------";
		return result;
	}

	
}

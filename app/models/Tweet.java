package models;

/**
 * Model class which represents one analyzed tweet 
 * @author Marcin
 *
 */
public class Tweet {

	private String candidate;
	private String time;
	private Boolean sentiment;
	//Maybe tweet content ?
	
	
	public String getCandidate() {
		return candidate;
	}
	public Tweet(String candidate, String time, Boolean sentiment) {
		super();
		this.candidate = candidate;
		this.time = time;
		this.sentiment = sentiment;
	}
	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Boolean getSentiment() {
		return sentiment;
	}
	public void setSentiment(Boolean sentiment) {
		this.sentiment = sentiment;
	}
	
	
	
}

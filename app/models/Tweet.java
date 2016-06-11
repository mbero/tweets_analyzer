package models;

/**
 * Model class which represents one analyzed tweet 
 * @author Marcin
 *
 */

public class Tweet {


	
	private String candidate;
	private String time;
	private String sentiment;
	public String getCandidate() {
		return candidate;
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
	public String getSentiment() {
		return sentiment;
	}
	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}
	public Tweet(String candidate, String time, String sentiment) {
		super();
		this.candidate = candidate;
		this.time = time;
		this.sentiment = sentiment;
	}
	
	

	
	
	
	
	
	
}

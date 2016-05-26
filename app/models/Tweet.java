package models;

import java.util.Date;

public class Tweet {

	private String candidate;
	private Date time;
	private Double sentiment;
	
	
	public Tweet(String candidate, Date time, Double sentiment) {
		super();
		this.candidate = candidate;
		this.time = time;
		this.sentiment = sentiment;
	}
	public String getCandidate() {
		return candidate;
	}
	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Double getSentiment() {
		return sentiment;
	}
	public void setSentiment(Double sentiment) {
		this.sentiment = sentiment;
	}
	
	
	
}

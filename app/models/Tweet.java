package models;

/**
 * Model class which represents one analyzed tweet 
 * @author Marcin
 *
 */
//@Entity
//extends Model
public class Tweet {

	//@Id
	//@Constraints.Min(10)
	private Integer id;
	private String candidate;
	private String time;
	private Integer sentiment; //0 lub 1
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Integer getSentiment() {
		return sentiment;
	}
	public void setSentiment(Integer sentiment) {
		this.sentiment = sentiment;
	}
	public Tweet(String candidate, String time, Integer sentiment) {
		super();
		this.candidate = candidate;
		this.time = time;
		this.sentiment = sentiment;
	}
	
	
	
	
}

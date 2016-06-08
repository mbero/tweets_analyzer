package services;

import java.util.List;

import com.google.inject.Inject;

import models.Tweet;

public class TweetsManager {
	
	@Inject
	public TweetsManager()
	{}
	
	public void saveTweetsToDB(List<Tweet> tweets)
	{
		//TODO implement
	}
	
	public List<Tweet> getAllTweetsFromDB()
	{
		//TODO implement
		return null;
	}
	
}

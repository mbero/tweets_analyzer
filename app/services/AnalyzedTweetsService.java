package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.inject.Inject;

import models.Tweet;

public class AnalyzedTweetsService {
	@Inject
	public AnalyzedTweetsService() {
	}

	/**
	 * Get all Tweets from DB and return them as list for drawing timeline
	 * @param keyword
	 * @return
	 */
	public List<Tweet> getTweetsForGivenKeyword(String keyword) {

		List<Tweet> tweetsInformationsList = new ArrayList<Tweet>();

		Tweet tweet1 = new Tweet("TRUMP", "2015-05-05", true);
		Tweet tweet2 = new Tweet("TRUMP", "2015-05-06", true);
		Tweet tweet3 = new Tweet("TRUMP", "2015-05-07", false);

		tweetsInformationsList.add(tweet1);
		tweetsInformationsList.add(tweet2);
		tweetsInformationsList.add(tweet3);

		return tweetsInformationsList;
	}

	public JsonNode getResultCollectionAsJsonNode(Object collection) {
		com.fasterxml.jackson.databind.JsonNode jsonNode = null;
		try {
			com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
			Gson gson = new Gson();
			String output = gson.toJson(collection);
			jsonNode = mapper.readTree(output);
		} catch (JsonProcessingException e) {
			//("JsonProcessingException" ,e.getCause());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonNode;
	}
}

package controllers;

import java.util.List;

import models.Tweet;
import play.mvc.Controller;
import play.mvc.Result;
import services.AnalyzedTweetsService;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;

/**
 * This controller is responsible for getting data from Apache Kafka instance
 * @author Marcin
 *
 */
public class DataController extends Controller {

	@Inject
	AnalyzedTweetsService analyzedTweetsService;
    /**
     * Returns JSON arrays with serializded Tweet class objects
     * @param keyword
     * @return JSON
     */
    public Result getTweetsForGivenKeyword(String keyword) {
    	List<Tweet> listOfAnalyzedTweets = analyzedTweetsService.getTweetsForGivenKeyword(keyword);
    	JsonNode jsonNodeResult = analyzedTweetsService.getResultCollectionAsJsonNode(listOfAnalyzedTweets);
    	return ok(jsonNodeResult); 
    }
}

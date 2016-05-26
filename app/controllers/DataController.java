package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * This controller is responsible for getting data from Apache Kafka instance
 * @author Marcin
 *
 */
public class DataController extends Controller {

    /**
     * Returns JSON arrays with serializded Tweet class objects
     * @param keyword
     * @return JSON
     */
    public Result getTweetsForGivenKeyword(String keyword) {
    	
    	return null;
    }
}

/**
 * Simple data provider from REST resources
 * 
 * Example usage
 * 
 * var tweetsDataProvider = new AnalyzedTweetsDataProvider();
 * var resultsForGivenKeywordPromise = tweetsDataProvider.getResultsForGivenKeywordPromise();
 * resultsForGivenKeywordPromise.done(function(response)
 * {
 * 		doSomethingWithResponseFunction(response);
 * });
 */

function AnalyzedTweetsDataProvider() {

}
AnalyzedTweetsDataProvider.prototype.test = function() {
	return "test";
};

AnalyzedTweetsDataProvider.prototype.getResultsForGivenKeywordPromise = function(keyword) {
	return getResultsForGivenKeywordPromise(keyword);
};


function getResultsForGivenKeywordPromise(tweetsKeyword)
{

	var resultForGivenKeywordPromise = $.ajax({
	    url: "/tweetssentiment",
	    data: {
	    	keyword:tweetsKeyword 
	    },
	    type: "GET"
	});
	
	return resultForGivenKeywordPromise;
}
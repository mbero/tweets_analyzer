var currentlySelectedCandidate;
$( document ).ready(function() {
    if (document.location.pathname.indexOf("analyze")>-1) {
    	
    	getDataAboutAnalyzedTweetsForGivenKeyword('TRUMP');
    	getDataAboutAnalyzedTweetsForGivenKeyword2('CLINTON');
    	//currentlySelectedCandidate='TRUMP';
    }
});

function switchCandidate()
{
	if(currentlySelectedCandidate==='TRUMP')
	{
		 getDataAboutAnalyzedTweetsForGivenKeyword('CLINTON');
		 $("#candidate_name").html("'CLINTON' tweets");
	}
	if(currentlySelectedCandidate==='CLINTON')
	{
		 getDataAboutAnalyzedTweetsForGivenKeyword('TRUMP');
		 $("#candidate_name").html("'TRUMP' tweets");
	}
}
//FOR GRAPH 2D
function getDataAboutAnalyzedTweetsForGivenKeyword(keyword)
{
	 var tweetsDataProvider = new AnalyzedTweetsDataProvider();
	 var resultsForGivenKeywordPromise = tweetsDataProvider.getResultsForGivenKeywordPromise(keyword);
	 var items = new Array();
	 resultsForGivenKeywordPromise.done(function(response)
	 {
			for(var i=0; i<response.length; i++)
		 	{
				var currentResponseObjectDate = (new Date(Number(response[i].time))).toLocaleString();
				var currentResponseObjectSentiment = response[i].sentiment;
				var graphPointObject = new GraphPointObject(currentResponseObjectDate, currentResponseObjectSentiment);
				items.push(graphPointObject);
		 	}
			 var startDate = (new Date(Number(response[0].time))).toLocaleString();
			 var endDate = (new Date(Number(response[response.length-1].time))).toLocaleString();
			 var dataset = new vis.DataSet(items);
			  var options = {
			    start: startDate,
			    end: endDate
			  };
			  var container = document.getElementById('visualization');
			  var graph2d = new vis.Graph2d(container, dataset, options)
	 });
	 
}

function getDataAboutAnalyzedTweetsForGivenKeyword2(keyword)
{
	 var tweetsDataProvider = new AnalyzedTweetsDataProvider();
	 var resultsForGivenKeywordPromise = tweetsDataProvider.getResultsForGivenKeywordPromise(keyword);
	 var items = new Array();
	 resultsForGivenKeywordPromise.done(function(response)
	 {
			for(var i=0; i<response.length; i++)
		 	{
				var currentResponseObjectDate = (new Date(Number(response[i].time))).toLocaleString();
				var currentResponseObjectSentiment = response[i].sentiment;
				var graphPointObject = new GraphPointObject(currentResponseObjectDate, currentResponseObjectSentiment);
				items.push(graphPointObject);
		 	}
			 var startDate = (new Date(Number(response[0].time))).toLocaleString();
			 var endDate = (new Date(Number(response[response.length-1].time))).toLocaleString();
			 var dataset = new vis.DataSet(items);
			  var options = {
			    start: startDate,
			    end: endDate
			  };
			  var container = document.getElementById('visualization2');
			  var graph2d = new vis.Graph2d(container, dataset, options)
	 });
	 
}

function GraphPointObject(x,y)
{
	this.x=x;
	this.y=y;
}
//FOR TIMELINE
/* 
function getDataAboutAnalyzedTweetsForGivenKeyword(keyword)
{
	 var tweetsDataProvider = new AnalyzedTweetsDataProvider();
	 var resultsForGivenKeywordPromise = tweetsDataProvider.getResultsForGivenKeywordPromise(keyword);
	 resultsForGivenKeywordPromise.done(function(response)
	 {		
		 	var responseTransformedIntoVisDataSetArray = new Array();
		 	for(var i=0; i<response.length; i++)
		 	{
		 		var currentResponseObject = response[i];
		 		var currentDataSetObject = new DataSetObject(i, currentResponseObject.candidate, currentResponseObject.time);
		 		responseTransformedIntoVisDataSetArray.push(currentDataSetObject);
		 	}
		 	//var items = new vis.DataSet([]);
	    	constructTimeLineForGivenData(responseTransformedIntoVisDataSetArray);
	 });
}
*/



//FOR TIMELINE
function DataSetObject(id,content,start)
{
	this.id=id;
	this.content=content;
	this.start=start;
}

/**
 * Construct Timeline using vis.js
 * @param items
 */
function constructTimeLineForGivenData(items)
{
	 var container = document.getElementById('visualization');
	 // Configuration for the Timeline
	  var options = {};
	  // Create a Timeline
	  var timeline = new vis.Timeline(container, items, options);
}
	
function getMomentJSObjectFromMillis(millis)
{
	var momentobject = moment(millis);
	return momentobject;
}

/*
 * {id: 1, content: 'item 1', start: '2014-04-20'},
                             {id: 2, content: 'item 2', start: '2014-04-14'},
                             {id: 3, content: 'item 3', start: '2014-04-18'},
                             {id: 4, content: 'item 4', start: '2014-04-16', end: '2014-04-19'},
                             {id: 5, content: 'item 5', start: '2014-04-25'},
                             {id: 6, content: 'item 6', start: '2014-04-27', type: 'point'}
 */
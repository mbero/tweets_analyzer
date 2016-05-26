$( document ).ready(function() {
    if (document.location.pathname.indexOf("analyze")>-1) {
    	
    	var items = new vis.DataSet([
    	                             {id: 1, content: 'item 1', start: '2014-04-20'},
    	                             {id: 2, content: 'item 2', start: '2014-04-14'},
    	                             {id: 3, content: 'item 3', start: '2014-04-18'},
    	                             {id: 4, content: 'item 4', start: '2014-04-16', end: '2014-04-19'},
    	                             {id: 5, content: 'item 5', start: '2014-04-25'},
    	                             {id: 6, content: 'item 6', start: '2014-04-27', type: 'point'}
    	                           ]);
    	constructTimeLineForGivenData(items);
    }
});

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
package tools;

import java.util.concurrent.CompletionStage;

import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;

public class RESTClient {
	 @Inject WSClient ws;
	 
	public String getJSONFromGivenURL(String url)
	{
		//WSRequest request = ws.url("http://example.com");
		CompletionStage<WSResponse> jsonPromise = ws.url(url).get();
		JsonNode jsonNode =  (JsonNode) jsonPromise.thenApply(WSResponse::asJson);
		String jsonPromiseString = jsonNode.toString();
		
		return jsonPromiseString;
	}
}

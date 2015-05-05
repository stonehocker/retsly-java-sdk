package io.rets.sdk.exception;

import org.apache.http.HttpResponse;
import org.json.JSONObject;

public class RetslyException  extends Exception{
	public RetslyException(JSONObject json){
		super(getMessage(json));
	}
	private static String getMessage(JSONObject json) {
		JSONObject errObj = json.getJSONObject("bundle");
		String errorMsg = errObj.getString("name") + ":" + errObj.getString("message");
		return errorMsg;
	}
	private static String getMessage(HttpResponse response) {
		String errorMsg = response.getStatusLine().getStatusCode() + ":"+ response.getStatusLine().getReasonPhrase();
		return errorMsg;
	}
	public RetslyException(HttpResponse response){
		super(getMessage(response));
	}
}

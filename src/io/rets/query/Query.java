package io.rets.query;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.rets.HttpHackClient;
import io.rets.RetslyClient;
import io.rets.resources.Listing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewsa on 4/28/15.
 */
public abstract class Query<T> {

    private static String LIMIT_ARGUMENT = "limit";
    private static String OFFSET_ARGUMENT = "offset";
    
    private RetslyClient retsly;
    protected List<NameValuePair> arguments;
    protected String resource = "";

    public Query(RetslyClient retsly){
        this.retsly = retsly;
        this.arguments = new ArrayList<NameValuePair>();
    }

    public Query<T> where(NameValuePair nv){
        arguments.add(nv);
        return this;
    }
 
    public Query<T> limit(int limit){
        arguments.add(new BasicNameValuePair(LIMIT_ARGUMENT,Integer.toString(limit)));
        return this;
    }

    public Query<T> offset(int offset){
        arguments.add(new BasicNameValuePair(OFFSET_ARGUMENT,Integer.toString(offset)));
        return this;
    }
    protected String buildRequestURL(){
    	return RetslyClient.RESTLY_URL + this.resource + "/" + retsly.getVendor();
    }
    protected String buildRequestParameters(){
         // make GET request to the given URL
         String params = "access_token="+ retsly.getToken();
         if(arguments != null) params = params + "&" + URLEncodedUtils.format(arguments, "utf-8");
         return params;
    }
    
    protected String buildListRequestString(){
    	return this.buildRequestURL() + ".json?" + this.buildRequestParameters();
    }
    
    protected String buildSingleRequestString(String id){
    	return this.buildRequestURL() +"/" + id + ".json?" + this.buildRequestParameters();
    }
    
    protected JSONArray executeListQuery() throws IOException, JSONException, HttpException{
    	String request = this.buildListRequestString();
 	    JSONObject result = this.executeQuery(request);
 	    if(result.has("status") && result.getBoolean("success") == true)
 	    {
 	        return result.getJSONArray("bundle");
 	    }
 	    else{
 	        throw new HttpException("Server responded with ");
 	    }
    }
	
    protected JSONObject executeSingleQuery(String id) throws IOException,JSONException, HttpException{
	    String request = this.buildSingleRequestString(id);
	    JSONObject result = this.executeQuery(request);
	    
        return result != null ? result.getJSONObject("bundle") : null;
	        
    }
	    
    protected JSONObject executeQuery(String req) throws IOException,JSONException, HttpException {
	    HttpClient httpclient = HttpHackClient.getNewHttpClient();
	    HttpResponse httpResponse = httpclient.execute(new HttpGet(req));
	    // receive response as inputStream
	    int statusCode =  httpResponse.getStatusLine().getStatusCode();
	    String contentType = httpResponse.getFirstHeader("Content-Type").getValue();
	    if(contentType.contains("application/json")){
		    String res = EntityUtils.toString(httpResponse.getEntity());
		    JSONObject responseJson = new JSONObject(res);
		    //Convert the string result to a JSON Object
		    if(statusCode == HttpStatus.SC_OK && responseJson.getBoolean("success") == true)
			    return responseJson;
		    else{
		        throw new HttpException("Server responded with ");
		    }
	    }
	    else
	    {
	        throw new HttpException("Server responded with ");
	    }
	}
    
    protected abstract T createResource(JSONObject json);
    
    public List<T> findAll() throws IOException ,JSONException, HttpException {
        JSONArray jsonArray = this.executeListQuery();
        List<T> list = new ArrayList<T>();
        for (int i = 0; i < jsonArray.length(); i++) {
        	list.add(createResource(jsonArray.getJSONObject(i)));
        }
        return list;
    }

   	public T findOne() throws IOException, JSONException, HttpException {
		this.limit(0);
		JSONArray list = this.executeListQuery();
		if(list.length() > 0) return createResource(list.getJSONObject(0));
		return null;
	}
   	
	public Listing findById(String id) throws IOException, JSONException, HttpException {
        JSONObject jsonObj = this.executeSingleQuery(id);
        return new Listing(jsonObj);   
	}
}

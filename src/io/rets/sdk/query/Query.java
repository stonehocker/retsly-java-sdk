package io.rets.sdk.query;
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

import io.rets.sdk.HttpHackClient;
import io.rets.sdk.RetslyClient;
import io.rets.sdk.async.AsyncInvoke;
import io.rets.sdk.async.AsyncListInvoke;
import io.rets.sdk.async.RetslyCallback;
import io.rets.sdk.async.RetslyListCallback;
import io.rets.sdk.exception.RetslyException;
import io.rets.sdk.resources.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewsa on 4/28/15.
 */
public abstract class Query<T> {

    private static String LIMIT_ARGUMENT = "limit";
    private static String OFFSET_ARGUMENT = "offset";
    private static String TOKEN_ARGUMENT = "access_token";
    private RetslyClient retsly;
    protected List<NameValuePair> arguments;
    protected String resource = "";
    private String vendor = null;
    
    public enum Operators{
    	gt,gte,lt,lte,eq
    }

    public Query(RetslyClient retsly){
        this.retsly = retsly;
        this.arguments = new ArrayList<NameValuePair>();
    }

    public Query<T> vendor(String vendor){
    	this.vendor = vendor;
        return this;
    }
    
    public String getVendor(){
    	return this.vendor != null? vendor : retsly.getVendor();
    }
    
    public Query<T> where(NameValuePair nv){
        arguments.add(nv);
        return this;
    }
    
    protected Query<T> where(String property, Query.Operators op, String value){
    	String propAndOperation = property;
    	if(!op.equals(Query.Operators.eq)){
    		propAndOperation += "[" + op.toString() + "]";
    	}
        this.where(new BasicNameValuePair(propAndOperation, value));
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
    	return RetslyClient.RESTLY_URL + this.resource + "/" + this.getVendor();
    }
    protected String buildRequestParameters(){
         // make GET request to the given URL
         String params = TOKEN_ARGUMENT + "=" + retsly.getToken();
         if(arguments != null) params = params + "&" + URLEncodedUtils.format(arguments, "utf-8");
         return params;
    }
    
    protected String buildListRequestString(){
    	return this.buildRequestURL() + ".json?" + this.buildRequestParameters();
    }
    
    protected String buildSingleRequestString(String id){
    	return this.buildRequestURL() +"/" + id + ".json?" + this.buildRequestParameters();
    }
    
    protected JSONArray executeListQuery() throws IOException, RetslyException{
    	String request = this.buildListRequestString();
 	    JSONObject result = this.executeQuery(request);
 	    return result != null ? result.getJSONArray("bundle") : null;
    }
	
    protected JSONObject executeSingleQuery(String id) throws IOException, RetslyException{
	    String request = this.buildSingleRequestString(id);
	    JSONObject result = this.executeQuery(request);
	    
        return result != null ? result.getJSONObject("bundle") : null;
	        
    }
	    
    protected JSONObject executeQuery(String req) throws IOException, RetslyException {
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
		        throw new RetslyException(responseJson);
		    }
	    }
	    else
	    {
	        throw new RetslyException(httpResponse);
	    }
	}
    
    protected abstract T createResource(JSONObject json);
    
    public List<T> findAll() throws IOException , RetslyException {
        JSONArray jsonArray = this.executeListQuery();
        List<T> list = new ArrayList<T>();
        for (int i = 0; i < jsonArray.length(); i++) {
        	list.add(createResource(jsonArray.getJSONObject(i)));
        }
        return list;
    }

   	public T findOne() throws IOException, RetslyException {
		this.limit(0);
		JSONArray list = this.executeListQuery();
		if(list.length() > 0) return createResource(list.getJSONObject(0));
		return null;
	}
   	
	public T findById(String id) throws IOException, RetslyException {
        JSONObject jsonObj = this.executeSingleQuery(id);
        return createResource(jsonObj);   
	}
	
	 public void findAllAysnc(final RetslyListCallback cb) throws Exception {
		if(retsly.async == null) throw new Exception("No Async set"); 
		final Query<T> self = this;
		retsly.async.excuteList(new AsyncListInvoke<T>() {
			@Override
			public List<T> runList() throws Exception {
				return self.findAll();			
			}
		},cb);
    }
	 
   	public void findOneAsync(final RetslyCallback cb) throws Exception {
		this.limit(0);
		if(retsly.async == null) throw new Exception("No Async set"); 
		final Query<T> self = this;
		retsly.async.excute(new AsyncInvoke() {
			@Override
			public Resource run() throws Exception {
				return (Resource) self.findOne();			
			}
		},cb);
		
	}
   	
	public void findByIdAsync(String id, final RetslyCallback<T> cb) throws Exception {

		if(retsly.async == null) throw new Exception("No Async set"); 
		final Query<T> self = this;
		retsly.async.excute(new AsyncInvoke() {
			@Override
			public T run() throws Exception {
				T returnVal = self.findOne();
				return returnVal;	
			}
		},cb);
	}
}

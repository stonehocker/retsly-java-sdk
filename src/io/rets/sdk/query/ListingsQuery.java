package io.rets.sdk.query;

import io.rets.sdk.RetslyClient;
import io.rets.sdk.resources.Listing;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;


/**
 * Created by matthewsa on 4/28/15.
 */
public class ListingsQuery extends Query<Listing> {

    private static String NEAR_ARGUMENT = "near";

    public ListingsQuery(RetslyClient client){
        super(client);
        this.resource = "listing";
    }
    
    public Query<Listing> near(String address){
        this.arguments.add(new BasicNameValuePair(NEAR_ARGUMENT,address));
        return this;
    }

    public Query<Listing> near(double longitude, double latitude ){
    	String latLong = Double.toString(longitude)+","+Double.toString(latitude);
        this.arguments.add(new BasicNameValuePair(NEAR_ARGUMENT,latLong));
        return this;
    }

    @Override 
    protected Listing createResource(JSONObject json){
    	return new Listing(json);
    }
}

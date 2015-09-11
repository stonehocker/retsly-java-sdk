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
    private static String RADIUS_ARGUMENT = "radius";

    public ListingsQuery(RetslyClient client){
        super(client);
        this.resource = "listings";
    }
    
    public Query<Listing> near(String address){
        this.arguments.add(new BasicNameValuePair(NEAR_ARGUMENT,address));
        return this;
    }
    public Query<Listing> radius(int radius){
        this.arguments.add(new BasicNameValuePair(RADIUS_ARGUMENT,Integer.toString(radius)));
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
    public Query<Listing> where(Listing.ListingProperty listingProrp, Query.Operators op, double value){
    	this.where(listingProrp.toString(),op,Double.toString(value));
    	return this;
    }
    public Query<Listing> where(Listing.ListingProperty listingProrp, Query.Operators op, int value){
    	this.where(listingProrp.toString(),op,Integer.toString(value));
    	return this;
    }
    public Query<Listing> where(Listing.ListingProperty listingProrp, Query.Operators op, String value){
    	this.where(listingProrp.toString(),op,value);
    	return this;
    }
}

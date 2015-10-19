package io.rets.sdk.query;

import io.rets.sdk.RetslyClient;
import io.rets.sdk.resources.Listing;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;


/**
 * Created by matthewsa on 4/28/15.
 */
public class ListingsQuery extends GeoQuery<Listing> {

    public ListingsQuery(RetslyClient client){
        super(client);
        this.resource = "listing";
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

package io.rets.sdk.query;

import io.rets.sdk.RetslyClient;
import io.rets.sdk.resources.Listing;

import org.json.JSONObject;


/**
 * Created by matthewsa on 4/28/15.
 */
public class ListingsQuery extends GeoQuery<Listing> {

    public ListingsQuery(RetslyClient client){
        super(client);
        this.resource = "listings";
    }

    @Override 
    protected Listing createResource(JSONObject json){
    	return new Listing(json);
    }
    public ListingsQuery where(Listing.ListingProperty listingProrp, Query.Operators op, double value){
    	this.where(listingProrp.toString(),op,Double.toString(value));
    	return this;
    }
    public ListingsQuery where(Listing.ListingProperty listingProrp, Query.Operators op, int value){
    	this.where(listingProrp.toString(),op,Integer.toString(value));
    	return this;
    }
    public ListingsQuery where(Listing.ListingProperty listingProrp, Query.Operators op, String value){
    	this.where(listingProrp.toString(),op,value);
    	return this;
    }
}

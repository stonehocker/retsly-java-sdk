package io.rets.sdk.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import io.rets.sdk.RetslyClient;
import io.rets.sdk.query.Query.Operators;
import io.rets.sdk.resources.Listing;
import io.rets.sdk.resources.Listing.ListingProperty;

import org.apache.http.HttpException;
import org.json.JSONException;
import org.junit.Test;

public class ListingsTest {
   RetslyClient retsly = new RetslyClient("758a506ca74740f7d2b265597114e0d2");

   @Test
	public void BasicListingsQuery() throws JSONException, IOException, HttpException {
       List<Listing> listings = retsly
    		.listings()
            .findAll();
       
       assertTrue("Returns listings", !listings.isEmpty());

       for(Listing l : listings){
           assertTrue("has price", l.getPrice() > 0);
       }
    }	
	@Test
	public void SingleListingQuery() throws JSONException, IOException, HttpException {
       Listing listing = retsly
    		.listings()
            .findOne();
       assertTrue("Returns listing price", listing.getPrice()  > 0);
       assertTrue("Returns listing id", listing.getId().length() > 20);
   }	
	
	@Test
	public void SingleListingByIDQuery() throws JSONException, IOException, HttpException {
		Listing listing1 = retsly
	    		.listings()
	            .findOne();
       Listing listing2 = retsly
    		.listings()
            .findById(listing1.getId());
       
       assertTrue("Returns listing price", listing2.getPrice()  > 0);
       assertTrue("Returns listing id", listing2.getId().length() > 20);
       assertTrue("listings equal", listing2.equals(listing1));
   }	
	
	@Test
	public void WhereListing() throws JSONException, IOException, HttpException {
		List<Listing> listings = retsly
	    		.listings()
	    		.where(ListingProperty.price, Operators.gt, 500000)
	            .findAll();
           
       for(Listing l : listings){
    	   assertTrue("All listings greater than query amount", l.getPrice() > 500000 );
       }
	}
	
	@Test
	public void NearListing() throws JSONException, IOException, HttpException {
		List<Listing> listings = retsly
	    		.listings()
	    		.near("San Francisco")
	            .findAll();
           
       for(Listing l : listings){
    	   //assertTrue("All listings greater than query amount", l.getPrice() > 500000 );
       }
	}

}

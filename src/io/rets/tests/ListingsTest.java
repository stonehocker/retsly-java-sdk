package io.rets.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import io.rets.RetslyClient;
import io.rets.resources.Listing;

import org.apache.http.HttpException;
import org.json.JSONException;
import org.junit.Test;

public class ListingsTest {
   RetslyClient retsly = new RetslyClient("9d569d82909f34a4fb8894ff91f07b52");

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

}

package io.rets.sdk.tests;

import static org.junit.Assert.assertTrue;
import io.rets.sdk.RetslyClient;
import io.rets.sdk.exception.RetslyException;
import io.rets.sdk.query.ListingsQuery;
import io.rets.sdk.query.Query;
import io.rets.sdk.query.Query.Operators;
import io.rets.sdk.resources.Listing;
import io.rets.sdk.resources.Listing.ListingProperty;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class ListingsTest {
   RetslyClient retsly = new RetslyClient(RetslyTest.VALID_AUTH_TOKEN);

   @Test
	public void BasicListingsQuery() throws  IOException, RetslyException {
       List<Listing> listings = retsly
    		.listings()
            .findAll();
       
       assertTrue("Returns listings", !listings.isEmpty());

       for(Listing l : listings){
           assertTrue("has price", l.getPrice() > 0);
       }
    }	
   
	@Test
	public void SingleListingQuery() throws  IOException, RetslyException {
       Listing listing = retsly
    		.listings()
            .findOne();
       assertTrue("Returns listing price", listing.getPrice()  > 0);
       assertTrue("Returns listing id", listing.getId().length() > 20);
   }	
	
	@Test
	public void SingleListingByIDQuery() throws  IOException, RetslyException {
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
	public void WhereListing() throws  IOException, RetslyException {
		List<Listing> listings = retsly
	    		.listings()
	    		.where(ListingProperty.price, Operators.gt, 500000)
	            .findAll();
           
       for(Listing l : listings){
    	   assertTrue("All listings greater than query amount", l.getPrice() > 500000 );
       }
	}
	
	@Test
	public void NearListing() throws IOException, RetslyException {
		List<Listing> listings = retsly
	    		.listings()
	    		.near("San Francisco")
	            .findAll();
           
       for(Listing l : listings){
    	   assertTrue("All listings greater than query amount", l.getState().equals("CA"));
       }
	}
	@Test
	public void BasicListingsWithVendorQuery() throws  IOException, RetslyException {
       List<Listing> listings = retsly.vendor("test_sd")
    		.listings()
            .findAll();
       
       assertTrue("Returns listings", !listings.isEmpty());
       for(Listing l : listings){
           assertTrue("is sandiego?", l.getCity().equals("San Diego"));
       }
    }	

	@Test
	public void ListingsNextQuery() throws  IOException, RetslyException {
      ListingsQuery listingQuery = retsly
    		.listings()
    		.where(ListingProperty.price, Operators.gt, 500000);
      
      List<Listing> listings = listingQuery.findAll();
       
       Listing first = listings.get(0);
       for(Listing l : listings){
           assertTrue("has price", l.getPrice() > 0);
       }
       
       listings = listingQuery.next().findAll();
       assertTrue("List first don't equal", !first.equals(listings.get(0)));

       for(Listing l : listings){
           assertTrue("has price", l.getPrice() > 0);
       }
    }	
	
	@Test
	public void ListingsPrevQuery() throws  IOException, RetslyException {
      Query<Listing> listingQuery = retsly
    		.listings()
    		.offset(10)
    		.limit(20);
      List<Listing> listings = listingQuery.findAll();
       
       Listing first = listings.get(0);
       listings = listingQuery.prev().findAll();
       assertTrue("List first don't equal", !first.equals(listings.get(0)));
    }
	
	@Test
	public void ListingsSortQuery() throws  IOException, RetslyException {
		Query<Listing> listingQuery = retsly
    		.listings()
    		.sort(ListingProperty.price.toString())
    		.order(true);
      
       List<Listing> listings = listingQuery.findAll();
       double lastPrice = 0.0;
       for(Listing l : listings){
           assertTrue("has price", l.getPrice() > lastPrice);
           lastPrice = l.getPrice();
       }
     
    }	
	
   @Test
	public void StringWhereListingsQuery() throws  IOException, RetslyException {
       List<Listing> listings = retsly
    		.listings()
    		.where("price.lt=100000;status=Active")
            .findAll();
       
       assertTrue("Returns listings", !listings.isEmpty());

       for(Listing l : listings){
           assertTrue("has price", l.getPrice() < 100000);
           assertTrue("active status", l.getStatus().equals("Active"));

       }
    }	
}

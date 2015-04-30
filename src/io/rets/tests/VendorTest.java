package io.rets.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import io.rets.RetslyClient;
import io.rets.resources.Vendor;

import org.apache.http.HttpException;
import org.json.JSONException;
import org.junit.Test;

public class VendorTest {
   RetslyClient retsly = new RetslyClient("9d569d82909f34a4fb8894ff91f07b52");

	@Test
	public void BasicListingQuery() throws JSONException, IOException, HttpException {
           java.util.List<Vendor> vendors = retsly
	    		.vendors()
	            .findAll();
           
           assertTrue("Returns vendors", !vendors.isEmpty());
       }	

}

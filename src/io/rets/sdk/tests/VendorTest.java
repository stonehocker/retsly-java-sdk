package io.rets.sdk.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import io.rets.sdk.RetslyClient;
import io.rets.sdk.exception.RetslyException;
import io.rets.sdk.resources.Vendor;

import org.junit.Test;

public class VendorTest {
   RetslyClient retsly = new RetslyClient(RetslyTest.VALID_AUTH_TOKEN);

	@Test
	public void BasicListingQuery() throws IOException, RetslyException {
           java.util.List<Vendor> vendors = retsly
	    		.vendors()
	            .findAll();
           
           assertTrue("Returns vendors", !vendors.isEmpty());
       }	

}

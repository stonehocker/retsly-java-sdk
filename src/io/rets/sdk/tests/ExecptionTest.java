package io.rets.sdk.tests;

import static org.junit.Assert.assertTrue;
import io.rets.sdk.RetslyClient;
import io.rets.sdk.exception.RetslyException;
import io.rets.sdk.resources.Listing;

import java.io.IOException;

import org.junit.Test;

public class ExecptionTest {

	@Test
	public void AuthExectpionQuery() throws IOException, RetslyException {
		RetslyClient retsly = new RetslyClient("123456789123456789");

		RetslyException exceptedException  = null;
		try{
		  retsly
		  .listings()
			.findAll();
			}
		catch(RetslyException e){
		exceptedException = e;
		}
		System.out.println(exceptedException.getMessage());
		assertTrue("Execption caught", exceptedException!=null);
		assertTrue("Execption name found", exceptedException.getMessage().contains("AuthorizationError"));
		assertTrue("Execption message found", exceptedException.getMessage().contains("Invalid Access Token"));
	}	
	
	@Test
	public void InvalidVendorQuery() throws IOException, RetslyException {
	   RetslyClient retsly = new RetslyClient(RetslyTest.VALID_AUTH_TOKEN);

		RetslyException exceptedException  = null;
		try{
		  retsly
		  .listings()
		  .vendor("vendor_nonexistant")
			.findAll();
			}
		catch(RetslyException e){
		exceptedException = e;
		}
		System.out.println(exceptedException.getMessage());
		assertTrue("Execption caught", exceptedException!=null);
		assertTrue("Execption name found", exceptedException.getMessage().contains("InvalidVendor"));
		assertTrue("Execption message found", exceptedException.getMessage().contains("not exist") && exceptedException.getMessage().contains("vendor"));
	}	

}

package io.rets.sdk.tests;

import static org.junit.Assert.assertTrue;
import io.rets.sdk.RetslyClient;
import io.rets.sdk.exception.RetslyException;
import io.rets.sdk.query.Query.Operators;
import io.rets.sdk.resources.Office;
import io.rets.sdk.resources.Office.OfficeProperties;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class OfficesTest {
   RetslyClient retsly = new RetslyClient(RetslyTest.VALID_AUTH_TOKEN);

   @Test
	public void BasicOfficesQuery() throws  IOException, RetslyException {
       List<Office> offices = retsly
    		.offices()
            .findAll();
       
       assertTrue("Returns offices", !offices.isEmpty());

       for(Office l : offices){
           assertTrue("has address", l.getAddress().length() > 0);
       }
    }	
	@Test
	public void SingleOfficeQuery() throws  IOException, RetslyException {
		Office office = retsly
    		.offices()
            .findOne();
       assertTrue("Returns office address", office.getAddress().length()  > 0);
       assertTrue("Returns office id", office.getId().length() > 20);
   }	
	
	@Test
	public void SingleOfficeByIDQuery() throws  IOException, RetslyException {
		Office office1 = retsly
	    		.offices()
	            .findOne();
		Office office2 = retsly
    		.offices()
            .findById(office1.getId());
       
       assertTrue("Returns office full name", office2.getAddress().length()  > 0);
       assertTrue("Returns office id", office2.getId().length() > 20);
       assertTrue("offices equal", office2.equals(office1));
   }	
	
	@Test
	public void WhereOffices() throws  IOException, RetslyException {
		List<Office> offices = retsly
	    		.offices()
	    		.where(OfficeProperties.city, Operators.eq, "San Francisco")
	            .findAll();
           
    for(Office l : offices){
    	   assertTrue("All offices eq sanfran", l.getCity().equals("San Francisco") );
       }
	}
}

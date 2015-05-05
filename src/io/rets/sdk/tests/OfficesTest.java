package io.rets.sdk.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import io.rets.sdk.RetslyClient;
import io.rets.sdk.query.Query.Operators;
import io.rets.sdk.resources.Office;
import io.rets.sdk.resources.Office.OfficeProperties;

import org.apache.http.HttpException;
import org.json.JSONException;
import org.junit.Test;

public class OfficesTest {
   RetslyClient retsly = new RetslyClient("758a506ca74740f7d2b265597114e0d2");

   @Test
	public void BasicOfficesQuery() throws JSONException, IOException, HttpException {
       List<Office> offices = retsly
    		.offices()
            .findAll();
       
       assertTrue("Returns offices", !offices.isEmpty());

       for(Office l : offices){
           assertTrue("has address", l.getAddress().length() > 0);
       }
    }	
	@Test
	public void SingleOfficeQuery() throws JSONException, IOException, HttpException {
		Office office = retsly
    		.offices()
            .findOne();
       assertTrue("Returns office address", office.getAddress().length()  > 0);
       assertTrue("Returns office id", office.getId().length() > 20);
   }	
	
	@Test
	public void SingleOfficeByIDQuery() throws JSONException, IOException, HttpException {
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
	public void WhereOffices() throws JSONException, IOException, HttpException {
		List<Office> offices = retsly
	    		.offices()
	    		.where(OfficeProperties.city, Operators.eq, "San Francisco")
	            .findAll();
           
    //for(Office l : offices){
    //	   assertTrue("All offices greater than query amount", l.getPrice() > 500000 );
    //   }
	}
}

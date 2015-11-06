package io.rets.sdk.tests;

import static org.junit.Assert.assertTrue;
import io.rets.sdk.RetslyClient;
import io.rets.sdk.exception.RetslyException;
import io.rets.sdk.query.Query.Operators;
import io.rets.sdk.resources.pub.Address;
import io.rets.sdk.resources.pub.Assessment;
import io.rets.sdk.resources.pub.Assessment.AssessmentProperties;
import io.rets.sdk.resources.pub.Building.BuildingProperties;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class AssessmentsTest {
   RetslyClient retsly = new RetslyClient(RetslyTest.VALID_AUTH_TOKEN, "pub");

   
   @Test
	public void BasicAssessmentsQuery() throws IOException, RetslyException {
       List<Assessment> assessments = retsly
    		.assessments()
            .findAll();
       
       assertTrue("Returns assessments", !assessments.isEmpty());

       for(Assessment l : assessments){
           assertTrue("has name", l.getAPN().length() > 0);
       }
    }	
	
   @Test
  	public void AssessmentsQuery() throws IOException, RetslyException {
         List<Assessment> assessments = retsly
      		.assessments()
      		.where(AssessmentProperties.landValue, Operators.gt , 100)
              .findAll();
         
         assertTrue("Returns assessments", !assessments.isEmpty());

         for(Assessment l : assessments){
             assertTrue("has name", l.getLandValue() > 100);
         }
      }	
   
   @Test
  	public void AssessmentsBuildingQuery() throws IOException, RetslyException {
         List<Assessment> assessments = retsly
      		.assessments()
      		.where(BuildingProperties.baths, Operators.gt , 2)
              .findAll();
         
         assertTrue("Returns assessments", !assessments.isEmpty());

         for(Assessment l : assessments){
             assertTrue("baths gt 2", l.getBuilding().getBaths() > 2);
         }
      }	
   
   @Test
  	public void AssessmentsAddressQuery() throws IOException, RetslyException {
         List<Assessment> assessments = retsly
      		.assessments()
      		.where(Address.AddressProperties.city, Operators.eq , "San Francisco")
              .findAll();
         
         assertTrue("Returns assessments", !assessments.isEmpty());
         
         for(Assessment l : assessments){
             assertTrue("address city is sanfran", l.getAddress().getCity().toLowerCase().equals("san francisco"));
         }
      }	


	@Test
	public void NearListing() throws IOException, RetslyException {
		List<Assessment> assessments = retsly
	    		.assessments()
	    		.near(-122.0, 37.0)
	    		.radius(100)//switch when I upate 
	            .findAll();
		assertTrue("Returns assessments", !assessments.isEmpty());
     
	}
}

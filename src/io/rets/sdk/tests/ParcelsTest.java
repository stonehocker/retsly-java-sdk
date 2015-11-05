package io.rets.sdk.tests;

import static org.junit.Assert.assertTrue;
import io.rets.sdk.RetslyClient;
import io.rets.sdk.exception.RetslyException;
import io.rets.sdk.query.Query.Operators;
import io.rets.sdk.resources.pub.Address;
import io.rets.sdk.resources.pub.Building.BuildingProperties;
import io.rets.sdk.resources.pub.Parcel;
import io.rets.sdk.resources.pub.Parcel.ParcelsProperties;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class ParcelsTest {
   RetslyClient retsly = new RetslyClient(RetslyTest.VALID_AUTH_TOKEN, "pub");

   
   @Test
	public void BasicParcelsQuery() throws IOException, RetslyException {
       List<Parcel> parcels = retsly
    		.parcels()
            .findAll();
       
       assertTrue("Returns parcels", !parcels.isEmpty());

       for(Parcel l : parcels){
           assertTrue("has name", l.getFips().length() > 0);
       }
    }	
	
   @Test
  	public void ParcelsQuery() throws IOException, RetslyException {
         List<Parcel> parcels = retsly
      		.parcels()
      		.where(ParcelsProperties.lotSizeAcres, Operators.gt , 1000)
              .findAll();
         
         assertTrue("Returns parcels", !parcels.isEmpty());

         for(Parcel l : parcels){
             assertTrue("has name", l.getLotSizeAcres() > 1000);
         }
      }	
   
   @Test
  	public void ParcelsBuildingQuery() throws IOException, RetslyException {
         List<Parcel> parcels = retsly
      		.parcels()
      		.where(BuildingProperties.baths, Operators.gt , 2)
              .findAll();
         
         assertTrue("Returns parcels", !parcels.isEmpty());

         for(Parcel l : parcels){
             assertTrue("baths gt 2", l.getBuilding().getBaths() > 2);
         }
      }	
   
   @Test
  	public void ParcelsAddressQuery() throws IOException, RetslyException {
         List<Parcel> parcels = retsly
      		.parcels()
      		.where(Address.AddressProperties.full, Operators.eq , "north ST")
              .findAll();
         
         assertTrue("Returns parcels", !parcels.isEmpty());
         
         for(Parcel l : parcels){
             assertTrue("address suffix", l.getAddress().getStreetSuffix().toLowerCase().equals("st"));
             assertTrue("address pre", l.getAddress().getStreetPre().toLowerCase().equals("n"));
         }
      }	


	@Test
	public void NearListing() throws IOException, RetslyException {
        List<Parcel> parcels = retsly
     		.parcels()
    		.near(37.0,-122.0)
    		.radius(100)//switch when I upate 
            .findAll();
		assertTrue("Returns parcels", !parcels.isEmpty());
     
	}
}

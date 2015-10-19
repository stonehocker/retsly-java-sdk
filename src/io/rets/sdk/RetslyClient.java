package io.rets.sdk;

import io.rets.sdk.async.Async;
import io.rets.sdk.query.AgentsQuery;
import io.rets.sdk.query.ListingsQuery;
import io.rets.sdk.query.OfficeQuery;
import io.rets.sdk.query.VendorQuery;
import io.rets.sdk.query.pub.AssessmentsQuery;
import io.rets.sdk.query.pub.ParcelsQuery;


public class RetslyClient {

    public static String RESTLY_URL = "https://rets.io/api/v1/";
    private String vendorID = "test_sf";
    private String oauthToken;
    public Async async;
    
/*
 * Get my Application and My vendors
 */
    public RetslyClient(String token){
    	this.oauthToken = token;
    }    
    
    public RetslyClient(String token, String vendor) {
    	this.oauthToken = token;
    	//I want to get MY vendors dynamically
    	this.setVendor(vendor);
    	 
    }
    
    public void setAsync(Async async){
    	this.async = async;
    }
    
    public void setVendor(String vendor){
    	this.vendorID = vendor;
    }
    public String getVendor(){
    	return vendorID;
    }
    
    public RetslyClient vendor(String vendor){
    	this.setVendor(vendor);
    	return this;
    }
    
    public String getToken(){
    	return oauthToken;
    }
    
    public ListingsQuery listings(){
    	return new ListingsQuery(this);
    }
    
    public AgentsQuery agents(){
    	return new AgentsQuery(this);
    }
    
    public OfficeQuery offices(){
    	return new OfficeQuery(this);
    }
    
    public VendorQuery vendors(){
    	return new VendorQuery(this);
    }
    
    public AssessmentsQuery assessments(){
    	return new AssessmentsQuery(this);
    }
    
    public ParcelsQuery parcels(){
    	return new ParcelsQuery(this);
    }
}

package io.rets;


public class RetslyClient {

    public static String RESTLY_URL = "https://dev.rets.io/api/v1/";
    private String vendorID = "test_sf";
    private String oauthToken;
    
    public RetslyClient(String token){
    	this.oauthToken = token;
    }
    public void setVendor(String vendor){
    	this.vendorID = vendor;
    }
    public String getVendor(){
    	return vendorID;
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
}

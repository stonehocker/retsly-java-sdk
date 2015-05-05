package io.rets.sdk.resources;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Vendor extends Resource {

    private double centerLatitude;
    private double centerLongitude;

    public Vendor(JSONObject o) {
    	super(o);
    	try {
             JSONArray center = json.getJSONArray("center");
             centerLongitude = center.getDouble(0);
             centerLatitude = center.getDouble(1);
        } catch (JSONException e){
        }
	}

    public double getCenterLatitude(){
        return centerLatitude;
    }
    
    public double getCenterLongitude(){
        return centerLongitude;
    }
    
    public String getName(){
        return getString("name");
    }
    
    public String getVendorID(){
        return getString("vendorID");
    }
    
    
}

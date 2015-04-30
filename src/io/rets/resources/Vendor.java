package io.rets.resources;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Vendor extends Resource {

    private double centerLatitude;
    private double centerLongitude;
    
    public Vendor(JSONObject o) {
        super(o);
    	try {
             JSONArray center = o.getJSONArray("center");
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

}

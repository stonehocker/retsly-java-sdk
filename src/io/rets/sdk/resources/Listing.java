package io.rets.sdk.resources;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

/**
 * Created by matthewsa on 4/23/15.
 */
public class Listing extends MediaResource{
    private double latitue;
    private double longitude;
    
    public Listing(JSONObject o) {
        super(o);
    	try {
            JSONArray center = json.getJSONArray("coordinates");
            longitude = center.getDouble(0);
            latitue = center.getDouble(1);
       } catch (JSONException e){
       }
        
    }
    public String getAddress(){
        return getString("address");
    }
    public int getYearBuilt(){
        return getInteger("yearBuilt");
    }
    public int getBeds(){
        return getInteger("bedrooms");
    }
    public int getBaths(){
        return getInteger("halfBaths");
    }
    public String getAgentID(){
        return getString("agentID");
    }
    public double getPrice(){
        return getDouble("price");
    }
    public String getFormatedPrice(){
    	DecimalFormat formatter = new DecimalFormat("#,###.00");
    	return formatter.format(getPrice());
    }
  
    public String getJSON(){
        return json.toString();
    }
    public double getLatitude(){
        return latitue;
    }
    public double getLongitude(){
        return longitude;
    }

}

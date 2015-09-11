package io.rets.sdk.resources;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by matthewsa on 4/23/15.
 */
public class Resource {
    protected JSONObject json;
  
    public Resource(JSONObject o) {
        this(o.toString());
    }

    public Resource(String json){
        try {
            this.json = new JSONObject(json);
        } catch (JSONException e){
        }
    }
    public String getId(){
    	return getString("id");
    }
    protected String getString(String str){
        try{
            return json.getString(str);
        }
        catch (JSONException e){
            return "";
        }
    }
    protected int getInteger(String str){
        try{
            return json.getInt(str);
        }
        catch (JSONException e){
            return -1;
        }
    }
    protected double getDouble(String str){
        try{
            return json.getDouble(str);
        }
        catch (JSONException e){
            return -1;
        }
    }
    
    protected Date getDate(String str){
        String dateString = getString(str);
        return new Date(dateString);
    }
    
    protected boolean getBoolean(String str){
    	 try{
             return json.getBoolean(str);
         }
         catch (JSONException e){
             return false;
         }
    }
    
    public String getJSON(){
        return json.toString();
    }
    @Override
    public boolean equals(Object obj){
    	if(obj instanceof Resource){
    		return this.getId().length() > 0 && ((Resource)obj).getId().equals(this.getId());
    	}
    	return false;
    }
}

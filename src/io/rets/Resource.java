package io.rets;

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

    protected String getString(String str){
        try{
            return json.getString(str);
        }
        catch (JSONException e){
            return null;
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
    public String getJSON(){
        return json.toString();
    }
}

package io.rets.resources;

import org.json.JSONObject;

/**
 * Created by matthewsa on 4/24/15.
 */
public class Office extends Resource{

    public Office(JSONObject o) {
		super(o);
	}
    public String getName(){
        return getString("name");
    }
    public String getAddress(){
        return getString("address");
    }
    public String getEmail(){
        return getString("email");
    }
    public String getPhone(){
        String phone = getString("phone");
        return phone;
    }

}

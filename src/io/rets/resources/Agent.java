package io.rets.resources;

import org.json.JSONObject;

/**
 * Created by matthewsa on 4/24/15.
 */
public class Agent extends MediaResource{

    public Agent(JSONObject o) {
		super(o);
	}

    public String getFullName(){
        return getString("fullName");
    }
    public String getOfficeName(){
        return getString("officeName");
    }
    public String getEmail(){
        return getString("email");
    }
    public String getPhone(){
        String phone = getString("cellPhone");
        return phone;
    }

}

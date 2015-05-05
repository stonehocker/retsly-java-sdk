package io.rets.sdk.resources;

import org.json.JSONObject;

/**
 * Created by matthewsa on 4/24/15.
 */
public class Office extends Resource{

	public enum OfficeProperties {
		officeID,type,address,city,fax,email,name,phone,state,zipCode
	}
	
    public Office(JSONObject o) {
		super(o);
	}
    public String getOfficeID(){
    	return getString(OfficeProperties.officeID.toString());
    }
    public String getType(){
    	return getString(OfficeProperties.type.toString());
    }
    public String getAddress(){
    	return getString(OfficeProperties.address.toString());
    }
    public String getCity(){
    	return getString(OfficeProperties.city.toString());
    }
    public String getFax(){
    	return getString(OfficeProperties.fax.toString());
    }
    public String getEmail(){
    	return getString(OfficeProperties.email.toString());
    }
    public String getName(){
    	return getString(OfficeProperties.name.toString());
    }
    public String getPhone(){
    	return getString(OfficeProperties.phone.toString());
    }
    public String getState(){
    	return getString(OfficeProperties.state.toString());
    }
    public String getZipCode(){
    	return getString(OfficeProperties.zipCode.toString());
    }
}

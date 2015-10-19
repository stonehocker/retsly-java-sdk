package io.rets.sdk.resources.pub;

import io.rets.sdk.resources.Resource;

import org.json.JSONObject;

public class Address extends Resource{


	public enum AddressProperties {
		full, city, house, houseExt,
		state, street, streetPost, streetPre, streetSuffix,
		unit, unitType, zip, zip4
	}
	

	public static String BASE_PROPERTY = "address"; 
	
    public Address(JSONObject o) {
		super(o);
	}
    public String getFull(){
    	return getString(AddressProperties.full.toString());
    }
    public String getCity(){
    	return getString(AddressProperties.city.toString());
    }
    public String getHoused(){
    	return getString(AddressProperties.house.toString());
    }
    public String getHouseExt(){
    	return getString(AddressProperties.houseExt.toString());
    }
    public String getState(){
    	return getString(AddressProperties.state.toString());
    }
    public String getStreet(){
    	return getString(AddressProperties.street.toString());
    }
    public String getStreetPost(){
    	return getString(AddressProperties.streetPost.toString());
    }
    public String getStreetPre(){
    	return getString(AddressProperties.streetPre.toString());
    }
    public String getStreetSuffix(){
    	return getString(AddressProperties.streetSuffix.toString());
    }
    public String getUnit(){
    	return getString(AddressProperties.unit.toString());
    }
    public String getUnitType(){
    	return getString(AddressProperties.unitType.toString());
    }
    public String getZip(){
    	return getString(AddressProperties.zip.toString());
    }
    public String getZip4(){
    	return getString(AddressProperties.zip4.toString());
    }
	
}

package io.rets.sdk.resources;

import java.text.DecimalFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by matthewsa on 4/23/15.
 */
public class Listing extends MediaResource{
    private double latitue;
    private double longitude;
    
    public enum ListingProperty {
    	agentID,officeID,listingID,address,city,state,county,country,
    	zipCode,coordinates,listDate,lastModified,price,yearBuilt,acres,
    	squareFootage,livingArea,stories,subdivision,baths,bedrooms,fireplaces,
    	garageSpaces,halfBaths,pool,status,type,subtype,publicRemarks
    }
    
    public Listing(JSONObject o) {
        super(o);
    	try {
            JSONArray center = json.getJSONArray("coordinates");
            longitude = center.getDouble(0);
            latitue = center.getDouble(1);
       } catch (JSONException e){
       } 
    }
    
	public String getAgentID(){
	    return getString(ListingProperty.agentID.toString());
	}
	public String getOfficeID(){
	    return getString(ListingProperty.officeID.toString());
	}
	public String getListingID(){
	    return getString(ListingProperty.listingID.toString());
	}
	public String getCity(){
	    return getString(ListingProperty.city.toString());
	}
	public String getState(){
		 return getString(ListingProperty.state.toString());
	}
	public String getCounty(){
		 return getString(ListingProperty.county.toString());
	}
	public String getCountry(){
		 return getString(ListingProperty.country.toString());
	}
	public String getAddress(){
		 return getString(ListingProperty.address.toString());
	}
	public String getZipCode(){
		 return getString(ListingProperty.zipCode.toString());
	}
	public Date getListDate(){
		 return getDate(ListingProperty.listDate.toString());
	}
	public Date getLastModified(){
		 return getDate(ListingProperty.lastModified.toString());
	}
	public double getPrice(){
		return getDouble(ListingProperty.price.toString());
	}
	public int getYearBuilt(){
		return getInteger(ListingProperty.yearBuilt.toString());
	}
	public int getAcres(){
		 return getInteger(ListingProperty.acres.toString());
	}
	public int getSquareFootage(){
		 return getInteger(ListingProperty.squareFootage.toString());
	}
	public int getLivingArea(){
		 return getInteger(ListingProperty.livingArea.toString());
	}
	public int getStories(){
		 return getInteger(ListingProperty.stories.toString());
	}
	public String getSubdivision(){
		 return getString(ListingProperty.subdivision.toString());
	}
	public int getBaths(){
	 return getInteger(ListingProperty.halfBaths.toString());
	}
	public Integer getBedrooms(){
		 return getInteger(ListingProperty.bedrooms.toString());
	}
	public int getFireplaces(){
		 return getInteger(ListingProperty.fireplaces.toString());
	}
	public int getGarageSpaces(){
		 return getInteger(ListingProperty.garageSpaces.toString());
	}
	public boolean getPool(){
		 return getBoolean(ListingProperty.pool.toString());
	}
	public String getStatus(){
		 return getString(ListingProperty.status.toString());
	}
	public String getType(){
		 return getString(ListingProperty.type.toString());
	}
	public String getSubtype(){
		 return getString(ListingProperty.subtype.toString());
	}
	public String getPublicRemarks(){
		 return getString(ListingProperty.publicRemarks.toString());
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
	public String getLatLngString(){
		 return getLatitude() + "," + getLongitude();
	}

}

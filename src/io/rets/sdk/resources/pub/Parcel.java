package io.rets.sdk.resources.pub;

import io.rets.sdk.resources.MediaResource;
import io.rets.sdk.resources.Resource;

import org.json.JSONObject;

/**
 * Created by matthewsa on 4/24/15.
 */
public class Parcel extends Resource{

    //TODO Get owner, get coordinates
	public enum ParcelsProperties{
		id,apn,fips,county,state,
		landUseGeneral, landUseCode, landUseDescription,
		zoningCode, zoningDescription, numberOfBuildings,
		lotSizeAcres, lotSizeSquareFeet, lotSizeFrontage, lotSizeDepth,
		//ownerName, coordinates,
		//building, address
	}
	
    //TODO add nonsearchable props
	public enum NonSearchableParcelsPropertiess{
		lotSizeIrregular, lotTopography, legal
	}

	protected Building building;
	
    public Parcel(JSONObject o) {
		super(o);
		this.building = getBuilding();
	}
 
    public String getID(){
    	return getString(ParcelsProperties.id.toString());
    }
    public String getAPN(){
    	return getString(ParcelsProperties.apn.toString());
    }
    public String getFips(){
    	return getString(ParcelsProperties.fips.toString());
    }
    public String getCounty(){
    	return getString(ParcelsProperties.county.toString());
    }
    public String getState(){
    	return getString(ParcelsProperties.state.toString());
    }
    
    public String getLandUseGeneral(){
    	return getString(ParcelsProperties.landUseGeneral.toString());
    }
    public String getLandUseDescription(){
    	return getString(ParcelsProperties.landUseDescription.toString());
    }
    public String getLandUseCode(){
    	return getString(ParcelsProperties.landUseCode.toString());
    }
    
    public String getZoningCode(){
    	return getString(ParcelsProperties.zoningCode.toString());
    }
    public String getZoningDescription(){
    	return getString(ParcelsProperties.zoningDescription.toString());
    }
    public int getNumberOfBuildings(){
    	return getInteger(ParcelsProperties.numberOfBuildings.toString());
    }
    
    public double getLotSizeAcres(){
    	return getInteger(ParcelsProperties.lotSizeAcres.toString());
    }
    public double getLotSizeSquareFeet(){
    	return getDouble(ParcelsProperties.lotSizeSquareFeet.toString());
    }
    public double getLotSizeFrontage(){
    	return getDouble(ParcelsProperties.lotSizeFrontage.toString());
    }
    public double getLotSizeDepth(){
    	return getDouble(ParcelsProperties.lotSizeDepth.toString());
    }
    
    
    public Building getBuilding(){
    	return new Building(getObject("building"));
    }
   
    public Address getAddress(){
    	return new Address(getObject("address"));
    }
}

package io.rets.sdk.resources.pub;

import io.rets.sdk.resources.Resource;

import org.json.JSONObject;

public class Building extends Resource{


	public enum BuildingProperties {
	  yearBuilt, effectiveYearBuilt, 
	  totalStories, bedrooms, baths
	}
	
	public enum NonSearchableBuildingProperties {
		noOfUnits, occupancyStatus, 
	    classDescription, quality, condition, classProp,
		architecturalStyle,totalRooms, kitchens,comments
	}
	
	public static String BASE_PROPERTY = "building"; 
	
    public Building(JSONObject o) {
		super(o);
	}
    public int getYearBuild(){
    	return getInteger(BuildingProperties.yearBuilt.toString());
    }
    public int getEffectiveYearBuilt(){
    	return getInteger(BuildingProperties.effectiveYearBuilt.toString());
    }
    public int getTotalStories(){
    	return getInteger(BuildingProperties.totalStories.toString());
    }
    public int getBedrooms(){
    	return getInteger(BuildingProperties.bedrooms.toString());
    }
    public int getBaths(){
    	return getInteger(BuildingProperties.baths.toString());
    }
    public int getKitchens(){
    	return getInteger(NonSearchableBuildingProperties.kitchens.toString());
    }
	
}

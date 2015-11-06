package io.rets.sdk.query;

import io.rets.sdk.RetslyClient;

public abstract class GeoQuery<T> extends Query<T> {

    private static String NEAR_ARGUMENT = "near";
    private static String RADIUS_ARGUMENT = "radius";
    private static String ADDRESS_ARGUMENT = "radius";

    public GeoQuery(RetslyClient retsly) {
		super(retsly);
	}
	public GeoQuery<T> near(String address){
        this.arguments.put(NEAR_ARGUMENT,address);
        return this;
    }
	public GeoQuery<T> address(String address){
        this.arguments.put(ADDRESS_ARGUMENT, address);
        return this;
    }
    public GeoQuery<T> radius(int radius){
        this.arguments.put(RADIUS_ARGUMENT,Integer.toString(radius));
        return this;
    }

    public GeoQuery<T> near(double latitude, double longitude){
    	String latLong = Double.toString(longitude)+","+Double.toString(latitude);
        this.arguments.put(NEAR_ARGUMENT,latLong);
        return this;
    }
}

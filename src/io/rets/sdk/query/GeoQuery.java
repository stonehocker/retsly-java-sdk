package io.rets.sdk.query;

import io.rets.sdk.RetslyClient;

import org.apache.http.message.BasicNameValuePair;

public abstract class GeoQuery<T> extends Query<T> {

    private static String NEAR_ARGUMENT = "near";
    private static String RADIUS_ARGUMENT = "radius";
    
    public GeoQuery(RetslyClient retsly) {
		super(retsly);
	}
	public GeoQuery<T> near(String address){
        this.arguments.add(new BasicNameValuePair(NEAR_ARGUMENT,address));
        return this;
    }
    public GeoQuery<T> radius(int radius){
        this.arguments.add(new BasicNameValuePair(RADIUS_ARGUMENT,Integer.toString(radius)));
        return this;
    }

    public GeoQuery<T> near(double longitude, double latitude ){
    	String latLong = Double.toString(longitude)+","+Double.toString(latitude);
        this.arguments.add(new BasicNameValuePair(NEAR_ARGUMENT,latLong));
        return this;
    }
}

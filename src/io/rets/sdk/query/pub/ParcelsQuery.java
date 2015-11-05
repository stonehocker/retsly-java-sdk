package io.rets.sdk.query.pub;

import io.rets.sdk.RetslyClient;
import io.rets.sdk.query.GeoQuery;
import io.rets.sdk.query.Query;
import io.rets.sdk.resources.pub.Address;
import io.rets.sdk.resources.pub.Building;
import io.rets.sdk.resources.pub.Parcel;

import org.json.JSONObject;

/**
 * Created by matthewsa on 4/28/15.
 */
public class ParcelsQuery extends GeoQuery<Parcel> {

    
    public ParcelsQuery(RetslyClient client){
        super(client);
        this.resource = "parcels";
    }

    @Override 
    protected Parcel createResource(JSONObject json){
    	return new Parcel(json);
    }

    
    public Query<Parcel> where(Parcel.ParcelsProperties parcelProp, Query.Operators op, String value){
    	super.where(parcelProp.toString(),op,value);
    	return this;
    }
    
    public Query<Parcel> where(Parcel.ParcelsProperties parcelProp, Query.Operators op, int value){
    	super.where(parcelProp.toString(),op,value);
    	return this;
    }
    
    public Query<Parcel> where(Building.BuildingProperties bulidingProp, Query.Operators op, String value){
    	super.where(Building.BASE_PROPERTY + '.' + bulidingProp.toString(),op,value);
    	return this;
    }
    
    public Query<Parcel> where(Building.BuildingProperties bulidingProp, Query.Operators op, int value){
    	super.where(Building.BASE_PROPERTY + '.' + bulidingProp.toString(),op,value);
    	return this;
    }
    
    public Query<Parcel> where(Address.AddressProperties adressProp, Query.Operators op, String value){
    	super.where(Address.BASE_PROPERTY + '.' + adressProp.toString(),op,value);
    	return this;
    }
}

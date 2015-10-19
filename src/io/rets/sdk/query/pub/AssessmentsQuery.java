package io.rets.sdk.query.pub;

import io.rets.sdk.RetslyClient;
import io.rets.sdk.query.GeoQuery;
import io.rets.sdk.query.Query;
import io.rets.sdk.query.Query.Operators;
import io.rets.sdk.resources.Agent;
import io.rets.sdk.resources.Listing;
import io.rets.sdk.resources.pub.Address;
import io.rets.sdk.resources.pub.Assessment;
import io.rets.sdk.resources.pub.Building;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/**
 * Created by matthewsa on 4/28/15.
 */
public class AssessmentsQuery extends GeoQuery<Assessment> {

    
    public AssessmentsQuery(RetslyClient client){
        super(client);
        this.resource = "assessments";
    }

    @Override 
    protected Assessment createResource(JSONObject json){
    	return new Assessment(json);
    }

    
    public Query<Assessment> where(Assessment.AssessmentProperties assessProp, Query.Operators op, String value){
    	super.where(assessProp.toString(),op,value);
    	return this;
    }
    
    public Query<Assessment> where(Assessment.AssessmentProperties assessProp, Query.Operators op, int value){
    	super.where(assessProp.toString(),op,value);
    	return this;
    }
    
    public Query<Assessment> where(Building.BuildingProperties bulidingProp, Query.Operators op, String value){
    	super.where(Building.BASE_PROPERTY + '.' + bulidingProp.toString(),op,value);
    	return this;
    }
    
    public Query<Assessment> where(Building.BuildingProperties bulidingProp, Query.Operators op, int value){
    	super.where(Building.BASE_PROPERTY + '.' + bulidingProp.toString(),op,value);
    	return this;
    }
    
    public Query<Assessment> where(Address.AddressProperties adressProp, Query.Operators op, String value){
    	super.where(Address.BASE_PROPERTY + '.' + adressProp.toString(),op,value);
    	return this;
    }
}

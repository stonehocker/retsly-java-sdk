package io.rets.sdk.query;

import io.rets.sdk.RetslyClient;
import io.rets.sdk.resources.Office;

import org.json.JSONObject;

/**
 * Created by matthewsa on 4/28/15.
 */
public class OfficeQuery extends Query<Office> {
	
    public OfficeQuery(RetslyClient client){
        super(client);
        this.resource = "offices";
    }

    @Override 
    protected Office createResource(JSONObject json){
    	return new Office(json);
    }
    
    public Query<Office> where(Office.OfficeProperties officeProp, Query.Operators op, String value){
    	this.where(officeProp.toString(),op,value);
    	return this;
    }
}

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
        this.resource = "office";
    }

    @Override 
    protected Office createResource(JSONObject json){
    	return new Office(json);
    }
}
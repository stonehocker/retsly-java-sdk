package io.rets;

import org.json.JSONObject;

/**
 * Created by matthewsa on 4/28/15.
 */
public class AgentsQuery extends Query<Agent> {

    public AgentsQuery(RetslyClient client){
        super(client);
        this.resource = "agent";
    }

    @Override 
    protected Agent createResource(JSONObject json){
    	return new Agent(json);
    }
}

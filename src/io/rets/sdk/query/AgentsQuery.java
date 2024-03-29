package io.rets.sdk.query;

import io.rets.sdk.RetslyClient;
import io.rets.sdk.resources.Agent;

import org.json.JSONObject;

/**
 * Created by matthewsa on 4/28/15.
 */
public class AgentsQuery extends Query<Agent> {

    public AgentsQuery(RetslyClient client){
        super(client);
        this.resource = "agents";
    }

    @Override 
    protected Agent createResource(JSONObject json){
    	return new Agent(json);
    }
    public AgentsQuery where(Agent.AgentProperties agentProp, Query.Operators op, String value){
    	this.where(agentProp.toString(),op,value);
    	return this;
    }
}

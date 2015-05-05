package io.rets.sdk.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import io.rets.sdk.RetslyClient;
import io.rets.sdk.query.Query.Operators;
import io.rets.sdk.resources.Agent;
import io.rets.sdk.resources.Agent.AgentProperties;

import org.apache.http.HttpException;
import org.json.JSONException;
import org.junit.Test;

public class AgentsTest {
   RetslyClient retsly = new RetslyClient("758a506ca74740f7d2b265597114e0d2");

   @Test
	public void BasicAgentsQuery() throws JSONException, IOException, HttpException {
       List<Agent> agents = retsly
    		.agents()
            .findAll();
       
       assertTrue("Returns agents", !agents.isEmpty());

       for(Agent l : agents){
           assertTrue("has name", l.getFullName().length() > 0);
       }
    }	
	@Test
	public void SingleAgentQuery() throws JSONException, IOException, HttpException {
		Agent agent = retsly
    		.agents()
            .findOne();
       assertTrue("Returns agent full name", agent.getFullName().length()  > 0);
       assertTrue("Returns agent id", agent.getId().length() > 20);
   }	
	
	@Test
	public void SingleAgentByIDQuery() throws JSONException, IOException, HttpException {
		Agent agent1 = retsly
	    		.agents()
	            .findOne();
		Agent agent2 = retsly
    		.agents()
            .findById(agent1.getId());
       
       assertTrue("Returns agent full name", agent2.getFullName().length()  > 0);
       assertTrue("Returns agent id", agent2.getId().length() > 20);
       assertTrue("agents equal", agent2.equals(agent1));
   }	
	
	@Test
	public void WhereAgents() throws JSONException, IOException, HttpException {
		List<Agent> agents = retsly
	    		.agents()
	    		.where(AgentProperties.title, Operators.eq, "California")
	            .findAll();
           
    //for(Agent l : agents){
    //	   assertTrue("All agents greater than query amount", l.getPrice() > 500000 );
    //   }
	}
}

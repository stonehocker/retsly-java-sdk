package io.rets.sdk.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import io.rets.sdk.RetslyClient;
import io.rets.sdk.exception.RetslyException;
import io.rets.sdk.query.Query.Operators;
import io.rets.sdk.resources.Agent;
import io.rets.sdk.resources.Agent.AgentProperties;

import org.junit.Test;

public class AgentsTest {
   RetslyClient retsly = new RetslyClient(RetslyTest.VALID_AUTH_TOKEN);

   /*@Test
   public void Testhttp1() throws Exception {
	   URL url = new URL("https://rets.io/api/v1/test_sf/listings?access_token="+ RetslyTest.VALID_AUTH_TOKEN);
	   java.net.URLConnection urlConnection = url.openConnection();
	   java.io.InputStream in = urlConnection.getInputStream();
	   
   }*/
   
   @Test
	public void BasicAgentsQuery() throws IOException, RetslyException {
       List<Agent> agents = retsly
    		.agents()
            .findAll();
       
       assertTrue("Returns agents", !agents.isEmpty());

       for(Agent l : agents){
           assertTrue("has name", l.getFullName().length() > 0);
       }
    }	
	@Test
	public void SingleAgentQuery() throws IOException, RetslyException {
		Agent agent = retsly
    		.agents()
            .findOne();
       assertTrue("Returns agent full name", agent.getFullName().length()  > 0);
       assertTrue("Returns agent id", agent.getId().length() > 20);
   }	
	
	@Test
	public void SingleAgentByIDQuery() throws IOException, RetslyException {
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
	public void WhereAgents() throws IOException, RetslyException {
		List<Agent> agents = retsly
	    		.agents()
	    		.where(AgentProperties.title, Operators.eq, "California")
	            .findAll();
           
    //for(Agent l : agents){
    //	   assertTrue("All agents greater than query amount", l.getPrice() > 500000 );
    //   }
	}
}

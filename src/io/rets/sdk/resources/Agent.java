package io.rets.sdk.resources;

import org.json.JSONObject;

/**
 * Created by matthewsa on 4/24/15.
 */
public class Agent extends MediaResource{

	public enum AgentProperties{
		agentID,firstName,lastName,middleName,fullName,cellPhone,homePhone,
		officeID,officePhone,officeName,email,title
	}
    public Agent(JSONObject o) {
		super(o);
	}
    public String getAgentID(){
    	return getString(AgentProperties.agentID.toString());
    }
    public String getFirstName(){
    	return getString(AgentProperties.firstName.toString());
    }
    public String getLastName(){
    	return getString(AgentProperties.lastName.toString());
    }
    public String getMiddleName(){
    	return getString(AgentProperties.middleName.toString());
    }
    public String getFullName(){
    	return getString(AgentProperties.fullName.toString());
    }
    public String getCellPhone(){
    	return getString(AgentProperties.cellPhone.toString());
    }
    public String getHomePhone(){
    	return getString(AgentProperties.homePhone.toString());
    }
    public String getOfficeID(){
    	return getString(AgentProperties.officeID.toString());
    }
    public String getOfficePhone(){
    	return getString(AgentProperties.officePhone.toString());
    }
    public String getOfficeName(){
    	return getString(AgentProperties.officeName.toString());
    }
    public String getEmail(){
    	return getString(AgentProperties.email.toString());
    }
    public String getTitle(){
    	return getString(AgentProperties.title.toString());
    }
}

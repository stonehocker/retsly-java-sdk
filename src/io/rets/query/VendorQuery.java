package io.rets.query;

import io.rets.RetslyClient;
import io.rets.resources.Vendor;

import org.json.JSONObject;

public class VendorQuery extends Query<Vendor> {

	public VendorQuery(RetslyClient retsly) {
		super(retsly);
        this.resource = "vendor";
	}

	protected String buildRequestURL(){
    	return RetslyClient.RESTLY_URL + this.resource;
    }
	
	@Override
	protected Vendor createResource(JSONObject json) {
		return new Vendor(json);
	}

}

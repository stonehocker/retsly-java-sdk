package io.rets.sdk.query;

import io.rets.sdk.RetslyClient;
import io.rets.sdk.resources.Vendor;

import org.json.JSONObject;

public class VendorQuery extends Query<Vendor> {

	public VendorQuery(RetslyClient retsly) {
		super(retsly);
        this.resource = "vendors";
	}

	protected String buildRequestURL(){
    	return RetslyClient.RESTLY_URL + this.resource;
    }
	
	@Override
	protected Vendor createResource(JSONObject json) {
		return new Vendor(json);
	}

}

package io.rets.sdk.resources.pub;

import io.rets.sdk.resources.MediaResource;
import io.rets.sdk.resources.Resource;

import org.json.JSONObject;

/**
 * Created by matthewsa on 4/24/15.
 */
public class Assessment extends Parcel{

	public enum AssessmentProperties{
		id,apn,fips,county,state,
		taxID,taxAmount,taxYear, year,
		landValue,improvementValue, totalValue,
		landUseGeneral, landUseCode, landUseDescription,
		zoningCode, zoningDescription, numberOfBuildings,
		lotSizeAcres, lotSizeSquareFeet, lotSizeFrontage, lotSizeDepth,
		//ownerName, coordinates,
		//building, address
	}
    //TODO Get owner, get coordinates
    //TODO Get owner, get coordinates

	public enum NonSearchableAssessmentProperties{
		censusTract, taxExemption, lotSizeIrregular,
		lotTopography, legal
	}


	protected Building building;
	
    public Assessment(JSONObject o) {
		super(o);
		this.building = getBuilding();
	}

    public String getTaxID(){
    	return getString(AssessmentProperties.taxID.toString());
    }
    public int getTaxYear(){
    	return getInteger(AssessmentProperties.taxYear.toString());
    }
    public double getTaxAmount(){
    	return getDouble(AssessmentProperties.taxAmount.toString());
    }
    
    public double getLandValue(){
    	return getInteger(AssessmentProperties.landValue.toString());
    }
    public double getTotalValue(){
    	return getDouble(AssessmentProperties.totalValue.toString());
    }
    public double getImprovmentValue(){
    	return getDouble(AssessmentProperties.improvementValue.toString());
    }
    
}

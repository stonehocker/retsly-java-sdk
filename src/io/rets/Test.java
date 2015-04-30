package io.rets;

import java.awt.List;

import org.apache.http.message.BasicNameValuePair;

/**
 * Created by matthewsa on 4/28/15.
 */
public class Test {
    public static void main(String[] args){
        try {


            RetslyClient retsly = new RetslyClient("9d569d82909f34a4fb8894ff91f07b52");
            java.util.List<Listing> listings = retsly
	    		.listings()
	            .where(new BasicNameValuePair("bedrooms", "3"))
	            .limit(20)
	            .offset(0)
	            .findAll();
            
            for(Listing l : listings){
                System.out.println("---listing---");
                System.out.println(l.getAddress());
                System.out.println(l.getBeds());
                System.out.println(l.getFormatedPrice());

            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

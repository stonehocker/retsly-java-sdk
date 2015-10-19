## "This SDK is currently in development. Please contact support@rets.ly if you have any questions"

# retsly-java-sdk
Create an easy to use Java SDK for developers



### Example query

Simple Listings Example:

    RetslyClient retsly = new RetslyClient("MY_TOKEN");
    List<Listing> listings = retsly
	    		         .listings()
	    		         .vendor("imls")
	    		         .where(ListingProperty.price, Operators.gt, 500000)
	    		         .limit(10)
	    		         .offset(0)
	    		         .findAll();

See Java Docs at
http://retsly.github.io/retsly-java-sdk/doc/index.html

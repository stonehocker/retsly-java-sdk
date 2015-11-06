# retsly-java-sdk
Create an easy to use Java SDK for developers compatible with android.

### Example query

Simple Listings Example:
```
RetslyClient retsly = new RetslyClient("MY_TOKEN");
List<Listing> listings = retsly
     .listings()
     .vendor("test_sf")
     .where(ListingProperty.price, Operators.gt, 500000)
     .limit(10)
     .offset(0)
     .findAll();
```
Save Query and use next/prev for paging
```
ListingsQuery = retsly.listings()
    	          .where(ListingProperty.price, Operators.gt, 500000);
List<Listing> listingsList1 = listingQuery.findAll();
List<Listing> listingsList2 = listingQuery.next().findAll();
```    
Simple geo example:
```
ListingsQuery retsly =
     .listings()
     .vendor("test_sf")
     .near(-122.0, 37.7)
     .radius(100);
```
Using our resource specific queries we limit the where clauses to valid queries,
We however support a free query that takes the same format as our rest endpoints.

```
ListingsQuery retsly =
     .listings()
     .vendor("test_sf")
     .where("price.gt=1000000&status=Active");

```
Other reources such as Office, Member, Parcel and Assesment are also availble with their queries

For more indepth information, Please visit Java Docs at
http://retsly.github.io/retsly-java-sdk/doc/index.html

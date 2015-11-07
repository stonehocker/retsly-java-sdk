## retsly-java-sdk
Create an easy to use Java SDK for developers compatible with android.

#### Example queries

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
Other resources such as Office, Member, Parcel and Assesment are also availble with their queries

For more indepth information, Please visit Java Docs at
http://retsly.github.io/retsly-java-sdk/doc/index.html

## Async Support for Android
Extend RetslyClient
```
public class RetslyAndroidClient extends RetslyClient
{
    public RetslyAndroidClient(){
        super(OauthLoginActivity.OAUTH_TOKEN);
        this.setVendor("test_sf");
        this.setAsync(new Async() {

       @Override
       public void excuteList(final AsyncListInvoke asyncInvoke, final RetslyListCallback cb) {
           new AsyncTask<Void,Void, List>() {
               @Override
               protected List doInBackground(Void... s) {
                   try {
                       // Invoke the retsly api call in the background
                       return asyncInvoke.runList();
                   }
                   catch(Exception e){
                   }
                   return null;
               }
               @Override
               protected void onPostExecute(List result) {
                    //Receive the data in a Async manner
                   cb.getDataList(result);
                   // Update view here
               }
           }.execute();
       }
   });
}
```
```
RetslyAndroidClient retsly = new RetslyAndroidClient();
retsly.listings().findAllAysnc(new RetslyListCallback<Listing>() {
     @Override
     public void getDataList(List<Listing> data) {
        // Get Data
        // Update View
     }
});
```

Bare bones Android Sample app with Oauth availble ( Alpha )
https://github.com/Retsly/retsly-android-sample-app

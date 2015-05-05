package io.rets.sdk.resources;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaResource extends Resource{
	private JSONArray media;
	
	public MediaResource(JSONObject o) {
		super(o);
		try{
			media = o.getJSONArray("media");
		}
		catch(JSONException e){
			media = new JSONArray();
		}
	}
	
	public String getFirstMediaUrl() {
	        return getMediaUrl(0);
    }
    public String getMediaUrl(int index) {
        try {
            index = index > this.media.length() ? this.media.length() -1 : index;
            return this.media.getJSONObject(index).getString("url");
        } catch (Exception e) {
        }
        return null;
    }
    public List<String> getMediaUrls(){
        ArrayList<String> urls = new ArrayList<String>();
        for(int i = 0; i < this.media.length(); i++){
            urls.add(this.getMediaUrl(i));
        }
        return urls;
    }
    public String[] getMediaUrlsArray(){
        return this.getMediaUrls().toArray(new String[this.media.length()]);
    }
    public int getMediaLength(){
    	return this.media != null ? this.media.length() : 0;
    }
}

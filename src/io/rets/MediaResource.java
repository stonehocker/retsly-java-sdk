package io.rets;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class MediaResource extends Resource{
	private JSONArray media;
	
	public MediaResource(JSONObject o) {
		super(o);
	}
	
	public String getImageUrl() {
	        return getImageUrl(0);
    }
    public String getImageUrl(int index) {
        try {
            index = index > this.media.length() ? this.media.length() -1 : index;
            return this.media.getJSONObject(index).getString("url");
        } catch (Exception e) {
        }
        return null;
    }
    public List<String> getImageUrls(){
        ArrayList<String> urls = new ArrayList<String>();
        for(int i = 0; i < this.media.length(); i++){
            urls.add(this.getImageUrl(i));
        }
        return urls;
    }
    public String[] getImageUrlsArray(){
        return this.getImageUrls().toArray(new String[this.media.length()]);
    }
}

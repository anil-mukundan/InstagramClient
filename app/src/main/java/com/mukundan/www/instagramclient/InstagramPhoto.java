package com.mukundan.www.instagramclient;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class InstagramPhoto {
    public String username;
    public String fullname;
    public String caption;
    public String imageUrl;
    public int imageHeight;
    public int likeCount;
    public String avatar;
    public String location;
    public String weeks;

    public InstagramPhoto(String username, String fullname, String caption, String imageUrl, int imageHeight,
                          int likeCount, String avatar, String location, String timestamp) {
        this.username = username;
        this.fullname = fullname;
        this.caption = caption;
        this.imageUrl = imageUrl;
        this.imageHeight = imageHeight;
        this.likeCount = likeCount;
        this.avatar = avatar;
        this.weeks = (new Date().getTime() - Long.parseLong(timestamp))/((1000 * 60 * 60 * 24 * 7)) + "w";
        this.location = null;
        if (!location.equalsIgnoreCase("null")) {
            try {
                JSONObject locJSON = new JSONObject(location);
                this.location = locJSON.getString("name");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

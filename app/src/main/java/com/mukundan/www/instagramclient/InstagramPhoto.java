package com.mukundan.www.instagramclient;

public class InstagramPhoto {
    public String username;
    public String caption;
    public String imageUrl;
    public int imageHeight;
    public int likeCount;
    public String avatar;

    public InstagramPhoto(String username, String caption, String imageUrl, int imageHeight,
                          int likeCount, String avatar) {
        this.username = username;
        this.caption = caption;
        this.imageUrl = imageUrl;
        this.imageHeight = imageHeight;
        this.likeCount = likeCount;
        this.avatar = avatar;
    }
}

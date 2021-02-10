package com.example.printful.Models;

import com.google.gson.annotations.SerializedName;

public class Hero {
    // model class

    @SerializedName("name")
    private String name;
    private String realname;
    private String team;
    private String firstappearance;
    private String createdby;
    private String publisher;
    private String imageurl ;
    private String bio;

    public Hero(String name, String realName, String team, String firstAppearance, String createdBy, String publisher, String imageUrl, String bio) {
        this.name = name;
        this.realname = realName;
        this.team = team;
        this.firstappearance = firstAppearance;
        this.createdby = createdBy;
        this.publisher = publisher;
        this.imageurl = imageUrl;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realname;
    }

    public String getTeam() {
        return team;
    }

    public String getFirstAppearance() {
        return firstappearance;
    }

    public String getCreatedBy() {
        return createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImageUrl() {
        return imageurl;
    }

    public String getBio() {
        return bio;
    }
}

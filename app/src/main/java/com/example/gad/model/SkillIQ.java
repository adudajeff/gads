package com.example.gad.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class SkillIQ  {
    public String name;;;
    public String score;
    public String country;
    public String  badgeUrl;



    public SkillIQ(String name, String score, String Country, String badgeUrl)
    {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String hrs) {
        this.score = hrs;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }


}

package com.example.gad.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Lapi {
    @GET("/api/hours/")
    Call<List<SkillLearners>> getLearners();
    //public void getVideoList(Callback<List<SkillIQ>> callback);
}
package com.example.gad.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @GET("/api/skilliq/")
    Call<List<SkillIQ>> getlist();
    //public void getVideoList(Callback<List<SkillIQ>> callback);
}
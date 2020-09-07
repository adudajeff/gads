package com.example.gad.model;
import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GlobalFetch {

    public static  String ROOT_URL = "https://gadsapi.herokuapp.com";

    public static String  BASE_URL = getSkillsleader();
    JSONObject reader;
    public GlobalFetch()  {
       // reader = new JSONObject(ROOT_URL);
    }
    public static String getSkillsleader(){
        return  ROOT_URL;
    }

    public static String getFormBASEURL(){
        return  "https://docs.google.com/forms/d/e/";
    }


}

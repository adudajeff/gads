package com.example.gad;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gad.model.SkillApi;
import com.example.gad.model.SkillIQ;
import com.example.gad.ui.main.SkillAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentIQ extends Fragment {

    RecyclerView recyclerView;
    private List<SkillIQ> SkillList = new ArrayList<>();
    private SkillAdapter mAdapter;

    public FragmentIQ() {
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.iq_fragment, viewGroup, false);
        recyclerView =  (RecyclerView) view.findViewById(R.id.Recyclerview);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        getAllUsers();
        mAdapter = new SkillAdapter(getContext(),SkillList);
        recyclerView.setAdapter(mAdapter);
        return view;
    }
    public void onResume() {
        super.onResume();

    }

    public void getAllUsers(){

        Call<List<SkillIQ>> userlist = SkillApi.getUserService().getlist();

        userlist.enqueue(new Callback<List<SkillIQ>>() {
            @Override
            public void onResponse(Call<List<SkillIQ>> call, Response<List<SkillIQ>> response) {

                if(response.isSuccessful()) {
                   List<SkillIQ> lst=response.body();
                    for(int i=0;i<lst.size();i++){
                        String name =lst.get(i).getName();
                        String score =lst.get(i).getScore() + " Skill IQ Score, "+lst.get(i).getCountry();
                        String  country=lst.get(i).getCountry();
                        String badgeUrl=lst.get(i).getBadgeUrl();
                        SkillIQ lstadd = new SkillIQ(name,score,country,badgeUrl);
                        SkillList.add(lstadd);
                    }
                }
                mAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<SkillIQ>> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());

            }

        });


    }


}





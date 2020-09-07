package com.example.gad;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gad.R;
import com.example.gad.model.LearnersApi;
import com.example.gad.model.SkillApi;
import com.example.gad.model.SkillIQ;
import com.example.gad.model.SkillLearners;
import com.example.gad.ui.main.LearnersAdapter;
import com.example.gad.ui.main.SkillAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentLeader  extends Fragment {
    RecyclerView recyclerView;
    private List<SkillLearners> Learners = new ArrayList<>();
    private LearnersAdapter mAdapter;

    public FragmentLeader() {
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
        mAdapter = new LearnersAdapter(getContext(),Learners);
        recyclerView.setAdapter(mAdapter);
        return view;
    }
    public void onResume() {
        super.onResume();

    }

    public void getAllUsers(){

        Call<List<SkillLearners>> userlist = LearnersApi.getUserService().getLearners();

        userlist.enqueue(new Callback<List<SkillLearners>>() {
            @Override
            public void onResponse(Call<List<SkillLearners>> call, Response<List<SkillLearners>> response) {

                if(response.isSuccessful()) {
                    List<SkillLearners> lst=response.body();
                    for(int i=0;i<lst.size();i++){
                        String name =lst.get(i).getName();
                        String hours =lst.get(i).getHours() + " Learning hrs, "+lst.get(i).getCountry();
                        String  country=lst.get(i).getCountry();
                        String badgeUrl=lst.get(i).getBadgeUrl();
                        SkillLearners lstadd = new SkillLearners(name,hours,country,badgeUrl);
                        Learners.add(lstadd);
                    }
                }
                mAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<SkillLearners>> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());

            }

        });


    }

}

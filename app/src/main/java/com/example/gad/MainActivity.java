package com.example.gad;

import android.content.Intent;
import android.os.Bundle;

import com.example.gad.FragmentIQ;
import com.example.gad.FragmentLeader;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gad.ui.main.SectionsPagerAdapter;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

   private TabLayout tabLayout;
   private ViewPager viewPager;
   private SectionsPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=(TabLayout) findViewById(R.id.tabs);
        viewPager=(ViewPager) findViewById(R.id.view_pager);
        adapter=new SectionsPagerAdapter(getSupportFragmentManager());


        adapter.AddFragment(new FragmentLeader(),"Learning Leaders");
        adapter.AddFragment(new FragmentIQ(),"Skill IQ Leaders");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

     //   SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
      //  ViewPager viewPager = findViewById(R.id.view_pager);
       // viewPager.setAdapter(sectionsPagerAdapter);
      //  TabLayout tabs = findViewById(R.id.tabs);
       // tabs.setupWithViewPager(viewPager);


        Button submit= findViewById(R.id.btnsubmit);

        submit.setOnClickListener(v -> {
            Intent intent=new Intent(v.getContext(),Project.class);
            startActivity(intent);

        });

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }
}
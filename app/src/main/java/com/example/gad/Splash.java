package com.example.gad;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import static java.lang.Thread.sleep;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.intro_main);

        startActivity(new Intent(this,MainActivity.class));
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // close splash activity
       // finish();
    }
}

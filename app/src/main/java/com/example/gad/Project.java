package com.example.gad;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.gad.model.LearnersApi;
import com.example.gad.model.ProjectDetails;
import com.example.gad.model.SkillLearners;
import com.example.gad.model.SubmitProjectRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Thread.sleep;

public class Project extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.proj_submission);


        Button submit =findViewById(R.id.btnsubmit);
        submit.setOnClickListener(v -> {
            Context MContext=this;
            TextView EmailAddress= findViewById(R.id.textEmail);
            TextView FirstName= findViewById(R.id.textFirstname);
            TextView LastName= findViewById(R.id.textLastname);
            TextView LinkUrl= findViewById(R.id.textGit);

            final String   firstname= FirstName.getText().toString();
            final String   lastname= LastName.getText().toString();
            final String   emailaddress= EmailAddress.getText().toString();
            final String   giturl= LinkUrl.getText().toString();

            if (firstname.equals("")){
                Toast.makeText(MContext, "First Name Cannot Be Empty", Toast.LENGTH_LONG).show();

            }else {

                Call<ProjectDetails> postForm = SubmitProjectRetrofit.getUserService().SubmitProject(firstname, lastname, emailaddress, giturl);
                postForm.enqueue(new Callback<ProjectDetails>() {
                   final  ProgressDialog loading = ProgressDialog.show(MContext, "", "Please wait...", false, false);
                    @Override
                    public void onResponse(Call<ProjectDetails> call, Response<ProjectDetails> response) {
                        if (response.isSuccessful()) {
                            loading.dismiss();
                            Log.d("Success", "Succsess" + response.body().toString());
                            Toast.makeText(MContext, "Success" + response.body().toString(), Toast.LENGTH_LONG).show();
                        }else{
                            loading.dismiss();
                            Log.d("Error Data", "Failed" + response.body());
                        }

                    }

                    @Override
                    public void onFailure(Call<ProjectDetails> call, Throwable t) {
                        loading.dismiss();
                        Log.d("Failed", "Failed Message:" + t.toString());
                        Toast.makeText(MContext, "Success" + t.toString(), Toast.LENGTH_LONG).show();
                    }
                });
               // loading.dismiss();
                Toast.makeText(MContext, "Out Side of function" , Toast.LENGTH_LONG).show();


            }

        });

    }



}
